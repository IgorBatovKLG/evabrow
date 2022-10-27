package ru.mse.service.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeExpertiseModel {

    private String LastName;
    private String FirstName;
    private String SecondName;
    private String ExamBuroName;
    private String Id;
    private String SNILS;
    private String ArrivedDateTime;
    private String StartedDateTime;
    private String MetaStateName;
    private long TimeExp;
}
