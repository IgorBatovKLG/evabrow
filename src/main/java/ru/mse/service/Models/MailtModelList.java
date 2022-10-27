package ru.mse.service.Models;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailtModelList {

    private List<MailModel> List;
    private int Total;
    private String CacheId;
}
