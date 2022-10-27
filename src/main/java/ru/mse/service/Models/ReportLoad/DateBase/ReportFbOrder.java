package ru.mse.service.Models.ReportLoad.DateBase;

import ru.mse.service.Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ReportFbOrder {

    private int Random(){
        int i = new Random().nextInt(15);
        return i + 15;
    }

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
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                    " База занята");
            try {
                Thread.sleep(1000*Random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
