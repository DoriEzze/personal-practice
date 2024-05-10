package com.accenture.practice.utils;

import com.accenture.practice.config.DbConfig;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class BlobToByteArray {

    @Value("${url}")
    private static String db_url;

    @Value("${driverClassName}")
    private String driverClassName;

    public static byte[] convertToByteArray() throws SQLException {
        byte[] bytes = null;
        Connection connection = DriverManager.getConnection(db_url);
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM Album";
        ResultSet set = statement.executeQuery(sql);
        while(set.next()) {
            Blob blob = set.getBlob("Column1");
            bytes = blob.getBytes(1L, (int) blob.length());
        }
        return bytes;
    }
}
