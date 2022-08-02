package ru.mse.service.Models;

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

    public EvaReportModel(String lastName, String firstName, String secondName, String examBuroName, String id, String SNILS, String referralOrganizationComment, String referralOrganizationOGRN, String requestRegNumber) {
        this.LastName = lastName;
        this.FirstName = firstName;
        this.SecondName = secondName;
        this.ExamBuroName = examBuroName;
        this.Id = id;
        this.SNILS = SNILS;
        this.ReferralOrganizationComment = referralOrganizationComment;
        this.ReferralOrganizationOGRN = referralOrganizationOGRN;
        this.RequestRegNumber = requestRegNumber;
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

    public String getReferralOrganizationComment() {
        return ReferralOrganizationComment;
    }

    public void setReferralOrganizationComment(String referralOrganizationComment) {
        ReferralOrganizationComment = referralOrganizationComment;
    }

    public String getReferralOrganizationOGRN() {
        return ReferralOrganizationOGRN;
    }

    public void setReferralOrganizationOGRN(String referralOrganizationOGRN) {
        ReferralOrganizationOGRN = referralOrganizationOGRN;
    }

    public String getRequestRegNumber() {
        return RequestRegNumber;
    }

    public void setRequestRegNumber(String requestRegNumber) {
        RequestRegNumber = requestRegNumber;
    }
}
