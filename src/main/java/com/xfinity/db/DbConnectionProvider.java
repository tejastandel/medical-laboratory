package com.xfinity.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProvider {//2.707949508

    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medilab", "root", "1234");
    }
}
