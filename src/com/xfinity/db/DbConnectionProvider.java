package com.xfinity.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProvider {

    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
	Class.forName("org.mariadb.jdbc.Driver");
	return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medilab", "root", "123");
    }
}
