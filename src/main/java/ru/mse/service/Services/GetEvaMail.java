package ru.mse.service.Services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.mse.service.Models.ReportLoad.DateBase.GetCookies;
import ru.mse.service.Models.EvaReportModelList;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class GetEvaMail {

    public String GetListMail(String date, String buro){

        String todo = "";
        Gson builder = new Gson();
        EvaReportModelList evaReportModelList = null;

        try {
            String json = "{\"Columns\":[\"ExamBuroName\",\"InvalidityGroupName\",\"FirstName\",\"SecondName\",\"LastName\",\"DecisionDate\",\"BlankNumber\",\"IpraChildNumber\",\"IpraNumber\",\"Address\",\"PersonGender\",\"BuroManagerName\",\"ExpSostavManagerName\",\"PatientRepPersonLastName\",\"PatientPersonAge\",\"PurposesXml\",\"InvalidityPeriodId\"]," +
                    "\"Conditions\":[" +
                    "{\"FieldName\":\"DecisionDate\",\"Value\":null,\"Values\":[\""+date+"T00:00:00\",\""+date+"T00:00:00\"],\"Type\":9,\"IsNegative\":false,\"Disabled\":false},{\"FieldName\":\"ExaminationPurposeID\",\"Type\":17,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[6,8,10]}," +

                    "{\"FieldName\":\"ExamBuroId\",\"Type\":11,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[\""+buro+"\"]}" +
                    "],\"HidePeopleDoubles\":false,\"Page\":1,\"PageSize\":100,\"SortField\":null,\"IsSortDesc\":false}";

            HttpClient client = HttpClient.newHttpClient();
            GetCookies getCookies = new GetCookies();
            HashMap<String, String> cookies = getCookies.getCookies();

            ArrayList keyCookies = new ArrayList(cookies.keySet());
            String Cookie = keyCookies.get(0) +"="+ cookies.get(keyCookies.get(0)) +"; "+ keyCookies.get(1) +"="+ cookies.get(keyCookies.get(1));

            HttpRequest request  = HttpRequest.newBuilder().uri(new URI("http://dbs/eva/Search/SearchData"))
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:99.0) Gecko/20100101 Firefox/99.0")
                    .header("Content-Type","application/json; charset=utf-8")
                    .header("Cookie", Cookie)
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            evaReportModelList = builder.fromJson(response.body().toString(), EvaReportModelList.class);
            todo = response.body().toString();


        } catch (URISyntaxException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return todo;
        //return evaReportModelList;
    }
    public String GetListMailSNILS(String date, String SNILS, String buro){

        String todo = "";
        Gson builder = new Gson();
        EvaReportModelList evaReportModelList = null;

        try {
            String json = "{\"Columns\":[\"ExamBuroName\",\"InvalidityGroupName\",\"FirstName\",\"SecondName\",\"LastName\",\"DecisionDate\",\"BlankNumber\",\"IpraChildNumber\",\"IpraNumber\",\"Address\",\"PersonGender\",\"BuroManagerName\",\"ExpSostavManagerName\",\"PatientRepPersonLastName\",\"PatientPersonAge\",\"PurposesXml\",\"InvalidityPeriodId\"],\"Conditions\":[{\"FieldName\":\"ExamTime\",\"Type\":9,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[\""+date+"T00:00:00\",\""+date+"T00:00:00\"]},{\"FieldName\":\"ExamBuroId\",\"Type\":11,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":["+buro+"]},{\"FieldName\":\"SNILS\",\"Type\":8,\"IsNegative\":false,\"Disabled\":false,\"Value\":\""+SNILS+"\",\"Values\":null},{\"FieldName\":\"ExaminationPurposeID\",\"Type\":17,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[6,8]}],\"HidePeopleDoubles\":false,\"Page\":1,\"PageSize\":100,\"SortField\":null,\"IsSortDesc\":false}";

            HttpClient client = HttpClient.newHttpClient();
            GetCookies getCookies = new GetCookies();
            HashMap<String, String> cookies = getCookies.getCookies();

            ArrayList keyCookies = new ArrayList(cookies.keySet());
            String Cookie = keyCookies.get(0) +"="+ cookies.get(keyCookies.get(0)) +"; "+ keyCookies.get(1) +"="+ cookies.get(keyCookies.get(1));

            HttpRequest request  = HttpRequest.newBuilder().uri(new URI("http://dbs/eva/Search/SearchData"))
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:99.0) Gecko/20100101 Firefox/99.0")
                    .header("Content-Type","application/json; charset=utf-8")
                    .header("Cookie", Cookie)
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            evaReportModelList = builder.fromJson(response.body().toString(), EvaReportModelList.class);
            todo = response.body().toString();


        } catch (URISyntaxException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return todo;
        //return evaReportModelList;
    }
}
