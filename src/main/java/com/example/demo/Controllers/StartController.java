package com.example.demo.Controllers;


import com.example.demo.DateBase.NewsDb;
import com.example.demo.DateBase.SignatureDateBase;
import com.example.demo.Models.BuroSignatureModel;
import com.example.demo.Models.NewsModel;
import com.example.demo.Models.SignatureModel;
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

        return "pass";
    }

    @GetMapping("/index")
    public String index(@RequestParam(name = "text", required = false, defaultValue = "") String text, Model model){
        if (text.equals("123")){
            return "index";
        }
        return "indexbat";
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
}
