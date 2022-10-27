package ru.mse.service.Services;

import org.springframework.stereotype.Service;
import ru.mse.service.Models.ReportLoad.DateBase.AdminDirection;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectionAdminService {

    public List<Integer> getCountDirection(String dateStart, String dateAnd){
        List<Integer> count = new ArrayList<>();

        AdminDirection direction = new AdminDirection();
        count.add(direction.getCountDirection("1", "1", dateStart, dateAnd));
        count.add(direction.getCountDirection("1", "2", dateStart, dateAnd));
        count.add(direction.getCountDirection("1", "3", dateStart, dateAnd));
        count.add(direction.getCountDirection("2", "1", dateStart, dateAnd));
        count.add(direction.getCountDirection("2", "2", dateStart, dateAnd));
        count.add(direction.getCountDirection("2", "3", dateStart, dateAnd));
        count.add(direction.getCountDirectionFull(dateStart, dateAnd));
        return count;
    }
}
