package ru.mse.service.Models;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilitaryEvaModel {
    private String LastName;
    private String FirstName;
    private String SecondName;
    private String PersonBirthDate;
    private String Address;
    private String ActNumber;
    private String DecisionDate;
    private String InvalidityGroupName;
    private String InvalidityPeriodId;
    private String InvalidityBeginDate;
    private String InvalidityEndDate;
    private String IsPersonLiable;
    private String IsPersonMilitaryAge;
}
