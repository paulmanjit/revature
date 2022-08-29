package com.revature;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ResourceBundle;

public class ConnectionFactory{
    private static Connection connection = null;
    private ConnectionFactory() {

    }
    public static Connection getConnection(){
        if (connection == null) {
            ResourceBundle bundle = ResourceBundle.getBundle("com/revature/dbConfig");
            String url = bundle.getString("url");
            String username = bundle.getString("user");
            String password = bundle.getString("password");
            try {
                connection = (Connection) DriverManager.getConnection(url, username, password);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

