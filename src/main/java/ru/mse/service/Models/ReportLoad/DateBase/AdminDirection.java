package ru.mse.service.Models.ReportLoad.DateBase;

import ru.mse.service.Configuration.DBConnectionReportDirection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDirection {

    public int getCountDirection(String tipDir, String sogl, String dateStart, String dateAnd){
        Connection connection = DBConnectionReportDirection.connection;
        int count= 0;
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("select count(*) from ReportDirection where tipDir=? and sogl=? and date>=? and date<=?");
            pstmt.setString(1, tipDir);
            pstmt.setString(2, sogl);
            pstmt.setString(3, dateStart);
            pstmt.setString(4, dateAnd);
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

    public int getCountDirectionFull(String dateStart, String dateAnd){
        Connection connection = DBConnectionReportDirection.connection;
        int count= 0;
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("select count(*) from ReportDirection where date>=? and date<=?");
            pstmt.setString(1, dateStart);
            pstmt.setString(2, dateAnd);
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
