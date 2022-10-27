package ru.mse.service.Services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Service;
import ru.mse.service.Models.PochtaModel;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class PochtaService {

    public List<PochtaModel> getHistory(String track) {
        Gson builder = new Gson();
        List<PochtaModel> list = new ArrayList<>();
        try {
            String json = "[\""+track+"\"]";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request  = HttpRequest.newBuilder().uri(new URI("https://www.pochta.ru/api/nano-apps/api/v1/tracking.get-by-barcodes?language=ru"))
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:99.0) Gecko/20100101 Firefox/99.0")
                    .header("Content-Type","application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
            HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String s = JsonPath.parse(response.body().toString()).read("$..trackingHistoryItemList").toString();
            Type type = new TypeToken<List<PochtaModel>>(){}.getType();
            s = s.substring(1, s.length()-1);
            list = builder.fromJson(s, type);


        } catch (URISyntaxException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
