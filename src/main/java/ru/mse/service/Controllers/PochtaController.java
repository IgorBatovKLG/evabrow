package ru.mse.service.Controllers;

import com.google.gson.Gson;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mse.service.Models.PochtaDTO;
import ru.mse.service.Models.ReportLoad.DateBase.MailDb;
import ru.mse.service.Models.PochtaModel;
import ru.mse.service.Services.PochtaService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PochtaController {

    private final ConfigurableApplicationContext context;

    public PochtaController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/pochta")
    public String getPochta(){
        return "pochta/index.html";
    }

    @GetMapping("/pochta/history")
    public String getPochtaHistory(@RequestParam(name = "track", required = false, defaultValue = "") String track, Model model){
        model.addAttribute("list" , context.getBean(PochtaService.class).getHistory(track));
        return "pochta/index.html";
    }

    @GetMapping("/pochta/listBuro")
    public String getPochtaListBuro(Model model){
        return "pochta/list.html";
    }

    @GetMapping("/pochta/buro_lk")
    public String getPochtaBuroLk(@RequestParam(name = "buro", required = false, defaultValue = "") String buro, Model model){
        Gson gson = new Gson();
        System.out.println(buro);
        List<String> aTrue = context.getBean(MailDb.class).getListTrackByBuroAndActive(buro, "true");
        List<PochtaDTO> list = new ArrayList<>();
        for (String s : aTrue) {
            String jsonByIdTrack = context.getBean(MailDb.class).getJsonByIdTrack(s);
            System.out.println(jsonByIdTrack);
            PochtaModel[] pochtaDTOS = gson.fromJson(jsonByIdTrack, PochtaModel[].class);
           list.add(PochtaDTO.builder()
                           .track(s)
                           .date(pochtaDTOS[0].getDate())
                           .humanStatusLast(pochtaDTOS[0].getHumanStatus())
                           .build());
        }
        model.addAttribute("list" , list);
        return "pochta/buro_lk.html";
    }
}
