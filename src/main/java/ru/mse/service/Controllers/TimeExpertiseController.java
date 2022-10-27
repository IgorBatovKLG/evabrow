package ru.mse.service.Controllers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mse.service.DTO.TimeExpertiseDTO;
import ru.mse.service.Models.ReportLoad.DateBase.TimeExpertiseDB;
import ru.mse.service.Models.TimeExpertiseModel;
import ru.mse.service.Services.DTOServiceTimeExpertise;

import java.util.ArrayList;
import java.util.Comparator;

@Controller
public class TimeExpertiseController {

    @GetMapping("/time/index")
    public String timeExpertiseIndex(Model model){
        TimeExpertiseDB timeExpertiseDB = new TimeExpertiseDB();
        String json = timeExpertiseDB.getJson();
        String lastTime = timeExpertiseDB.getLastTime();
        Gson gson = new Gson();
        TimeExpertiseModel[] models = gson.fromJson(json, TimeExpertiseModel[].class);
        DTOServiceTimeExpertise dtoServiceTimeExpertise = new DTOServiceTimeExpertise();
        ArrayList<TimeExpertiseDTO> list = new ArrayList<>();
        for (TimeExpertiseModel m:models){
            list.add(dtoServiceTimeExpertise.toDTO(m));
        }
        list.sort(Comparator.comparing(TimeExpertiseDTO::getTimeExpertise));
        model.addAttribute("model", list);
        model.addAttribute("LastTime", "Последнее обновление таблицы " + lastTime);
        return "timeExpertise_index";
    }
}
