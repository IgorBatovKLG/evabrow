package ru.mse.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DirectionNotSentDTO {
    private String id;
    private String snils;
    private String buro;
    private String name;
}
