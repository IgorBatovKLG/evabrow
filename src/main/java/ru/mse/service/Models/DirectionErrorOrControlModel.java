package ru.mse.service.Models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DirectionErrorOrControlModel {

    private String url;
    private String regNum;
    private String regDate;
    private String Stage;
    private String refIssDate;
    private String fio;
    private String recDate;
    boolean error1;
    boolean error2;
    boolean error3;
    boolean error4;
    boolean error5;
    boolean error6;

}
