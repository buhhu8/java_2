package ru.levelup.musicianHomework.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.levelup.musicianHomework.model.Songs;
import ru.levelup.musicianHomework.repository.AlbumsRepository;


import java.util.List;

@RequiredArgsConstructor

public class HibernateAlbumsRepository implements AlbumsRepository {

    private final SessionFactory factory;

    @Override
    public void findAlbums() {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();

            Songs song = new Songs();
            song.getAlbumId();
            Query query = session.createQuery("FROM Albums");
            List allAlbums = query.list();
            for (Object list : allAlbums) {
                System.out.println(list);
            }

            tx.commit();
        }
    }
}
