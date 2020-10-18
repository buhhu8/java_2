package ru.levelup.musicians.library.repository;

import ru.levelup.musicians.library.model.Person;
import ru.levelup.musicians.library.model.PersonLegalInfo;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository {

    Person createNewPerson(Integer id, String name, String lastName, String middleName, LocalDate bornDate);

    PersonLegalInfo updateLegalInfo(Integer personId, String passportSeries, String passportNumber, String inn, String snils);

    PersonLegalInfo getPersonLegalInfo(Integer personId);

    Person findById(Integer id);

    Person loadById(Integer id);

    List<Person> findByLastName(String lastName);

}
