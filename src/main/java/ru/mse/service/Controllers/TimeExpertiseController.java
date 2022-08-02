package ru.mse.service.Controllers;

import com.google.gson.Gson;
import org.springframework.ui.Model;
import ru.mse.service.DTO.TimeExpertiseDTO;
import ru.mse.service.DateBase.TimeExpertiseDB;

public class TimeExpertiseController {

    public String timeExpertiseIndex(Model model){
        TimeExpertiseDB timeExpertiseDB = new TimeExpertiseDB();
        String json = timeExpertiseDB.getJson();
        Gson gson = new Gson();
        TimeExpertiseDTO[] models = gson.fromJson(json, TimeExpertiseDTO[].class);
        model.addAttribute("model", models);
        return "timeExpertise_index";
    }
}
