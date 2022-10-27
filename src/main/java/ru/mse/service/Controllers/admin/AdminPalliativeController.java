package ru.mse.service.Controllers.admin;

import org.springframework.stereotype.Controller;

@Controller
public class AdminPalliativeController {

    public String PalliativeUpdateIndex(){
        return "admin/palliative_index";
    }
}
