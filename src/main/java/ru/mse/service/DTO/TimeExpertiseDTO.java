package ru.mse.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeExpertiseDTO {
    private String id;
    private String name;
    private String SNILS;
    private String buro;
    private String dateStart;
    private String dateAnd;
    private String MetaStateName;
    private int timeExpertise;


}
