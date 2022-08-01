package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DirectionController {

    @GetMapping("/direction/get_direction1")
    public String getDirection1(){
        return "direction_getDirection1";
    }


    @GetMapping("/direction/get_direction")
    public String getDirection(){
        return "direction_getDirection";
    }

    public String listDirection(@RequestParam(name = "check1", required = false, defaultValue = "") String check1,
                                @RequestParam(name = "check2", required = false, defaultValue = "") String check2,
                                @RequestParam(name = "check3", required = false, defaultValue = "") String check3,
                                @RequestParam(name = "check4", required = false, defaultValue = "") String check4,
                                @RequestParam(name = "check5", required = false, defaultValue = "") String check5,
                                @RequestParam(name = "dateStart", required = false, defaultValue = "") String dateStart,
                                @RequestParam(name = "dateAnd", required = false, defaultValue = "") String dateAnd,
                                Model model){



        return "direction_listDirection";
    }
}
