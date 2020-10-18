package ru.levelup.musicianHomework.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.levelup.musicianHomework.model.Bands;
import ru.levelup.musicianHomework.model.Musicians;
import ru.levelup.musicianHomework.model.countries;
import ru.levelup.musicianHomework.repository.CountriesRepository;

import java.util.List;

@RequiredArgsConstructor

    public  class HibernateCountriesRepository implements CountriesRepository {

        private final SessionFactory factory;

        @Override
        public countries createCountry(Integer id, String name) {
            try(Session session = factory.openSession()){
                //2, Начинаем транзакции
                Transaction tx = session.beginTransaction();

                //3. Создать объект Person
                countries country = new countries(id,name,null,null);
        //4. Сохраняем ноового Person
                session.save(country);
                tx.commit();
                return country;
            }
        }

        @Override
        public void findCountries() {
            try (Session session = factory.openSession()) {
                //найти строку по ID, можно воспользоваться одним из методов: get или load
                Musicians musicians = new Musicians();
                musicians.getCountry_id();
                Bands bands = new Bands();
                bands.getBandId();
                Query query = session.createQuery("FROM countries");
                List allCountries = query.list();
                for (Object list : allCountries) {
                    System.out.println(list);
                }
            }
        }

        @Override
        public countries findCountryByName(String name) {
            try (Session session = factory.openSession()) {
                //найти строку по ID, можно воспользоваться одним из методов: get или load

                Query query = session.createQuery("FROM countries C WHERE C.country_name = " + "'" + name + "'");
                List allCountries = query.list();
                Object county = allCountries.get(0);
                return (countries) county;
            }
        }

        @Override
        public void deleteCountry(Integer country_id) {
            try (Session session = factory.openSession()) {
                //найти строку по ID, можно воспользоваться одним из методов: get или load
                Transaction tx = session.beginTransaction();
                String hqlDelete = "DELETE FROM countries WHERE country_id = :oldName";
                int deletedEntities = session.createQuery( hqlDelete )
                        .setInteger( "oldName", country_id)
                        .executeUpdate();
                tx.commit();
                session.close();
            }
        }


    }
