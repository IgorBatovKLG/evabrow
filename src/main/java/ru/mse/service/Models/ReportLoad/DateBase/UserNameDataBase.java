package ru.mse.service.Models.ReportLoad.DateBase;

import ru.mse.service.Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserNameDataBase {

    public static String getIp(String ip){
        String string = ip;
        Connection connection = DBConnection.connection;
        try(PreparedStatement statement = connection.prepareStatement("SELECT name from ipUsers where ip=(?)")) {
            statement.setString(1, ip);
            ResultSet resultSet = statement.executeQuery();
            try {

                string = resultSet.getString(1);
            } catch (SQLException e){
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return string;
        }
        return string;
    }
}
