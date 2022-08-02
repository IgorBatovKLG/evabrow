package ru.mse.service.DateBase;

import ru.mse.service.Models.NewsModel;
import ru.mse.service.Configuration.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewsDb {

    public ArrayList<NewsModel> SelectNews(){
        int i = countNews();

        ArrayList<NewsModel> result = new ArrayList<>();

        try (PreparedStatement statement = DBConnection.connection.prepareStatement("SELECT * from NewsReport where id <"+(i+1)+" and id > "+ (i-10))) {


            ResultSet resultSet = statement.executeQuery();



            while (resultSet.next()) {
                result.add(new NewsModel(

                                resultSet.getInt("id"),
                                resultSet.getString("date"),
                                resultSet.getString("text"),
                                resultSet.getString("headline"),
                                resultSet.getString("href"),
                                resultSet.getString("hrefBool")

                        )

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }

    private int countNews(){
        int count = 0;
        try {
            PreparedStatement pstmt;
            pstmt = DBConnection.connection.prepareStatement("SELECT seq from sqlite_sequence where name='NewsReport'");
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
