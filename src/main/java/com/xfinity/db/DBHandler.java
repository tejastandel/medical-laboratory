package com.xfinity.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandler {

    public static int setData(Connection connection, String sql, Object... rowData) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        if (rowData != null) {
            for (int i = 0; i < rowData.length; i++) {
                preparedStatement.setObject(i + 1, rowData[i]);
            }
        }
        int response = preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return response;
    }

    public static ResultSet getData(Connection connection, String sql, Object... rowData) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return getData(preparedStatement, rowData);
    }

    public static ResultSet getData(PreparedStatement preparedStatement, Object... rowData) throws SQLException {
        if (rowData != null) {
            for (int i = 0; i < rowData.length; i++) {
                preparedStatement.setObject(i + 1, rowData[i]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    

}
