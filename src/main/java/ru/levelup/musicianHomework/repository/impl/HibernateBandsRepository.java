package ru.levelup.musicianHomework.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.levelup.musicianHomework.repository.BandsRepository;

import java.util.List;

@RequiredArgsConstructor

public class HibernateBandsRepository implements BandsRepository {

    private final SessionFactory factory;


    @Override
    public void findAllBands() {

        try(Session session = factory.openSession()){

            Transaction tx = session.beginTransaction();

            Query query = session.createQuery("FROM Bands");
            List allBands = query.list();
            for (Object list : allBands) {

                System.out.println(list);
            }

            tx.commit();

        }

    }
}
