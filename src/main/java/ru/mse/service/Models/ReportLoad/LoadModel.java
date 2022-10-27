package ru.mse.service.Models.ReportLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadModel {
    private int id;
    private String name;
    private double ratio;
    private String standard;
    private String expertise;
    private String load;
    private String moreLoad;
}
