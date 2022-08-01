package com.example.demo.Models;


import java.util.List;

public class EvaReportModelList {

    private List<EvaReportModel> List;
    private int Total;
    private String CacheId;

    public EvaReportModelList(java.util.List<EvaReportModel> list, int total, String cacheId) {
        this.List = list;
        this.Total = total;
        this.CacheId = cacheId;
    }

    public java.util.List<EvaReportModel> getList() {
        return List;
    }

    public void setList(java.util.List<EvaReportModel> list) {
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
