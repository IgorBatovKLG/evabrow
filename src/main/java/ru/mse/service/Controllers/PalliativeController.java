package ru.mse.service.Controllers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mse.service.Dao.PersonDAO;
import ru.mse.service.Models.Person;

import java.util.List;

@Controller
public class PalliativeController {

    private ConfigurableApplicationContext context;

    public PalliativeController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/palliative/index")
    public String index(Model model){
        PersonDAO personDAO = context.getBean(PersonDAO.class);
        List<Person> days = personDAO.ErrorDays();
        List<Person> notes = personDAO.ErrorNotes();
        List<Person> notEva = personDAO.notEva();
        model.addAttribute("days", days);
        model.addAttribute("notes", notes);
        model.addAttribute("notEva", notEva);
        return "palliative_index";
    }
}
