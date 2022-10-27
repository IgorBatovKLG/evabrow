package ru.mse.service.Services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.mse.service.Models.ReportLoad.DateBase.GetCookies;
import ru.mse.service.Models.MailtModelList;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MilitaryService {

    public MailtModelList GetListMilitary(LocalDate dateStart, LocalDate dateAnd, String buro, String district, String innerDistrict){



        String todo = "";
        Gson builder = new Gson();
        MailtModelList list = null;
        try {
            String json = "{\"Columns\":[\"LastName\",\"FirstName\",\"SecondName\",\"PersonBirthDate\",\"Address\",\"ActNumber\",\"DecisionDate\",\"InvalidityGroupName\",\"InvalidityPeriodId\",\"InvalidityBeginDate\",\"InvalidityEndDate\",\"IsPersonLiable\",\"IsPersonMilitaryAge\"]," +
                    "\"Conditions\":[" +
                    "{\"FieldName\":\"DecisionDate\",\"Value\":null,\"Values\":[\""+dateStart.toString()+"T00:00:00\",\""+dateAnd.toString()+"T00:00:00\"],\"Type\":9,\"IsNegative\":false,\"Disabled\":false}," +
                    "{\"FieldName\":\"PurposeGroupId\",\"Value\":null,\"Values\":[1,2],\"Type\":11,\"IsNegative\":false,\"Disabled\":false}," +
                    "{\"FieldName\":\"ExpDocTypeId\",\"Value\":null,\"Values\":[37],\"Type\":11,\"IsNegative\":false,\"Disabled\":false}," +
                    "{\"FieldName\":\"AdrDistrict\",\"Type\":8,\"IsNegative\":false,\"Disabled\":false,\"Value\":\""+district+"\",\"Values\":null}," +
                    "{\"FieldName\":\"ExamBuroId\",\"Type\":11,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":["+buro+"]}," +
                    "{\"FieldName\":\"AdrCityDistrict\",\"Type\":8,\"IsNegative\":false,\"Disabled\":false,\"Value\":\""+innerDistrict+"\",\"Values\":null}]" +
                    ",\"HidePeopleDoubles\":true,\"Page\":1,\"PageSize\":100,\"SortField\":null,\"IsSortDesc\":false}";

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

            list = builder.fromJson(response.body().toString(), MailtModelList.class);


        } catch (URISyntaxException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return list;
    }
}
