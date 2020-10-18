package ru.levelup.musicianHomework.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicianHomework.model.Bands;
import ru.levelup.musicianHomework.model.Genres;
import ru.levelup.musicianHomework.model.Musicians;
import ru.levelup.musicianHomework.model.MusiciansBand;
import ru.levelup.musicianHomework.repository.MusiciansRepository;

import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@RequiredArgsConstructor
public class HibernateMusiciansRepositories implements MusiciansRepository {

    private final SessionFactory factory;

    @Override
    public void findMusicainsBands() {
        try(Session session = factory.openSession()){

            Transaction tx = session.beginTransaction();
            Genres genres = new Genres();
            genres.getGenreId();

            org.hibernate.query.Query query = session.createQuery("FROM Musicians");
            List allMusicians = query.list();
            for (Object list : allMusicians) {
                System.out.println(list);
            }

            tx.commit();

        }
    }

    @Override
    public void updateMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id) {
        try (Session session = factory.openSession()) {
            //найти строку по ID, можно воспользоваться одним из методов: get или load
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "UPDATE Musicians SET id =: id, first_name =: first_name , middle_name =: middle_name ,last_name =: last_name, sex =: sex, date_of_birth =: date_of_birth, country_id =: country_id WHERE id =: id " ;
            System.out.println(hqlUpdate);
            int deletedEntities = session.createQuery( hqlUpdate )

                    .setInteger( "id", id)
                    .setString("first_name", first_name)
                    .setString("middle_name", middle_name)
                    .setString("last_name", last_name)
                    .setString("sex",sex)
                    .setDate("date_of_birth",date_of_birth)
                    .setInteger("country_id", country_id)
                 .executeUpdate();
            tx.commit();
            session.close();
        }
    }

    @Override
    public void deleteMusician(Integer id) {
        try (Session session = factory.openSession()) {
            //найти строку по ID, можно воспользоваться одним из методов: get или load
            Transaction tx = session.beginTransaction();
            String hqlDelete = "DELETE FROM Musicians WHERE id = :id";
            int deletedEntities = session.createQuery( hqlDelete )
                    .setInteger( "id", id)
                    .executeUpdate();
            tx.commit();
            session.close();
        }
    }

    @Override
    public void findByName(String name) {
        try (Session session = factory.openSession()) {
            //найти строку по ID, можно воспользоваться одним из методов: get или load

            Query query = session.createQuery("FROM Musicians  WHERE first_name LIKE " + "'" + name + "'");
            List allCountries = query.getResultList();
            for(Object list : allCountries){
                System.out.println(list.toString());
            }

        }
    }

    @Override
    public void findByDateOfBirth(Date dateOfBirth) {
        try (Session session = factory.openSession()) {
            //найти строку по ID, можно воспользоваться одним из методов: get или load

            Query query = session.createQuery("FROM Musicians  WHERE date_of_birth = " + "'" + dateOfBirth + "'");
            List allCountries = query.getResultList();
            for(Object list : allCountries){
                System.out.println(list.toString());
            }

        }
    }

    @Override
    public Musicians createMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id) {
        try(Session session = factory.openSession()){
            //2, Начинаем транзакции
            Transaction tx = session.beginTransaction();

            //3. Создать объект Person
            Musicians musicians = new Musicians(id, first_name, middle_name, last_name, sex, date_of_birth, country_id,null);
            //4. Сохраняем ноового Person
            session.save(musicians);
            tx.commit();
            return musicians;
        }


    }
}
