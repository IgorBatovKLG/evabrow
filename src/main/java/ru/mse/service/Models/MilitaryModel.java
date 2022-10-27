package ru.mse.service.Models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilitaryModel {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDateStart;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDateEnd;

    private String buro;

    private String district;

    private String innerDistrict;

    private Boolean innerDir;
}
