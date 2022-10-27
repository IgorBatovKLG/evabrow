package ru.mse.service.Models;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaReportModel {

    private String LastName;
    private String FirstName;
    private String SecondName;
    private String ExamBuroName;
    private String Id;
    private String SNILS;
    private String ReferralOrganizationComment;
    private String ReferralOrganizationOGRN;
    private String RequestRegNumber;
}
