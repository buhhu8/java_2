package ru.levelup.musicianHomework.repository;

import ru.levelup.musicianHomework.model.musicians;

import java.sql.Date;

public interface MusiciansRepository {
    musicians createMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id);
    void updateMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id);
    void deleteMusician(Integer id);
    void findByName(String name);
    void findByDateOfBirth(Date dateOfBirth);

}

