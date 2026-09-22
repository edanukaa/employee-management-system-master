package com.ems.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static String url = "jdbc:sqlserver://h:1433;databaseName=EmployeeManagementDB; encrypt=true; trustServerCertificate=true;";
    public static String user = "Dinaa";
    public static String password = "dinaa";


    public static Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
