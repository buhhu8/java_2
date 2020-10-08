package ru.levelup.musicians.library.repository;

import ru.levelup.musicians.library.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository {

    Person createNewPerson(Integer id, String name, String lastName, String middleName, LocalDate bornDate);

    Person findById(Integer id);

    List <Person> findByLastName (String lastName);
}
