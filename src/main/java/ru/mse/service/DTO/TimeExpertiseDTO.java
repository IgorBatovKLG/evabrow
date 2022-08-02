package ru.mse.service.DTO;

public class TimeExpertiseDTO {
    private String id;
    private String name;
    private String SNILS;
    private String buro;
    private String dateStart;
    private String dateAnd;
    private int timeExpertise;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    public String getBuro() {
        return buro;
    }

    public void setBuro(String buro) {
        this.buro = buro;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateAnd() {
        return dateAnd;
    }

    public void setDateAnd(String dateAnd) {
        this.dateAnd = dateAnd;
    }

    public int getTimeExpertise() {
        return timeExpertise;
    }

    public void setTimeExpertise(int timeExpertise) {
        this.timeExpertise = timeExpertise;
    }

    public TimeExpertiseDTO(String id, String name, String SNILS, String buro, String dateStart, String dateAnd, int timeExpertise) {
        this.id = id;
        this.name = name;
        this.SNILS = SNILS;
        this.buro = buro;
        this.dateStart = dateStart;
        this.dateAnd = dateAnd;
        this.timeExpertise = timeExpertise;
    }
}
