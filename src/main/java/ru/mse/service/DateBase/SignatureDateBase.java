package ru.mse.service.DateBase;


import ru.mse.service.Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignatureDateBase {

    public String getJsonWorkers(int id){
        String string = "";
        Connection connection = DBConnection.connection;
        try(PreparedStatement statement = connection.prepareStatement("SELECT json from WorkersSignature where id=(?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            try {

                string = resultSet.getString(1);
            } catch (SQLException e){
                System.out.println("Нет информации" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return string;
        }
    return string;
    }

    public String getJsonBuro(int id){
        String string = "";
        Connection connection = DBConnection.connection;
        try(PreparedStatement statement = connection.prepareStatement("SELECT json from BuroSignature where id=(?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            try {

                string = resultSet.getString(1);
            } catch (SQLException e){
                System.out.println("Нет информации" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return string;
        }
        return string;
    }

    public String getIDWorkers(String date){
        String string = "";
        Connection connection = DBConnection.connection;
        try(PreparedStatement statement = connection.prepareStatement("SELECT json from WorkersSignature where date=(?)")) {
            statement.setString(1, date);
            ResultSet resultSet = statement.executeQuery();
            try {

                string = resultSet.getString(1);
            } catch (SQLException e){
                System.out.println("Нет информации на дату");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return string;
        }
        return string;
    }

    public String getIDBuro(String date){
        String string = "";
        Connection connection = DBConnection.connection;
        try(PreparedStatement statement = connection.prepareStatement("SELECT json from BuroSignature where date=(?)")) {
            statement.setString(1, date);
            ResultSet resultSet = statement.executeQuery();
            try {

                string = resultSet.getString(1);
            } catch (SQLException e){
                System.out.println("Нет информации на дату");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return string;
        }
        return string;
    }


}
