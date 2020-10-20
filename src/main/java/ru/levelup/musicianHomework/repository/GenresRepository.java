package ru.levelup.musicianHomework.repository;

import ru.levelup.musicianHomework.model.Bands;
import ru.levelup.musicianHomework.model.Genres;
import ru.levelup.musicianHomework.model.Musicians;

import java.util.List;

public interface GenresRepository {
    public void findMusiciansGenres();
    public Genres findById(Integer ID);
    public void findBandsGenres();
}
