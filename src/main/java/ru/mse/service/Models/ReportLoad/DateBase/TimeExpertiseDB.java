package ru.mse.service.Models.ReportLoad.DateBase;

import ru.mse.service.Configuration.DBConnectionTimeExpertise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeExpertiseDB {

    public String getJson(){
        Connection connection = DBConnectionTimeExpertise.connection;
        String json = "[]";
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT json from TimeReport where id=" + getCount());
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                json = resultSet.getString(1);
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }

    public String getLastTime(){
        Connection connection = DBConnectionTimeExpertise.connection;
        String json = "[]";
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT time from LastTime where id= 1");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                json = resultSet.getString(1);
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }

    public int getCount(){
        Connection connection = DBConnectionTimeExpertise.connection;
        int count = 0;
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT seq from sqlite_sequence where name='TimeReport'");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                count = resultSet.getInt(1);
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return count;
        }
        return count;
    }
}
