package ru.mse.service.Models.ReportLoad.DateBase.Admin;

import ru.mse.service.Configuration.DBConnectionErrorDirection;
import ru.mse.service.Models.DirectionErrorOrControlModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DirectionErrorOrControl {

    public ArrayList<DirectionErrorOrControlModel> getModelListError (){
        Connection connection = DBConnectionErrorDirection.connection;
        ArrayList<DirectionErrorOrControlModel> notSentArrayList = new ArrayList<>();
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * from Directions left join Error on Directions.id = Error.idDirection\n" +
                    "         where error1=1 or error2=1 or error3=1 or error4=1 or error5=1 or error6=1");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                notSentArrayList.add(DirectionErrorOrControlModel.builder()
                        .url(resultSet.getString("url"))
                        .regNum(resultSet.getString("regNum"))
                        .regDate(resultSet.getString("regDate"))
                        .Stage(resultSet.getString("Stage"))
                        .refIssDate(resultSet.getString("refIssDate"))
                        .fio(resultSet.getString("fio"))
                        .recDate(resultSet.getString("recDate"))
                        .error1(resultSet.getBoolean("error1"))
                        .error2(resultSet.getBoolean("error2"))
                        .error3(resultSet.getBoolean("error3"))
                        .error4(resultSet.getBoolean("error4"))
                        .error5(resultSet.getBoolean("error5"))
                        .error6(resultSet.getBoolean("error6"))
                        .build());


            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return notSentArrayList;
        }
        return notSentArrayList;
    }


}
