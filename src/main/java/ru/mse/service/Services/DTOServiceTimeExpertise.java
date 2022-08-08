package ru.mse.service.Services;

import ru.mse.service.DTO.TimeExpertiseDTO;
import ru.mse.service.Models.TimeExpertiseModel;

public class DTOServiceTimeExpertise {

    public TimeExpertiseDTO toDTO(TimeExpertiseModel model){
        return new TimeExpertiseDTO("http://dbs/eva/Exam/GetItem/" + model.getId(),
                model.getLastName() + " " + model.getFirstName() + " " + model.getSecondName(),
                model.getSNILS(),
                model.getExamBuroName(),
                model.getArrivedDateTime(),
                model.getStartedDateTime(),
                (int) model.getTimeExp());
    }
}
