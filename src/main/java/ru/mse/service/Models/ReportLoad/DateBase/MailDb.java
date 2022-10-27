package ru.mse.service.Models.ReportLoad.DateBase;

import org.springframework.stereotype.Repository;
import ru.mse.service.Configuration.DBConnectionMail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class MailDb {

    private int Random(){
        int i = new Random().nextInt(15);
        return i + 15;
    }

    public boolean addTrack(String track, String buro){
        Connection connection = DBConnectionMail.connection;

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Tracks VALUES (?,?,?,?)")) {
            statement.setString(2, track);
            statement.setString(3, buro);
            statement.setString(4, "true");
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

    public List<String> getListTrackByBuroAndActive(String buro, String active){
        Connection connection = DBConnectionMail.connection;
        List<String> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT track FROM Tracks WHERE buro = ? AND active = ?")) {
            statement.setString(1, buro);
            statement.setString(2, active);
            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                list.add(resultSet.getString(1));
            }
        } catch (SQLException throwables) {

        }
        return list;
    }

    public String getJsonByIdTrack(String track){
        Connection connection = DBConnectionMail.connection;
        String json = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT jsonHistory FROM History WHERE track = ?")) {
            statement.setString(1, track);
            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                json = resultSet.getString(1);
            }
        } catch (SQLException throwables) {

        }
        return json;
    }

}

