package com.sun.controller;

import java.sql.*;

public class DBconnection {
    private Connection connection;
    public Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            this.connection= DriverManager.getConnection(
                    "jdbc:oracle:thin:@//192.168.4.53:1521/travelbox","TRAINING","TRAINING");
            return connection;
        }catch (Exception e){}
            return null;
    }
}
