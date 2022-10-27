package ru.mse.service.Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mse.service.Models.ReportLoad.DateBase.NewsDb;
import ru.mse.service.Models.NewsModel;

@Controller
public class AdminNewsController {

    @GetMapping("/admin/addnews")
    public String addNews(Model model){
        model.addAttribute("news", new NewsModel());
        return "admin/addnews.html";
    }
    @PostMapping("/admin/savenews")
    public String saveAddNews(@ModelAttribute NewsModel news){
        NewsDb newsDb = new NewsDb();
        if (news.getHrefBool().equals("3")){
            news.setHref("http://10.40.99.10:81/" + news.getHref() + ".pdf");
            news.setHrefBool("2");
        }
        boolean b = true;
        while (b) {
            b = newsDb.addNews(news);
        }
        return "admin/addnews_good.html";
    }
}
