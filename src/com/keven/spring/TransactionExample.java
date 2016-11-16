package com.keven.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by keven on 16/11/16.
 */
public class TransactionExample {
    DataSource dataSource;
    PlatformTransactionManager transactionManager;
    TransactionTemplate transactionTemplate;

    public static void main (String[] args){
        ClassPathResource classPathResource = new ClassPathResource("/applicationContext.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        TransactionExample transactionExample = (TransactionExample) xmlBeanFactory.getBean("transactionExample");
        transactionExample.transactionOperation();
    }

    public void transactionOperation(){
        transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                Connection connection = DataSourceUtils.getConnection(dataSource);

                try {
                    Statement statement = connection.createStatement();
                    statement.execute("insert into tb_user(name,age,sex) values('keven','26','female')");
                    statement.execute("insert into tb_user(name,age,sex) values('marry','22','male')");

                    System.out.println("操作执行成功");
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("操作执行失败，事务回滚");
                }
                return null;
            }
        });
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}

