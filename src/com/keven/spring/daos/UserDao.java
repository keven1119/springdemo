package com.keven.spring.daos;

import com.keven.spring.beans.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by keven on 16/11/16.
 */
public class UserDao implements UserDaoImpl {

    private DataSource dataSource;
    public DataSource getDataSource(){
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertUser(User user){
        String name = user.getName();
        Integer age = user.getAge();
        String sex = user.getSex();

        Connection conn = null;
        Statement stmt = null;

        try{
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO tb_user(name,age,sex) "+ "VALUE('"+name+"','" +age + "','" + sex +"')");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
