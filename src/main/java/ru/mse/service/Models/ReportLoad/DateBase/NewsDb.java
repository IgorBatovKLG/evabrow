package ru.mse.service.Models.ReportLoad.DateBase;

import org.springframework.ui.Model;
import ru.mse.service.Models.NewsModel;
import ru.mse.service.Configuration.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class NewsDb {

    private int Random(){
        int i = new Random().nextInt(15);
        return i + 15;
    }

    public ArrayList<NewsModel> SelectNews(){
        int i = countNews();

        ArrayList<NewsModel> result = new ArrayList<>();

        try (PreparedStatement statement = DBConnection.connection.prepareStatement("select * from NewsReport ORDER by id DESC LIMIT 10")) {

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

    public ArrayList<NewsModel> SelectHistoryNews(){
        int i = countNews();

        ArrayList<NewsModel> result = new ArrayList<>();

        try (PreparedStatement statement = DBConnection.connection.prepareStatement("select * from NewsReport ORDER by id DESC LIMIT 30")) {

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

    public boolean addNews(NewsModel model){
        try {
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement("INSERT INTO NewsReport VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(2, LocalDate.now().toString());
            preparedStatement.setString(3, model.getText());
            preparedStatement.setString(4, model.getHeadline());
            preparedStatement.setString(5, model.getHref());
            preparedStatement.setString(6, model.getHrefBool());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                    " База занята");
            try {
                Thread.sleep(2000 * Random());
            } catch (InterruptedException ee) {
                ee.printStackTrace();
            }
            return true;
        }

        return false;
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
