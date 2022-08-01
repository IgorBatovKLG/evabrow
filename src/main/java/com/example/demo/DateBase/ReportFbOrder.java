package com.example.demo.DateBase;

import com.example.demo.Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReportFbOrder {
    public boolean createPalliativeInDb(String snils,
                                     String fio,
                                     String buro,
                                     String order,
                                     String group,
                                     String text,
                                     String check1,
                                     String check2,
                                     String check3,
                                     String check4,
                                     String check5,
                                     String check6,
                                     String check7,
                                     String date,
                                     String ip) {

        Connection connection = DBConnection.connection;

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO reportFbOrder VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            statement.setString(1, snils);
            statement.setString(2, fio);
            statement.setString(3, buro);
            statement.setString(4, order);
            statement.setString(5, group);
            statement.setString(6, text);
            statement.setString(7, check1);
            statement.setString(8, check2);
            statement.setString(9, check3);
            statement.setString(10, check4);
            statement.setString(11, check5);
            statement.setString(12, check6);
            statement.setString(13, date);
            statement.setString(15, ip);
            statement.setString(16, "false");
            statement.setString(17, check7);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            return true;
        }
        return false;
    }
}
