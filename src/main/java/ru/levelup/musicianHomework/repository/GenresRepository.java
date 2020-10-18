package ru.levelup.musicianHomework.repository;

import ru.levelup.musicianHomework.model.Musicians;

import java.util.List;

public interface GenresRepository {
    List<Musicians> findMusiciansGenres();
}
