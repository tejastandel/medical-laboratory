package com.xfinity.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnectionProvider {

    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Properties props = new Properties();
        try (FileInputStream savedProperties = new FileInputStream("application-properties.conf")) {
            props.load(savedProperties);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DbConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DbConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", props.getProperty("host"), props.getProperty("port"), props.getProperty("db")), props.getProperty("user"), props.getProperty("password"));
    }
}
