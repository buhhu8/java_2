package ru.levelup.musicianHomework.repository;

import ru.levelup.musicianHomework.model.countries;
import ru.levelup.musicianHomework.model.musicians;

public interface CountriesRepository {

    countries createCountry(Integer id, String name);

    void findCountries();
    void deleteCountry(Integer id);

    countries findCountryByName(String name);

//    List <Person> findByLastName(String lastName);
}
