package ru.mse.service.Controllers;


import ru.mse.service.Models.ReportLoad.DateBase.NewsDb;
import ru.mse.service.Models.ReportLoad.DateBase.SignatureDateBase;
import ru.mse.service.Models.ReportLoad.DateBase.UserNameDataBase;
import ru.mse.service.Models.BuroSignatureModel;
import ru.mse.service.Models.NewsModel;
import ru.mse.service.Models.SignatureModel;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mse.service.Services.CountVisitsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class StartController {

    @GetMapping(value = {"/", "/report/report_order"})
    public String start(Model model, HttpServletRequest httpServletRequest){
        ArrayList<String> ipAddr = new ArrayList<>();
        ipAddr.add("10.40.99.10");
        ipAddr.add("10.40.99.19");
        ipAddr.add("10.40.99.20");
        ipAddr.add("10.40.99.21");
        ipAddr.add("10.40.99.22");
        if (ipAddr.contains(httpServletRequest.getRemoteAddr())){
            model.addAttribute("admin", 2);
        }

        NewsDb newsDb = new NewsDb();
        ArrayList<NewsModel> newsModels = newsDb.SelectNews();
        model.addAttribute("news", newsModels);

        model.addAttribute("history", 2);
        CountVisitsService.newVisits(httpServletRequest.getRemoteAddr());
        System.out.println(UserNameDataBase.getIp(httpServletRequest.getRemoteAddr()) + " INDEX");

        return "report_index";
    }
    @GetMapping("/history_news")
    public String historyNews(Model model){
        NewsDb newsDb = new NewsDb();
        ArrayList<NewsModel> newsModels = newsDb.SelectHistoryNews();
        model.addAttribute("news", newsModels);
        return "report_index";
    }







    @GetMapping("/signature")
    public String days(@RequestParam(name = "id", required = false, defaultValue = "") int id, Model model){
        SignatureDateBase signatureDateBase = new SignatureDateBase();
        String buro = signatureDateBase.getJsonBuro(id);
        String workers = signatureDateBase.getJsonWorkers(id);
        Gson gson = new Gson();

        SignatureModel[] signatureModels = gson.fromJson(workers, SignatureModel[].class);
        BuroSignatureModel[] buroSignatureModels = gson.fromJson(buro, BuroSignatureModel[].class);


        model.addAttribute("name", signatureModels);
        model.addAttribute("buro", buroSignatureModels);
        return "signature";
    }

    @GetMapping("/report/index")
    public String reportIndex(Model model){
        NewsDb newsDb = new NewsDb();
        ArrayList<NewsModel> newsModels = newsDb.SelectNews();
        model.addAttribute("name",newsModels);
        return "report_index";
    }

    @GetMapping("test")
    public String test(Model model){

        return "test";
    }

}
