package ru.mse.service.Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mse.service.Models.ReportLoad.LoadModel;
import ru.mse.service.Models.ReportLoad.LoadWebModel;
import ru.mse.service.Services.LoadReportService;

import java.util.ArrayList;

@Controller
public class ReportLoadController {

    @GetMapping("/admin/report_load_index")
    public String getLoadReportIndex(Model model){
        model.addAttribute("webModel", new LoadWebModel());
        return "admin/reportLoadIndex";
    }
    @PostMapping("/admin/report_load_days_buro")
    public String save(@ModelAttribute LoadWebModel webModel, Model model){
        webModel.setDaysBuro1(webModel.getDays());
        webModel.setDaysBuro2(webModel.getDays());
        webModel.setDaysBuro3(webModel.getDays());
        webModel.setDaysBuro4(webModel.getDays());
        webModel.setDaysBuro5(webModel.getDays());
        webModel.setDaysBuro6(webModel.getDays());
        webModel.setDaysBuro7(webModel.getDays());
        webModel.setDaysBuro8(webModel.getDays());
        webModel.setDaysBuro9(webModel.getDays());
        webModel.setDaysBuro10(webModel.getDays());
        webModel.setDaysBuro11(webModel.getDays());
        webModel.setDaysBuro12(webModel.getDays());
        webModel.setDaysBuro13(webModel.getDays());
        webModel.setDaysBuro15(webModel.getDays());
        webModel.setDaysBuro17(webModel.getDays());
        webModel.setDaysBuro18(webModel.getDays());
        webModel.setDaysBuro19(webModel.getDays());
        model.addAttribute("webModel", webModel);
        return "admin/reportLoadDays";
    }

    @PostMapping("/admin/report_load_good")
    public String getReport(@ModelAttribute LoadWebModel webModel, Model model){
        LoadReportService loadService = new LoadReportService();

        ArrayList<LoadModel> models = loadService.getLoadModels(webModel);

        model.addAttribute("model", models);
        model.addAttribute("executorPost", webModel.getExecutorPost());
        model.addAttribute("executor", webModel.getExecutor());
        model.addAttribute("directorPost", webModel.getDirectorPost());
        model.addAttribute("director", webModel.getDirector());
        model.addAttribute("dateOfSigning", webModel.getDateSigning());
        model.addAttribute("datePeriod", loadService.getMonth(webModel.getMonth(), webModel.getYear()) + webModel.getDays() + loadService.getDay(webModel.getDays()));
        return "admin/reportLoadGood";
    }
}
