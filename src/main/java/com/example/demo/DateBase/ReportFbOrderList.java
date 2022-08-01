package com.example.demo.DateBase;

import com.example.demo.Configuration.DBConnection;
import com.example.demo.Models.ReportFbOrderModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportFbOrderList {

    public List<ReportFbOrderModel> SelectListReport(String dateStart,
                                                     String dateAnd,
                                                     String buro,
                                                     String order1,
                                                     String group,
                                                     String check1,
                                                     String check2,
                                                     String check3,
                                                     String check4,
                                                     String check5,
                                                     String check6,
                                                     String check7
    ) {
        Connection connection = DBConnection.connection;
        List<ReportFbOrderModel> result = new ArrayList<>();
        boolean dateStart_blank = dateStart.replaceAll("\\s+", "").isBlank();
        boolean dateAnd_blank = dateAnd.replaceAll("\\s+", "").isBlank();
        boolean buro_blank = buro.replaceAll("\\s+", "").isBlank();
        boolean order1_blank = order1.replaceAll("\\s+", "").isBlank();
        boolean group_blank = group.replaceAll("\\s+", "").isBlank();
        boolean check1_blank = check1.replaceAll("\\s+", "").isBlank();
        boolean check2_blank = check2.replaceAll("\\s+", "").isBlank();
        boolean check3_blank = check3.replaceAll("\\s+", "").isBlank();
        boolean check4_blank = check4.replaceAll("\\s+", "").isBlank();
        boolean check5_blank = check5.replaceAll("\\s+", "").isBlank();
        boolean check6_blank = check6.replaceAll("\\s+", "").isBlank();
        boolean check7_blank = check7.replaceAll("\\s+", "").isBlank();

        String dateStartWhere = "";
        String dateAndWhere = "";
        String buroWhere = "";
        String order1Where = "";
        String groupWhere = "";
        String check1Where = "";
        String check2Where = "";
        String check3Where = "";
        String check4Where = "";
        String check5Where = "";
        String check6Where = "";
        String check7Where = "";

        if(!dateStart_blank){
            dateStartWhere = " and date > '"+dateStart+"'";
        }
        if(!dateAnd_blank){
            dateAndWhere = " and date < '"+dateAnd+"'";
        }
        if(!buro_blank){
            buroWhere = " and buro = '"+buro+"'";
        }
        if(!order1_blank){
            order1Where = " and order1 = '"+order1+"'";
        }
        if(!group_blank){
            groupWhere = " and group = '"+group+"'";
        }
        if(!check1_blank){
            check1Where = " and check1 = '"+check1+"'";
        }
        if(!check2_blank){
            check2Where = " and check2 = '"+check2+"'";
        }
        if(!check3_blank){
            check3Where = " and check3 = '"+check3+"'";
        }
        if(!check4_blank){
            check4Where = " and check4 = '"+check4+"'";
        }
        if(!check5_blank){
            check5Where = " and check5 = '"+check5+"'";
        }
        if(!check6_blank){
            check6Where = " and check6 = '"+check6+"'";
        }
        if(!check7_blank){
            check7Where = " and check6 = '"+check6+"'";
        }


        try (PreparedStatement statement = connection.prepareStatement("select * from reportFborder WHERE deleted = 'false' " +
                dateStartWhere +
                dateAndWhere +
                buroWhere +
                order1Where +
                groupWhere +
                check1Where +
                check2Where +
                check3Where +
                check4Where +
                check5Where +
                check6Where +
                check7Where )) {


            ResultSet resultSet = statement.executeQuery();



            while (resultSet.next()) {
                result.add(new ReportFbOrderModel(
                                resultSet.getString("snils"),
                                resultSet.getString("fio"),
                                resultSet.getString("buro"),
                                resultSet.getString("order1"),
                                resultSet.getString("group"),
                                resultSet.getString("text"),
                                resultSet.getString("check1"),
                                resultSet.getString("check2"),
                                resultSet.getString("check3"),
                                resultSet.getString("check4"),
                                resultSet.getString("check5"),
                                resultSet.getString("check6"),
                                resultSet.getString("date"),
                                resultSet.getString("id"),
                                resultSet.getString("ip"),
                                resultSet.getString("deleted"),
                                resultSet.getString("check7")

                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }
    public int selectCountCheck(String dateStart,
                                String dateAnd, String id) {
        Connection connection = DBConnection.connection;
        boolean dateStart_blank = dateStart.replaceAll("\\s+", "").isBlank();
        boolean dateAnd_blank = dateAnd.replaceAll("\\s+", "").isBlank();
        String dateStartWhere = "";
        String dateAndWhere = "";
        if(!dateStart_blank){
            dateStartWhere = " and date > '"+dateStart+"'";
        }
        if(!dateAnd_blank){
            dateAndWhere = " and date < '"+dateAnd+"'";
        }
        int count = 0;
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT count(*) from reportFborder WHERE deleted = 'false' and check7 != '2' and check"+id+" = '2'" + dateStartWhere + dateAndWhere);
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

    public int selectCountorder(String dateStart,
                                 String dateAnd) {
        Connection connection = DBConnection.connection;
        boolean dateStart_blank = dateStart.replaceAll("\\s+", "").isBlank();
        boolean dateAnd_blank = dateAnd.replaceAll("\\s+", "").isBlank();
        String dateStartWhere = "";
        String dateAndWhere = "";
        if(!dateStart_blank){
            dateStartWhere = " and date > '"+dateStart+"'";
        }
        if(!dateAnd_blank){
            dateAndWhere = " and date < '"+dateAnd+"'";
        }
        int count = 0;
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT count(*) from reportFborder WHERE deleted = 'false' and order1 = '1' and check7 != '2'" + dateStartWhere + dateAndWhere);
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
