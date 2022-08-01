package com.example.demo.DateBase;

import com.example.demo.Configuration.DBConnection;
import com.example.demo.Models.ReportFbOrderModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class Direction {

    public HashMap<String, String> getCookies(){
        HashMap<String, String> cookies = new HashMap<>();
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("select name, VALUE from cookies")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cookies.put(resultSet.getString(1), resultSet.getString(2));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return cookies;
        }
        return cookies;


    }
}
