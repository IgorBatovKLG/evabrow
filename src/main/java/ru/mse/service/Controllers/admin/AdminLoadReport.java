package ru.mse.service.Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoadReport {

    @GetMapping("/admin/loadreport")
    public String checkLife(){
        System.out.println(111);
        return "admin/reportLoadIndex.html";
    }
}
