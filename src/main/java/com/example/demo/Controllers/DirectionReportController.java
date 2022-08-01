package com.example.demo.Controllers;

import com.example.demo.DateBase.DirectionApprovReport;
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
    @GetMapping("/direction/insert_direction")
    public String Direction_insert(@RequestParam(name = "snils", required = false, defaultValue = "") String snils,
                                   Model model){
        GetEva getEva = new GetEva();
        EvaReportModelList evaModel = getEva.getEvaModel(snils);
        EvaReportModel evaReportModel = evaModel.getList().get(0);

        model.addAttribute("model",evaReportModel);
        return "reportDirection_insertDirection";
    }
    @GetMapping("/direction/indert_good")
    public String Direction_Good(@RequestParam(name = "LastName", required = false, defaultValue = "") String LastName,
                                 @RequestParam(name = "FirstName", required = false, defaultValue = "") String FirstName,
                                 @RequestParam(name = "SecondName", required = false, defaultValue = "") String SecondName,
                                 @RequestParam(name = "Snils", required = false, defaultValue = "") String Snils,
                                 @RequestParam(name = "Buro", required = false, defaultValue = "") String Buro,
                                 @RequestParam(name = "RegNumber", required = false, defaultValue = "") String RegNumber,
                                 @RequestParam(name = "Org", required = false, defaultValue = "") String Org,
                                 @RequestParam(name = "OgrnOrg", required = false, defaultValue = "") String OgrnOrg,
                                 @RequestParam(name = "tipDir", required = false, defaultValue = "") String tipDir,
                                 @RequestParam(name = "sogl", required = false, defaultValue = "") String sogl,
                                 @RequestParam(name = "text", required = false, defaultValue = "") String text,
                                 Model model,
                                 HttpServletRequest httpServletRequest){

        DirectionApprovReport directionApprovReport = new DirectionApprovReport();
        Runnable Signature = new Runnable() {
            @Override
            public void run() {
                boolean b = true;
                while (b) {
                    b = directionApprovReport.InsertApprov(LastName, FirstName, SecondName, Snils, Buro, RegNumber, Org, OgrnOrg, tipDir, sogl, text, httpServletRequest.getRemoteAddr());
                }
            }
        };
        Signature.run();
        return "reportDirection_good";
    }


}
