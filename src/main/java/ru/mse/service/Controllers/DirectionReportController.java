package ru.mse.service.Controllers;

import ru.mse.service.DTO.DirectionNotSentDTO;
import ru.mse.service.Models.ReportLoad.DateBase.DirectionApprovReport;
import ru.mse.service.Models.ReportLoad.DateBase.UserNameDataBase;
import ru.mse.service.Models.EvaModelDirectionNotSent;
import ru.mse.service.Models.EvaReportModel;
import ru.mse.service.Models.EvaReportModelList;
import ru.mse.service.Services.DTOServiceDirectionNotSent;
import ru.mse.service.Services.GetEva;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Controller
public class DirectionReportController {

    @GetMapping("/direction/index")
    public String Direction_index(HttpServletRequest httpServletRequest, Model model){
        System.out.println(UserNameDataBase.getIp(httpServletRequest.getRemoteAddr()) + " direction_report " + LocalDateTime.now().toString());


        model.addAttribute("text", "");
        return "reportDirection_index";
    }
    @GetMapping("/direction/insert_direction")
    public String Direction_insert(@RequestParam(name = "snils", required = false, defaultValue = "") String snils,
                                   Model model){



        GetEva getEva = new GetEva();
        EvaReportModelList evaModel = getEva.getEvaModel(snils);
        DirectionApprovReport directionApprovReport = new DirectionApprovReport();
        int countInSnilsSent = directionApprovReport.getCountInSnilsSent(snils);
        if (snils.length()>8){
            if (countInSnilsSent==0) {
                if (evaModel.getTotal() != 0) {
                    EvaReportModel evaReportModel = evaModel.getList().get(0);

                    model.addAttribute("model", evaReportModel);
                    return "reportDirection_insertDirection";
                } else {
                    model.addAttribute("text", "Направление с таким снилс не найдено");
                    return "reportDirection_index";
                }
            }
            else{
                model.addAttribute("text", "Направление с таким снилс уже есть в базе");
                return "reportDirection_index";
            }
        } else {
            model.addAttribute("text", "Некорректный СНИЛС");
            return "reportDirection_index";
        }
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
                                 HttpServletRequest httpServletRequest){

        DirectionApprovReport directionApprovReport = new DirectionApprovReport();
        Runnable Direction = new Runnable() {
            @Override
            public void run() {
                boolean b = true;
                boolean c = true;
                while (b) {
                    b = directionApprovReport.InsertApprov(LastName, FirstName, SecondName, Snils, Buro, RegNumber, Org, OgrnOrg, tipDir, sogl, text, httpServletRequest.getRemoteAddr());
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                while (c){
                    c = directionApprovReport.updateDoSent(Snils);
                }
            }
        };
        Thread myThready = new Thread(Direction);
        myThready.start();
        return "reportDirection_good";
    }

    @GetMapping("/direction/not_sent")
    public String NotSent(Model model){

        DirectionApprovReport directionApprovReport = new DirectionApprovReport();
        ArrayList<EvaModelDirectionNotSent> notSentArrayList = directionApprovReport.notSentArrayList();
        ArrayList<DirectionNotSentDTO> modelDTO = new ArrayList<>();
        DTOServiceDirectionNotSent dtoServiceDirectionNotSent = new DTOServiceDirectionNotSent();
        for (EvaModelDirectionNotSent s:notSentArrayList){
            modelDTO.add(dtoServiceDirectionNotSent.toDTO(s));
        }
        model.addAttribute("model", modelDTO);
        return "direction_notsent";
    }


}
