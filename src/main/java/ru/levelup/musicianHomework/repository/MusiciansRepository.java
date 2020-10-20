package ru.levelup.musicianHomework.repository;

import ru.levelup.musicianHomework.model.Genres;
import ru.levelup.musicianHomework.model.Musicians;

import java.sql.Date;

public interface MusiciansRepository {
    Musicians createMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id);
    void updateMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id);
    void deleteMusician(Integer id);
    void findByName(String name);
    void findByDateOfBirth(Date dateOfBirth);
    void findMusicainsBands();
    public void addClient(Integer bankId, Genres genres);

}

