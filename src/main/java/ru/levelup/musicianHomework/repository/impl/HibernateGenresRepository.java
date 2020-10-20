package ru.levelup.musicianHomework.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.levelup.musicianHomework.model.Bands;
import ru.levelup.musicianHomework.model.Genres;
import ru.levelup.musicianHomework.model.Musicians;
import ru.levelup.musicianHomework.repository.GenresRepository;

import java.util.List;

@RequiredArgsConstructor
public class HibernateGenresRepository implements GenresRepository {
    private final SessionFactory factory;


    @Override
    public void findMusiciansGenres() {
        try(Session session = factory.openSession()){

            Transaction tx = session.beginTransaction();
            Musicians musicians = new Musicians();
            musicians.getId();
            Query query = session.createQuery("FROM Genres");
            List allMusicians = query.list();
            for (Object list : allMusicians) {

                System.out.println(list);
            }

            tx.commit();

        }

    }

    @Override
    public Genres findById(Integer ID) {
        try (Session session = factory.openSession()) {
            //найти строку по ID, можно воспользоваться одним из методов: get или load

            return session.get(Genres.class, ID);
            }
    }

    @Override
    public void findBandsGenres() {
        try(Session session = factory.openSession()){

            Transaction tx = session.beginTransaction();
            Musicians musicians = new Musicians();
            musicians.getId();
            Query query = session.createQuery("FROM Genres");
            List allMusicians = query.list();
            for (Object list : allMusicians) {

                System.out.println(list);
            }

            tx.commit();

        }

      }
}
