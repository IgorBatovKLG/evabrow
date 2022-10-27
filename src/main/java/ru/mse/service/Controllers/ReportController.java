package ru.mse.service.Controllers;

import ru.mse.service.Models.ReportLoad.DateBase.ReportFbOrder;
import ru.mse.service.Models.ReportLoad.DateBase.ReportFbOrderList;
import ru.mse.service.Models.ReportFbOrderModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * /report/*url*
 *
 */
@Controller
public class ReportController {


    @GetMapping("/report/report_order1")
    public String reportFbOrderMse(HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getRemoteAddr());
        return "reportFbOrder";
    }

    @GetMapping("/report/reportFbOrderGood")
    public String reportFbOrderMseGood(@RequestParam(name = "snils", required = false, defaultValue = "") String snils,
                                       @RequestParam(name = "fio", required = false, defaultValue = "") String fio,
                                       @RequestParam(name = "buro", required = false, defaultValue = "") String buro,
                                       @RequestParam(name = "order", required = false, defaultValue = "") String order,
                                       @RequestParam(name = "group", required = false, defaultValue = "") String group,
                                       @RequestParam(name = "text", required = false, defaultValue = "") String text,
                                       @RequestParam(name = "check1", required = false, defaultValue = "") String check1,
                                       @RequestParam(name = "check2", required = false, defaultValue = "") String check2,
                                       @RequestParam(name = "check3", required = false, defaultValue = "") String check3,
                                       @RequestParam(name = "check4", required = false, defaultValue = "") String check4,
                                       @RequestParam(name = "check5", required = false, defaultValue = "") String check5,
                                       @RequestParam(name = "check6", required = false, defaultValue = "") String check6,
                                       @RequestParam(name = "check7", required = false, defaultValue = "") String check7,
                                       HttpServletRequest httpServletRequest,
            Model model){
        ReportFbOrder reportFbOrder = new ReportFbOrder();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean ifSqlException = true;
        while (ifSqlException) {
            try {
                Thread.sleep(1000*5);
            } catch (InterruptedException e) {
                System.out.println("Не могу отправить информацию о Очно-Заочно в базу, (database is locked)");
            }
            ifSqlException = reportFbOrder.createPalliativeInDb(snils, fio, buro, order, group, text, check1, check2, check3, check4, check5, check6, check7, now.format(formatter).toString(), httpServletRequest.getRemoteAddr());
        }
        model.addAttribute("snils" , snils);
        model.addAttribute("fio" , fio);
        model.addAttribute("buro" , buro);

        return "reportFbOrderGood";
    }

    @GetMapping("/order_list_fb")
    public String ListReportFbOrder(){

        return "reportFbOrderList";
    }
    @GetMapping("/order_list_fbH")
    public String ListReportFbOrderH(){

        return "reportFbOrderListH";
    }

    @GetMapping("order_list_fb_Good")
    public String ListReportFbOrderGood(
            @RequestParam(name = "buro", required = false, defaultValue = "") String buro,
            @RequestParam(name = "order", required = false, defaultValue = "") String order,
            @RequestParam(name = "group", required = false, defaultValue = "") String group,
            @RequestParam(name = "check1", required = false, defaultValue = "") String check1,
            @RequestParam(name = "check2", required = false, defaultValue = "") String check2,
            @RequestParam(name = "check3", required = false, defaultValue = "") String check3,
            @RequestParam(name = "check4", required = false, defaultValue = "") String check4,
            @RequestParam(name = "check5", required = false, defaultValue = "") String check5,
            @RequestParam(name = "check6", required = false, defaultValue = "") String check6,
            @RequestParam(name = "check7", required = false, defaultValue = "") String check7,
            @RequestParam(name = "dateStart", required = false, defaultValue = "") String dateStart,
            @RequestParam(name = "dateAnd", required = false, defaultValue = "") String dateAnd,
            HttpServletRequest httpServletRequest,
            Model model
    ){

        ReportFbOrderList reportFbOrderList = new ReportFbOrderList();
        List<ReportFbOrderModel> reportFbOrderModels = reportFbOrderList.SelectListReport(dateStart, dateAnd, buro, order, group, check1, check2, check3, check4, check5, check6, check7);
        model.addAttribute("model",reportFbOrderModels);
        int i2 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "2");
        int i3 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "3"); //
        int i4 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "4");
        int i5 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "5");
        int i6 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "6");
        model.addAttribute("i2",i2);
        model.addAttribute("i3",i3);
        model.addAttribute("i4",i4);
        model.addAttribute("i5",i5);
        model.addAttribute("i6",i6);
        return "reportFbOrderListGood";
    }
    @GetMapping("order_list_fb_GoodH")
    public String ListReportFbOrderGoodH(
            @RequestParam(name = "buro", required = false, defaultValue = "") String buro,
            @RequestParam(name = "order", required = false, defaultValue = "") String order,
            @RequestParam(name = "group", required = false, defaultValue = "") String group,
            @RequestParam(name = "check1", required = false, defaultValue = "") String check1,
            @RequestParam(name = "check2", required = false, defaultValue = "") String check2,
            @RequestParam(name = "check3", required = false, defaultValue = "") String check3,
            @RequestParam(name = "check4", required = false, defaultValue = "") String check4,
            @RequestParam(name = "check5", required = false, defaultValue = "") String check5,
            @RequestParam(name = "check6", required = false, defaultValue = "") String check6,
            @RequestParam(name = "check7", required = false, defaultValue = "") String check7,
            @RequestParam(name = "dateStart", required = false, defaultValue = "") String dateStart,
            @RequestParam(name = "dateAnd", required = false, defaultValue = "") String dateAnd,
            HttpServletRequest httpServletRequest,
            Model model
    ){

        ReportFbOrderList reportFbOrderList = new ReportFbOrderList();
        List<ReportFbOrderModel> reportFbOrderModels = reportFbOrderList.SelectListReport(dateStart, dateAnd, buro, order, group, check1, check2, check3, check4, check5, check6, check7);
        model.addAttribute("model",reportFbOrderModels);
        int i = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "1");
        int i1 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "2");
        int i2 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "3");
        int i3 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "4");
        int i4 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "5");
        int i5 = reportFbOrderList.selectCountCheck(dateStart, dateAnd, "6");
        int i6 = reportFbOrderList.selectCountorder(dateStart, dateAnd);
        model.addAttribute("i",i);
        model.addAttribute("i1",i1);
        model.addAttribute("i2",i2);
        model.addAttribute("i3",i3);
        model.addAttribute("i4",i4);
        model.addAttribute("i5",i5);
        model.addAttribute("i6",i6);
        return "reportFbOrderListGoodH";
    }

}
