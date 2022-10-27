package ru.mse.service.Services;

import ru.mse.service.DTO.DirectionNotSentDTO;
import ru.mse.service.Models.EvaModelDirectionNotSent;
import ru.mse.service.Models.TimeExpertiseModel;

public class DTOServiceDirectionNotSent {

    public DirectionNotSentDTO toDTO(EvaModelDirectionNotSent model) {
        return new DirectionNotSentDTO("http://10.40.99.10/direction/insert_direction?snils=" + model.getSNILS(),
                model.getSNILS(),
                model.getExamBuroName(),
                model.getLastName() + " " + model.getFirstName() + " " + model.getSecondName());
    }
}