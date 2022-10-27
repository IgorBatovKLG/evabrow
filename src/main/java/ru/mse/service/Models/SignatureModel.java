package ru.mse.service.Models;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignatureModel {
    private String link;
    private String buro;
    private String name;
    private ArrayList<String> signatureName;
}
