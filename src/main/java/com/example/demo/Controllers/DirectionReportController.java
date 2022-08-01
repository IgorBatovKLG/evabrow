package com.example.demo.Controllers;

import com.example.demo.Models.EvaReportModel;
import com.example.demo.Models.EvaReportModelList;
import com.example.demo.Services.GetEva;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@Controller
public class DirectionReportController {

    @GetMapping("/direction/index")
    public String Direction_index(HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getRemoteAddr() + " direction_report " + LocalDateTime.now().toString());

        //TODO ИЗМЕНИТЬ ИП ДЛЯ ЛОКАЛЬНЫХ JS
        return "reportDirection_index";
    }
    @GetMapping("direction/insert_direction")
    public String Direction_insert(@RequestParam(name = "snils", required = false, defaultValue = "") String snils,
                                   Model model){
        GetEva getEva = new GetEva();
        EvaReportModelList evaModel = getEva.getEvaModel(snils);
        EvaReportModel evaReportModel = evaModel.getList().get(0);

        model.addAttribute("model",evaReportModel);
        return "reportDirection_insertDirection";
    }


}
