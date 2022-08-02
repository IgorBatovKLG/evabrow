package ru.mse.service.Models;

public class TimeExpertiseModel {

    private String LastName;
    private String FirstName;
    private String SecondName;
    private String ExamBuroName;
    private String Id;
    private String SNILS;
    private String ArrivedDateTime;
    private String StartedDateTime;
    private long TimeExp;

    public TimeExpertiseModel(String lastName, String firstName, String secondName, String examBuroName, String id, String SNILS, String arrivedDateTime, String startedDateTime, long timeExp) {
        this.LastName = lastName;
        this.FirstName = firstName;
        this.SecondName = secondName;
        this.ExamBuroName = examBuroName;
        this.Id = id;
        this.SNILS = SNILS;
        this.ArrivedDateTime = arrivedDateTime;
        this.StartedDateTime = startedDateTime;
        this.TimeExp = timeExp;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getExamBuroName() {
        return ExamBuroName;
    }

    public void setExamBuroName(String examBuroName) {
        ExamBuroName = examBuroName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    public String getArrivedDateTime() {
        return ArrivedDateTime;
    }

    public void setArrivedDateTime(String arrivedDateTime) {
        ArrivedDateTime = arrivedDateTime;
    }

    public String getStartedDateTime() {
        return StartedDateTime;
    }

    public void setStartedDateTime(String startedDateTime) {
        StartedDateTime = startedDateTime;
    }

    public long getTimeExp() {
        return TimeExp;
    }

    public void setTimeExp(long timeExp) {
        TimeExp = timeExp;
    }
}
