package ru.mse.service.Services;

import ru.mse.service.DTO.TimeExpertiseDTO;
import ru.mse.service.Models.TimeExpertiseModel;

public class DTOServiceTimeExpertise {

    public TimeExpertiseDTO toDTO(TimeExpertiseModel model){
        return new TimeExpertiseDTO(model.getId(),
                model.getFirstName() + " " + model.getLastName() + " " + model.getSecondName(),
                model.getSNILS(),
                model.getExamBuroName(),
                model.getArrivedDateTime(),
                model.getStartedDateTime(),
                (int) model.getTimeExp());
    }
}
