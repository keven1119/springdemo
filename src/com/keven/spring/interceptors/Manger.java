package com.keven.spring.interceptors;

import com.keven.spring.beans.User;
import com.keven.spring.daos.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by keven on 16/11/15.
 */
public class Manger {
    public static void main(String[] args){
//        Target target = new Target();
//        ProxyFactory proxyFactory = new ProxyFactory();
//
//        proxyFactory.addAdvice(new LoggerExecute());
//        proxyFactory.setTarget(target);
//        Target proxy = (Target) proxyFactory.getProxy();
//        proxy.execute("AOP的简单实现");

//        Pointcut pointcut = new TestStaticPointcut();
//        Advice advice = new TestAdvice();
//
//        NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor = new NameMatchMethodPointcutAdvisor(advice);
//        nameMatchMethodPointcutAdvisor.addMethodName("eat");
//
//
//        Target target = new Target();
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(target);
//        proxyFactory.addAdvisor(nameMatchMethodPointcutAdvisor);
//        Target proxy = (Target) proxyFactory.getProxy();
//
//        proxy.eat("海鲜");

        Resource resource = new ClassPathResource("/applicationContext.xml");

        BeanFactory factory = new XmlBeanFactory(resource);
        try {

            User user = new User();
            user.setName(new String("张三".getBytes("utf-8"),"utf-8"));
            user.setAge(new Integer(30));
            user.setSex("男");

            UserDao userDAO = (UserDao) factory.getBean("userDAO");
            userDAO.insertUser(user);
            System.out.println("数据添加成功");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
