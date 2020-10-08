package ru.levelup.musicians.library.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.hibernate.HibernateUtils;
import ru.levelup.musicians.library.model.Person;
import ru.levelup.musicians.library.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class HibernatePersonRepository implements PersonRepository {

    private final SessionFactory factory;

    @Override
    public Person createNewPerson(Integer id, String name, String lastName, String middleName, LocalDate bornDate) {
        // 1. Создать соеденение
        try(Session session = factory.openSession()){
            //2, Начинаем транзакции
            Transaction tx = session.beginTransaction();

            //3. Создать объект Person
            Person person = new Person(id,name, lastName, middleName, bornDate);
    //4. Сохраняем ноового Person
            session.save(person);
            tx.commit();
            return person;
        }
    }

    @Override
    public Person findById(Integer id) {
        try(Session session = factory.openSession()){
            //найти строку по ID, можно воспользоваться одним из методов: get или load
            return session.get(Person.class, id);
        }

    }

    @Override
    public List<Person> findByLastName(String lastName) {
        try(Session session = factory.openSession()){
            return session.createQuery("from Person where lastName like :lastName", Person.class)
                    .setParameter("lastName", lastName)
                    .getResultList();
        }
    }
}
