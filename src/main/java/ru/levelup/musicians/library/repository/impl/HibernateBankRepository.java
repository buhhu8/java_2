package ru.levelup.musicians.library.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.model.Bank;
import ru.levelup.musicians.library.model.Person;
import ru.levelup.musicians.library.repository.BankRepository;

import java.util.List;

@RequiredArgsConstructor
public class HibernateBankRepository implements BankRepository {

    private final SessionFactory factory;

    @Override
    public Bank createBank(String name) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();

            Bank bank = new Bank();
            bank.setName(name);

            session.persist(bank);

            tx.commit();

            return bank;
        }
    }

    @Override
    public void addClient(Integer bankId, Person person) {
        try (Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();

            person = (Person) session.merge(person);

            Bank bank = session.get(Bank.class, bankId);
            bank.getBankPersons().add(person);
            person.getBanks().add(bank);
            session.persist(bank);

            tx.commit();
        }
    }

    @Override
    public List<Bank> finaAllBanks() {

        try (Session session = factory.openSession()){
            return session.createQuery("from Bank", Bank.class)
                    .getResultList();

        }
    }
}
