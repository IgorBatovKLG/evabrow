package ru.mse.service.Services;

import ru.mse.service.Models.ReportLoad.LoadModel;
import ru.mse.service.Models.ReportLoad.LoadWebModel;

import java.util.ArrayList;
import java.util.HashMap;

public class LoadReportService {
    private HashMap<String, Object> loadCalculation(int daysWorks, int countExpertise, double ratio, double dayNorm){
        HashMap<String, Object> hashMap = new HashMap<>();
        double standardLoad = Math.round((daysWorks*dayNorm*ratio) * 100.0) / 100.0;
        hashMap.put("standardLoad", standardLoad);
        double load =Math.round(((countExpertise/standardLoad)*100) * 100.0) / 100.0;
        hashMap.put("load", load);
        double moreStandard = 0.0f;
        if (load>100.0f){
            moreStandard =Math.round((load-100.0f)* 100.0) / 100.0;
        }
        hashMap.put("moreStandard", moreStandard);
        return hashMap;
    }

    private int getCountExpertiseEva(int idBuro, String month, String year){
        GetEva getEva = new GetEva();
        return getEva.getCountExpertise(idBuro, month, year);
    }

    public HashMap<String, Object> countingLoad(int daysWorks, int idBuro, String month, String year, double ratio, double dayNorm){
        int countExpertise = getCountExpertiseEva(idBuro, month, year);
        HashMap<String, Object> loadCalculationHashMap = loadCalculation(daysWorks, countExpertise, ratio, dayNorm);
        loadCalculationHashMap.put("expertise", countExpertise);
        return loadCalculationHashMap;
    }

    public ArrayList<LoadModel> getLoadModels(LoadWebModel webModel){
        ArrayList<LoadModel> models = new ArrayList<>();
        HashMap<String, Object> hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro1()), 1001683, webModel.getMonth(), webModel.getYear(), 1, 5.7);
        models.add(new LoadModel(1,
                "Бюро мсэ № 1",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro2()), 1001684, webModel.getMonth(), webModel.getYear(), 1, 5.7);
        models.add(new LoadModel(2,
                "Бюро мсэ № 2",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro3()), 1001685, webModel.getMonth(), webModel.getYear(), 1, 5.7);
        models.add(new LoadModel(3,
                "Бюро мсэ № 3",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro4()), 1001686, webModel.getMonth(), webModel.getYear(), 1, 5.7);
        models.add(new LoadModel(4,
                "Бюро мсэ № 4 смешанного профиля",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro5()), 1001687, webModel.getMonth(), webModel.getYear(), 1, 4.5);
        models.add(new LoadModel(5,
                "Бюро мсэ № 5 для освидетельствования лиц в возрасте до 18 лет",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro6()), 1001688, webModel.getMonth(), webModel.getYear(), 1, 5.7);
        models.add(new LoadModel(6,
                "Бюро мсэ № 6 для освидетельствования лиц с психич. расстройствами",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro7()), 1001689, webModel.getMonth(), webModel.getYear(), 1, 5.7);
        models.add(new LoadModel(7,
                "Бюро мсэ № 7 смешанного профиля",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro8()), 1001690, webModel.getMonth(), webModel.getYear(), 0.5, 5.7);
        models.add(new LoadModel(8,
                "Бюро мсэ № 8 для освидетельствования лиц с заб-ями  и дефектами орг. зрен.",
                0.5,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro9()), 1001691, webModel.getMonth(), webModel.getYear(), 0.5, 5.7);
        models.add(new LoadModel(9,
                "Бюро мсэ № 9 смешанного профиля",
                0.5,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro10()), 1001692, webModel.getMonth(), webModel.getYear(), 1, 5.7);
        models.add(new LoadModel(10,
                "Бюро мсэ № 10",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro11()), 1001693, webModel.getMonth(), webModel.getYear(),1, 5.7);
        models.add(new LoadModel(11,
                "Бюро мсэ № 11",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro12()), 1001694, webModel.getMonth(), webModel.getYear(),1, 5.7);
        models.add(new LoadModel(12,
                "Бюро мсэ № 12",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro13()), 1001695, webModel.getMonth(), webModel.getYear(),1, 5.7);
        models.add(new LoadModel(13,
                "Бюро мсэ № 13",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro15()), 1001697, webModel.getMonth(), webModel.getYear(),1, 5.7);
        models.add(new LoadModel(14,
                "Бюро мсэ № 15 смешанного профиля",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro17()), 1001699, webModel.getMonth(), webModel.getYear(),1, 5.7);
        models.add(new LoadModel(15,
                "Бюро мсэ № 17",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro18()), 1001700, webModel.getMonth(), webModel.getYear(),1, 5.7);
        models.add(new LoadModel(16,
                "Бюро мсэ № 18",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        hashMap = countingLoad(Integer.parseInt(webModel.getDaysBuro19()), 1001701, webModel.getMonth(), webModel.getYear(),1, 5.7);
        models.add(new LoadModel(17,
                "Бюро мсэ № 19",
                1,
                String.valueOf(hashMap.get("standardLoad")),
                String.valueOf(hashMap.get("expertise")),
                String.valueOf(hashMap.get("load")),
                String.valueOf(hashMap.get("moreStandard"))));
        return models;
    }

    public String getMonth(String month, String year){
        int monthInt = Integer.parseInt(month);
        int yearInt = Integer.parseInt(year);
        String monthStr = "январь";
        switch (month){
            case ("01"):
                monthStr = "за январь (с 25.12."+year+" по 24.01."+(yearInt-1)+"-";
                break;
            case ("02"):
                monthStr = "за февраль (с 25.01."+year+" по 24.02."+year+"-";
                break;
            case ("03"):
                monthStr = "за март (с 25.02."+year+" по 24.03."+year+"-";
                break;
            case ("04"):
                monthStr = "за апрель (с 25.03."+year+" по 24.04."+year+"-";
                break;
            case ("05"):
                monthStr = "за май (с 25.04."+year+" по 24.05."+year+"-";
                break;
            case ("06"):
                monthStr = "за июнь (с 25.05."+year+" по 24.06."+year+"-";
                break;
            case ("07"):
                monthStr = "за июль (с 25.06."+year+" по 24.07."+year+"-";
                break;
            case ("08"):
                monthStr = "за август (с 25.07."+year+" по 24.08."+year+"-";
                break;
            case ("09"):
                monthStr = "за сентябрь (с 25.08."+year+" по 24.09."+year+"-";
                break;
            case ("10"):
                monthStr = "за октябрь (с 25.09."+year+" по 24.10."+year+"-";
                break;
            case ("11"):
                monthStr = "за ноябрь (с 25.10."+year+" по 24.11."+year+"-";
                break;
            case ("12"):
                monthStr = "за декабрь (с 25.11."+year+" по 24.12."+year+"-";
                break;
        }
        return monthStr;
    }

    public String getDay(String day){
        String nameDay = " рабочих дней";
        switch (day){
            case ("10"):
            case ("11"):
            case ("12"):
            case ("13"):
            case ("14"):
            case ("15"):
            case ("16"):
            case ("17"):
            case ("18"):
            case ("19"):
            case ("20"):
                nameDay = " рабочих дней";
                break;
            case ("21"):
                nameDay = " рабочий день";
                break;
            case ("22"):
            case ("23"):
            case ("24"):
            case ("25"):
                nameDay = " рабочих дня";
                break;
        }
        return nameDay;
    }
}
