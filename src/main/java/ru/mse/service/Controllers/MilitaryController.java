package ru.mse.service.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mse.service.Models.MilitaryModel;
import ru.mse.service.Services.MilitaryService;

@Controller
public class MilitaryController {

    @GetMapping("/military/pass")
    public String MilitaryPass(){
        return "military_pass";
    }

    @GetMapping("/military/index")
    public String MilitaryIndex(Model model,
                                @RequestParam(name = "text", required = false, defaultValue = "") String text){
        if (text.equals("2022")) {
            model.addAttribute("military", new MilitaryModel());
            return "military_index";
        }
        model.addAttribute("error", "Неверный пароль");
        return "military_pass";
    }

    @PostMapping("/military/good")
    public String MilitaryGood(@ModelAttribute MilitaryModel militaryModel){
        System.out.println(militaryModel.toString());
        MilitaryService militaryService = new MilitaryService();
       // String s = militaryService.GetListMilitary(militaryModel.getLocalDateStart(), militaryModel.getLocalDateEnd(), militaryModel.getBuro(), militaryModel.getDistrict(), militaryModel.getInnerDistrict());
       // System.out.println(s);
        return "save";
    }
}
