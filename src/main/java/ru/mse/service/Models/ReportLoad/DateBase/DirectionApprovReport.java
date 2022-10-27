package ru.mse.service.Models.ReportLoad.DateBase;

import org.springframework.cglib.core.Local;
import ru.mse.service.Configuration.DBConnectionReportDirection;
import ru.mse.service.Models.EvaModelDirectionNotSent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


public class DirectionApprovReport {

    private int Random(){
        int i = new Random().nextInt(15);
        return i + 15;
    }

    public boolean InsertApprov(String LastName,
                                        String FirstName,
                                        String SecondName,
                                        String Snils,
                                        String Buro,
                                        String RegNumber,
                                        String Org,
                                        String OgrnOrg,
                                        String tipDir,
                                        String sogl,
                                        String text,
                                        String ip) {

        Connection connection = DBConnectionReportDirection.connection;

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO ReportDirection VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            statement.setString(2, LastName);
            statement.setString(3, FirstName);
            statement.setString(4, SecondName);
            statement.setString(5, Snils);
            statement.setString(6, Buro);
            statement.setString(7, RegNumber);
            statement.setString(8, Org);
            statement.setString(9, OgrnOrg);
            statement.setString(10, tipDir);
            statement.setString(11, sogl);
            statement.setString(12, text);
            statement.setString(13, LocalDate.now().toString());
            statement.setString(14, ip);

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

    public boolean updateDoSent(String SNILS) {
        int countInSnilsDoSent = getCountInSnilsDoSent(SNILS);
        Connection connection = DBConnectionReportDirection.connection;
        if (countInSnilsDoSent==1) {
            try (PreparedStatement statement = connection.prepareStatement("UPDATE DoSent SET sent = 'true' WHERE SNILS = (?)")) {
                statement.setString(1, SNILS);
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                        " База занята");
                try {
                    Thread.sleep(5000 * Random());
                } catch (InterruptedException ee) {
                    ee.printStackTrace();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private int getCountInSnilsDoSent(String SNILS){
        Connection connection = DBConnectionReportDirection.connection;
        int count = 0;
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT count(*) from DoSent where SNILS= '" + SNILS + "'");
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

    public ArrayList<EvaModelDirectionNotSent> notSentArrayList (){
        Connection connection = DBConnectionReportDirection.connection;
        ArrayList<EvaModelDirectionNotSent> notSentArrayList = new ArrayList<>();
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * from DoSent where sent = 'false' ORDER BY ExamBuroName");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                notSentArrayList.add(new EvaModelDirectionNotSent(
                        resultSet.getString("Hash"),
                        resultSet.getString("SNILS"),
                        resultSet.getString("ExamBuroName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("SecondName")
                ));


            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return notSentArrayList;
        }
        return notSentArrayList;
    }
    public int getCountInSnilsSent(String SNILS){
        Connection connection = DBConnectionReportDirection.connection;
        int count = 0;
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT count(*) from ReportDirection where SNILS= '" + SNILS + "'");
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
