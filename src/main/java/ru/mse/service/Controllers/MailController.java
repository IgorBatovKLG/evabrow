package ru.mse.service.Controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mse.service.DTO.MailDTO;
import ru.mse.service.Models.MailModel;
import ru.mse.service.Models.MailtModelList;
import ru.mse.service.Services.DTOServiceMail;
import ru.mse.service.Services.GetEvaMail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MailController {

    private final ApplicationContext context;

    public MailController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/mail/index")
    public String MailIndex(Model model){

        return "mail_index";
    }
    @GetMapping("/mail/pass")
    public String MailPass(Model model){

        return "mail_index";
    }


    @GetMapping("/mail/good")
    public String MailGood(Model model,
                           @RequestParam(name = "RegDateFrom", required = false, defaultValue = "") String date,
                           @RequestParam(name = "buro", required = false, defaultValue = "") String buro,
                           @RequestParam(name = "executor", required = false, defaultValue = "") String executor,
                           @RequestParam(name = "phone", required = false, defaultValue = "") String phone
    ){
        String errorText = "";
        boolean error = true;
        if (date.isBlank()){
            errorText = "Неверная дата";
            error=false;
        }
        date = date.replace(".", "-");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            date = parse.format(formatter).toString();



        if (executor.isBlank()){
            errorText = "Не указан испольнитель";
            error=false;
        }
        if (phone.isBlank()){
            errorText = "Не указан испольнитель";
            error=false;
        }
        if (error) {
            GetEvaMail bean = context.getBean(GetEvaMail.class);
            String json = bean.GetListMail(date, buro);
            Gson gson = new Gson();
            ArrayList<MailDTO> MailModelDTO = new ArrayList<>();
            DTOServiceMail dtoServiceMail = new DTOServiceMail();
            MailtModelList mailtModelList = gson.fromJson(json, MailtModelList.class);
            for (MailModel mailModel : mailtModelList.getList()) {
                MailModelDTO.add(dtoServiceMail.toDTO(mailModel));
            }
            model.addAttribute("name", MailModelDTO);
            model.addAttribute("name1", mailtModelList.getList());
            model.addAttribute("executor", executor);
            model.addAttribute("phone", phone);
            return "mail_good";
        }
        model.addAttribute("error", errorText);
        return "mail_index";
    }

    @GetMapping("/mail/goods")
    public String MailGoodSnils(Model model,
                           @RequestParam(name = "RegDateFrom", required = false, defaultValue = "") String date1,
                           @RequestParam(name = "snils1", required = false, defaultValue = "") String snils1,
                           @RequestParam(name = "executor1", required = false, defaultValue = "") String executor1,
                           @RequestParam(name = "phone1", required = false, defaultValue = "") String phone1,
                           @RequestParam(name = "buro1", required = false, defaultValue = "") String buro1
    ){

        String errorText = "";
        boolean error = true;
        if (date1.isBlank()){
            errorText = "Неверная дата";
            error=false;
        }

        date1 = date1.replace(".", "-");
        if (executor1.isBlank()){
            errorText = "Не указан испольнитель";
            error=false;
        }
        if (phone1.isBlank()){
            errorText = "Не указан испольнитель";
            error=false;
        }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parse = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            date1 = parse.format(formatter).toString();

        if (error) {
            GetEvaMail bean = context.getBean(GetEvaMail.class);
            String json = bean.GetListMailSNILS(date1, snils1, buro1);
            Gson gson = new Gson();
            ArrayList<MailDTO> MailModelDTO = new ArrayList<>();
            DTOServiceMail dtoServiceMail = new DTOServiceMail();
            MailtModelList mailtModelList = gson.fromJson(json, MailtModelList.class);
            for (MailModel mailModel : mailtModelList.getList()) {
                MailModelDTO.add(dtoServiceMail.toDTO(mailModel));
            }


            model.addAttribute("name", MailModelDTO);
            model.addAttribute("name1", mailtModelList.getList());
            model.addAttribute("executor", executor1);
            model.addAttribute("phone", phone1);
            return "mail_good";
        }

        model.addAttribute("error", errorText);
        return "mail_index";
    }
}
