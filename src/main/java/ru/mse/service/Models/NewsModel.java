package ru.mse.service.Models;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsModel {
    private int id;
    private String date;
    private String text;
    private String headline;
    private String href;
    private String hrefBool;
}
