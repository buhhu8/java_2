package ru.levelup.musicianHomework.repository;

import ru.levelup.musicianHomework.model.Albums;

import java.util.List;

public interface AlbumsRepository {
   public List<Albums> findAlbums();

}
