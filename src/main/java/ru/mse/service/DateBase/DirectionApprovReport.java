package ru.mse.service.DateBase;

import ru.mse.service.Configuration.DBConnectionReportDirection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DirectionApprovReport {
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
            throwables.printStackTrace();
            try {
                Thread.sleep(1000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
