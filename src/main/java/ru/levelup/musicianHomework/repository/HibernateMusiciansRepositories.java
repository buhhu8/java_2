package ru.levelup.musicianHomework.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicianHomework.model.musicians;

import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@RequiredArgsConstructor
public class HibernateMusiciansRepositories implements MusiciansRepository{

    private final SessionFactory factory;

    @Override
    public void updateMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id) {

    }
//    @Override
//    public void updateMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id) {
//        try (Session session = factory.openSession()) {
//            //найти строку по ID, можно воспользоваться одним из методов: get или load
//            Transaction tx = session.beginTransaction();
//            String hqlUpdate = "UPDATE musicians SET id = 1, first_name = 'asd' , middle_name = 'sdfsd' ,last_name = 'sdfds', sex = 'f', date_of_birth = -289798384000L, country_id = 2 WHERE id = 1" ;
//            System.out.println(hqlUpdate);
//            session.update( hqlUpdate, musicians.class );
////                    .setInteger( "id", id)
////                    .setString("first_name", first_name)
////                    .setString("middle_name", middle_name)
////                    .setString("last_name", last_name)
////                    .setString("sex",sex)
////                    .setDate("date_of_birth",date_of_birth)
////                    .setInteger("country_id", country_id)
////                    .executeUpdate();
//            tx.commit();
//            session.close();
//        }
//    }

    @Override
    public void deleteMusician(Integer id) {
        try (Session session = factory.openSession()) {
            //найти строку по ID, можно воспользоваться одним из методов: get или load
            Transaction tx = session.beginTransaction();
            String hqlDelete = "DELETE FROM musicians WHERE id = :id";
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

            Query query = session.createQuery("FROM musicians  WHERE first_name LIKE " + "'" + name + "'");
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

            Query query = session.createQuery("FROM musicians  WHERE date_of_birth = " + "'" + dateOfBirth + "'");
            List allCountries = query.getResultList();
            for(Object list : allCountries){
                System.out.println(list.toString());
            }

        }
    }

    @Override
    public musicians createMusician(Integer id, String first_name, String middle_name, String last_name, String sex, Date date_of_birth, Integer country_id) {
        try(Session session = factory.openSession()){
            //2, Начинаем транзакции
            Transaction tx = session.beginTransaction();

            //3. Создать объект Person
            musicians musicians = new musicians(id, first_name, middle_name, last_name, sex, date_of_birth, country_id);
            //4. Сохраняем ноового Person
            session.save(musicians);
            tx.commit();
            return musicians;
        }


    }
}
