package ru.mse.service.Services;

import ru.mse.service.Models.ReportLoad.DateBase.GetCookies;
import ru.mse.service.Models.EvaReportModelList;
import com.google.gson.Gson;
import ru.mse.service.Models.ReportLoad.EvaModelCountExpertise;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class GetEva {

    public EvaReportModelList getEvaModel(String Snils){
        Gson builder = new Gson();
        EvaReportModelList evaReportModelList = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String start = LocalDate.now().minusDays(7).format(formatter).toString();
        String and = LocalDate.now().plusDays(7).format(formatter).toString();
        try {
            String json = "{\"Columns\":[\"ExamBuroName\",\"LastName\",\"FirstName\",\"SecondName\",\"SNILS\",\"ReferralOrganizationComment\",\"ReferralOrganizationOGRN\",\"RequestRegNumber\"],\"Conditions\":[{\"FieldName\":\"ExamTime\",\"Type\":9,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[\""+start+"T00:00:00\",\""+and+"T00:00:00\"]},{\"FieldName\":\"BaseDocTypeId\",\"Type\":11,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[9]},{\"FieldName\":\"ExamBuroId\",\"Type\":11,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[1001700,1001693,1001684,1001685,1001687,1001688,1001690,1001683,1001692,1001694,1001697,1001699,1001686,1001689,1001691,1329,1001700,1001693,1001695,1001684,1001685,1001687,1001688,1001690,1001683,1001692,1001694,1001697,1001699,1001701,1001686,1001689,1001691,1001696,1001698,1001696]},{\"FieldName\":\"SNILS\",\"Type\":8,\"IsNegative\":false,\"Disabled\":false,\"Value\":\""+Snils+"\",\"Values\":null}],\"HidePeopleDoubles\":false,\"Page\":1,\"PageSize\":100,\"SortField\":null,\"IsSortDesc\":false}";

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


        } catch (URISyntaxException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return evaReportModelList;
    }

    public int getCountExpertise(int idBuro, String month, String year){
        int monthInt = Integer.parseInt(month);
        int yearInt = Integer.parseInt(year);

        String dateStart = yearInt + "-" + (monthInt - 1) + "-25";
        if (monthInt<11) {
            dateStart = yearInt + "-0" + (monthInt - 1) + "-25";
        }
        if (monthInt==1){
            dateStart = (yearInt-1) + "-0" + 12 + "-25";
        }
        String dateEnd = year + "-" + (month) + "-24";
        Gson builder = new Gson();
        EvaModelCountExpertise evaModelCountExpertise = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String start = LocalDate.now().minusDays(7).format(formatter).toString();
        String and = LocalDate.now().plusDays(7).format(formatter).toString();
        try {
            String json = "{\"Columns\":[\"ProtocolNumber\"],\"Conditions\":[{\"FieldName\":\"ExamTime\",\"Type\":9,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[\""+dateStart+"T00:00:00\",\""+dateEnd+"T00:00:00\"]},{\"FieldName\":\"ExamBuroId\",\"Type\":11,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":["+idBuro+"]}],\"HidePeopleDoubles\":false,\"Page\":1,\"PageSize\":100,\"SortField\":null,\"IsSortDesc\":false,\"InvalidateCache\":true}";
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

            evaModelCountExpertise = builder.fromJson(response.body().toString(), EvaModelCountExpertise.class);


        } catch (URISyntaxException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return evaModelCountExpertise.getTotal();
    }
}
