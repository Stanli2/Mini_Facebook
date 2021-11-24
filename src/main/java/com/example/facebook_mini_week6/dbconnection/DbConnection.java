package com.example.facebook_mini_week6.dbconnection;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public enum DbConnection {

    INSTANCE;

    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/facebookclone?serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Funachukwu23";
    private static Connection connection;

    private static DataSource getDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();




        dataSource.setUrl(DATABASE_URL);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);

        return  dataSource;
    }

    public Connection getConnection(){

        connection= null;

        try {
            connection =  getDataSource().getConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }


    public void closeConnection(){

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void isConnectionValid(){

        try {

            System.out.println(connection.isValid(0));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
