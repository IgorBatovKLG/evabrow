package ru.mse.service.Controllers.admin;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mse.service.Models.ReportLoad.DateBase.NewsDb;
import ru.mse.service.Services.DirectionAdminService;

import java.util.List;

@Controller
public class AdminController {
    private final ConfigurableApplicationContext context;

    public AdminController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/admin")
    public String admin(){
        NewsDb newsDb = new NewsDb();
        newsDb.SelectNews();
        return "admin/admin.html";
    }

    @GetMapping("/admin/check_life")
    public String checkLife(){
        return "check_life";
    }
    @GetMapping("/admin/direction/good")
    public String direction(Model model,
                            @RequestParam(name = "dateStart", required = false, defaultValue = "") String dateStart,
                            @RequestParam(name = "dateAnd", required = false, defaultValue = "") String dateAnd,
                            @RequestParam(name = "count", required = false, defaultValue = "") String count){
        Integer COUNT_EVA_DIRECTION = Integer.parseInt(count);
        DirectionAdminService service = context.getBean(DirectionAdminService.class);
        List<Integer> countDirection = service.getCountDirection(dateStart, dateAnd);

        double el = countDirection.get(0).doubleValue() + countDirection.get(1).doubleValue() + countDirection.get(2).doubleValue();
        double bum = countDirection.get(3).doubleValue() + countDirection.get(4).doubleValue() + countDirection.get(5).doubleValue();
        Double v0 = countDirection.get(0).doubleValue() / el*100;
        Double v1 = countDirection.get(1).doubleValue() / el*100;
        Double v2 = countDirection.get(2).doubleValue() / el*100;
        Double v3 = countDirection.get(3).doubleValue() / bum*100;
        Double v4 = countDirection.get(4).doubleValue() / bum*100;
        Double v5 = countDirection.get(5).doubleValue() / bum*100;

        Double E0 = v0/100*COUNT_EVA_DIRECTION;
        Double E1 = v1/100*COUNT_EVA_DIRECTION;
        Double E2 = v2/100*COUNT_EVA_DIRECTION;
        Double E3 = v3/100*COUNT_EVA_DIRECTION;
        Double E4 = v4/100*COUNT_EVA_DIRECTION;
        Double E5 = v5/100*COUNT_EVA_DIRECTION;

        model.addAttribute("count0", countDirection.get(0));
        model.addAttribute("count1", countDirection.get(1));
        model.addAttribute("count2", countDirection.get(2));
        model.addAttribute("count3", countDirection.get(3));
        model.addAttribute("count4", countDirection.get(4));
        model.addAttribute("count5", countDirection.get(5));
        model.addAttribute("count6", countDirection.get(6));



        model.addAttribute("v0", v0.intValue());
        model.addAttribute("v1", v1.intValue());
        model.addAttribute("v2", v2.intValue());
        model.addAttribute("v3", v3.intValue());
        model.addAttribute("v4", v4.intValue());
        model.addAttribute("v5", v5.intValue());

        model.addAttribute("E0", E0.intValue());
        model.addAttribute("E1", E1.intValue());
        model.addAttribute("E2", E2.intValue());
        model.addAttribute("E3", E3.intValue());
        model.addAttribute("E4", E4.intValue());
        model.addAttribute("E5", E5.intValue());

        return "admin/direction_good.html";
    }

    @GetMapping("/admin/direction/get")
    public String getDirection(){
        return "admin/direction_get";
    }

}
