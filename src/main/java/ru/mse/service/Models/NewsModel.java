package ru.mse.service.Models;


public class NewsModel {
    private int id;
    private String date;
    private String text;
    private String headline;
    private String href;
    private String hrefBool;

    public NewsModel(int id, String date, String text, String headline, String href, String hrefBool) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.headline = headline;
        this.href = href;
        this.hrefBool = hrefBool;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHrefBool() {
        return hrefBool;
    }

    public void setHrefBool(String hrefBool) {
        this.hrefBool = hrefBool;
    }
}
