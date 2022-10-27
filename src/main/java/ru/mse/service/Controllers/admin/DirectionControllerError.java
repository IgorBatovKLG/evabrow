package ru.mse.service.Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mse.service.Models.ReportLoad.DateBase.Admin.DirectionErrorOrControl;
import ru.mse.service.Models.DirectionErrorOrControlModel;

import java.util.ArrayList;

@Controller
public class DirectionControllerError {


    @GetMapping("/admin/direction_error")
    public String errorDirectionList(Model model){
        DirectionErrorOrControl control = new DirectionErrorOrControl();
        ArrayList<DirectionErrorOrControlModel> modelListError = control.getModelListError();
        model.addAttribute("model",modelListError);
        model.addAttribute("LastTime",modelListError.size());
        return "direction/direction_index_error";
    }
}
