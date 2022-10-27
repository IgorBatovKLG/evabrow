package ru.mse.service.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTimeExpertise {

    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:/TEMP/db/TimeEx.db");
        } catch (SQLException e) {
            System.out.println("Проблемы с подключением к базе данных");
            e.printStackTrace();
        }
    }

}