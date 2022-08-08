package ru.mse.service.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mse.service.DateBase.FSSDatebase;

import javax.servlet.http.HttpServletRequest;

@Controller
public class fssController {

    @GetMapping("/fss/get")
    public String invateFssGet(HttpServletRequest httpServletRequest,
                                 @RequestParam(name = "fio", required = false, defaultValue = "") String fio,
                                 @RequestParam(name = "snils", required = false, defaultValue = "") String snils,
                                 @RequestParam(name = "buro", required = false, defaultValue = "") String buro,
                                 @RequestParam(name = "time", required = false, defaultValue = "") String time,
                                 @RequestParam(name = "date", required = false, defaultValue = "") String date){

        FSSDatebase fssDatebase = new FSSDatebase();
        fssDatebase.createInvateInDB(snils, date,time,buro,fio,httpServletRequest.getRemoteAddr());


        return "invateFssGood";
    }

    @GetMapping("/fss/index")
    public String invateFssIndex(){
        return "invateFssIndex";
    }

}
