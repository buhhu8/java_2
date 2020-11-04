package ru.levelup.musicianHomework.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicianHomework.model.Albums;
import ru.levelup.musicianHomework.model.Songs;
import ru.levelup.musicianHomework.repository.AlbumsRepository;


import java.util.List;

@RequiredArgsConstructor

public class HibernateAlbumsRepository implements AlbumsRepository {

    private final SessionFactory factory;

    @Override
    public List<Albums> findAlbums() {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();

            Songs song = new Songs();
            song.getAlbumId();
            List<Albums> list =  session.createQuery("FROM Albums", Albums.class)
                    .getResultList();

            tx.commit();

            return list;
        }

    }
}
