package ru.mse.service.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PochtaDTO {
    String date;
    String humanStatusLast;
    String track;
}
