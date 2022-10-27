package ru.mse.service.Services;

import ru.mse.service.DTO.TimeExpertiseDTO;
import ru.mse.service.Models.TimeExpertiseModel;

public class DTOServiceTimeExpertise {

    public TimeExpertiseDTO toDTO(TimeExpertiseModel model){

        return TimeExpertiseDTO.builder()
                .id("http://dbs/eva/Exam/GetItem/" + model.getId())
                .name(model.getLastName() + " " + model.getFirstName() + " " + model.getSecondName())
                .SNILS(model.getSNILS())
                .buro(model.getExamBuroName())
                .dateStart(model.getArrivedDateTime())
                .dateAnd(model.getStartedDateTime())
                .MetaStateName(model.getMetaStateName())
                .timeExpertise((int) model.getTimeExp())
                .build();


    }
}
