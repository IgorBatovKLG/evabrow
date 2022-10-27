package ru.mse.service.Models;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailModel {



    private String Id;
    private String ExamBuroName;
    private String InvalidityGroupName;
    private String FirstName;
    private String SecondName;
    private String LastName;
    private String DecisionDate;
    private String BlankNumber;
    private String IpraChildNumber;
    private String IpraNumber;
    private String PersonGender;
    private String BuroManagerName;
    private String ExpSostavManagerName;
    private String Address;
    private String PatientRepPersonLastName;
    private String PatientPersonAge;
    private String PurposesXml;
    private String InvalidityPeriodId;
}
