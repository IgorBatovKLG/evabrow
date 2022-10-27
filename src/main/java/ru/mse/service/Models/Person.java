package ru.mse.service.Models;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
    private int Id;
    private String RemdId;
    private String Palliative;
    private String DateRemd;
    private String DateEva;
    private String DateAnd;
    private int Days;
    private String Bool;
    private String Snils;
    private String error;
    private String SpecialNotesXml;
    private String Buro;

}
