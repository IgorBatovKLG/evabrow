package ru.mse.service.Controllers;


import ru.mse.service.DateBase.NewsDb;
import ru.mse.service.DateBase.SignatureDateBase;
import ru.mse.service.Models.BuroSignatureModel;
import ru.mse.service.Models.NewsModel;
import ru.mse.service.Models.SignatureModel;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class StartController {

    @GetMapping("/")
    public String start(){

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
