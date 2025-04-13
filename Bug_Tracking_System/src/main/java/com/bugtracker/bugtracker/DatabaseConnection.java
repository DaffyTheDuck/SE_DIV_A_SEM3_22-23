package com.bugtracker.bugtracker;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseUser = "root";
        String databasePassword = "root";
        String url = "jdbc:mysql://localhost:3306/bug-tracker";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            System.out.println("Connection Successful!");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("Connection Failed!");
        }

        return databaseLink;
    }
}
