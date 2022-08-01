package com.example.demo.Models;

import java.util.ArrayList;

public class EvaReportModelList {

    private ArrayList<EvaReportModel> List;
    private int Total;
    private String CacheId;

    public EvaReportModelList(ArrayList<EvaReportModel> list, int total, String cacheId) {
        List = list;
        Total = total;
        CacheId = cacheId;
    }

    public ArrayList<EvaReportModel> getList() {
        return List;
    }

    public void setList(ArrayList<EvaReportModel> list) {
        List = list;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public String getCacheId() {
        return CacheId;
    }

    public void setCacheId(String cacheId) {
        CacheId = cacheId;
    }
}
