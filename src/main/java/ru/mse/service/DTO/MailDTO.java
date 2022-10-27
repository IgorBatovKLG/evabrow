package ru.mse.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailDTO {
    private String adres;
    private String fullName;
    private String sexAndName;
    private ArrayList<String> paragraphs;
    private String buroOrrSostav;
    private String ManagerName;
    private String executor;
    private String id;
    private String InvalidityPeriodId;
}
