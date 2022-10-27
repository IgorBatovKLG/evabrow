package ru.mse.service.Models;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaReportModelList {

    private List<EvaReportModel> List;
    private int Total;
    private String CacheId;
}
