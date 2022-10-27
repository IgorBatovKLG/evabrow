package ru.mse.service.Dao;


import ru.mse.service.Models.Person;

import java.util.List;

public interface PersonDAO {



    List<Person> notEva();

    List<Person> ErrorDays();

    List<Person> ErrorNotes();
}
