package ru.mse.service.DateBase;

import ru.mse.service.Configuration.DBConnection;
import ru.mse.service.Configuration.DBConnectionFSS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FSSDatebase {
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
            System.out.println(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return true;
        }
        return false;
    }
}
