package ru.levelup.musicianHomework.repository;

import ru.levelup.musicianHomework.model.countries;

public interface CountriesRepository {

    countries createCountry(Integer id, String name);

    void findCountries();
    void deleteCountry(Integer id);

    countries findCountryByName(String name);

}
