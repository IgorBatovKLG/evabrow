package ru.mse.service.Models.ReportLoad.DateBase;

import ru.mse.service.Configuration.DBConnection;
import ru.mse.service.Configuration.DBConnectionFSS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class FSSDatebase {

    private int Random(){
        int i = new Random().nextInt(15);
        return i + 15;
    }

    public boolean createInvateInDB(String snils,
                                        String date,
                                        String time,
                                        String buro,
                                        String name,
                                        String ip) {

        Connection connection = DBConnectionFSS.connection;

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO invateFSS VALUES (?,?,?,?,?,?,?)")) {
            statement.setString(2, buro);
            statement.setString(3, name);
            statement.setString(4, snils);
            statement.setString(5, date);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setString(7, ip);


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
