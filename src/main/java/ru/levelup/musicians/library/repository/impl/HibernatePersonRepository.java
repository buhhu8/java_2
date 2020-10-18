package ru.levelup.musicians.library.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.model.Person;
import ru.levelup.musicians.library.model.PersonLegalInfo;
import ru.levelup.musicians.library.repository.PersonRepository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor // создаст конструктор только с final полями
public class HibernatePersonRepository implements PersonRepository {

    private final SessionFactory factory;

    @Override
    public Person createNewPerson(Integer id, String name, String lastName, String middleName, LocalDate bornDate) {
        // 1. Создать соединение
        try (Session session = factory.openSession()) { // открываем новое соединение к базе
            // 2. Начинаем транзакцию
            Transaction tx = session.beginTransaction();

            // 3. Создать объект Person
            Person person = new Person(id, name, lastName, middleName, bornDate, null, null, null, null);
            // ...
            // 4. Сохраняем нового Person
            Serializable personId = session.save(person);// выполнит insert запрос
            // personId == id -> true

            // person.setLastName(lastName + " Update");
            // Я могу не вызывать метод update, потому что Hibernate сделает это сам

            tx.commit();

            return person;
        }
        // person - detached state
    }

    @Override
    public PersonLegalInfo updateLegalInfo(Integer personId, String passportSeries, String passportNumber, String inn, String snils) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            PersonLegalInfo legalInfo = new PersonLegalInfo();
            legalInfo.setPersonId(personId);
            legalInfo.setPassportSeries(passportSeries);
            legalInfo.setPassportNumber(passportNumber);
            legalInfo.setInn(inn);
            legalInfo.setSnils(snils);

            session.persist(legalInfo);

            tx.commit();

            return legalInfo;
        }
    }

    @Override
    public PersonLegalInfo getPersonLegalInfo(Integer personId) {
        try (Session session = factory.openSession()) {
            return session.get(PersonLegalInfo.class, personId);
        }
    }

    @Override
    public Person findById(Integer id) {
        try (Session session = factory.openSession()) {
            // Чтобы найти строку по ID, можно воспользоваться одним из методов: get или load
            // System.out.println(person.getAccounts());
            return session.get(Person.class, id);
        }
    }

    @Override
    public Person loadById(Integer id) {
        try (Session session = factory.openSession()) {
            Person person = session.load(Person.class, id);
            System.out.println(person.getLastName());
            return person;
        }
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Person where lastName like :lastName", Person.class) // HQL
                    .setParameter("lastName", lastName)
                    .getResultList();
        }
    }

}
