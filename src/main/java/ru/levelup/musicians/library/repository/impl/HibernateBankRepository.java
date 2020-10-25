package ru.levelup.musicians.library.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicianHomework.model.Bands;
import ru.levelup.musicianHomework.repository.impl.HibernateBandsRepository;
import ru.levelup.musicians.library.model.Bank;
import ru.levelup.musicians.library.model.Person;
import ru.levelup.musicians.library.repository.BankRepository;

import java.util.List;


public class HibernateBankRepository extends AbstractRepository implements BankRepository {

    public HibernateBankRepository(SessionFactory factory){
        super(factory);
    }

    @Override
    public Bank createBank(String name) {
//        try(Session session = factory.openSession()){
//            Transaction tx = session.beginTransaction();
//
//            Bank bank = new Bank();
//            bank.setName(name);
//
//            session.persist(bank);
//
//            tx.commit();
//            runInTransaction(new MethodInvocation() {
//                @Override
//                public void process(Session session) {
//                    Bank bank = new Bank();
//                    bank.setName(name);
//                    session.persist(bank);
//                }
//            });

        return runInTransaction(s -> {
            Bank bank = new Bank();
            bank.setName(name);
            s.persist(bank);

            return bank;
        });

        }


    @Override
    public void addClient(Integer bankId, Person person) {
//        try (Session session = factory.openSession()){
//            Transaction tx = session.beginTransaction();
//
//            person = (Person) session.merge(person);
//
//            Bank bank = session.get(Bank.class, bankId);
//            bank.getBankPersons().add(person);
//            person.getBanks().add(bank);
//            session.persist(bank);
//
//            tx.commit();
//        }

        // (<аргументы методы) -> {}
        // Аргументы
        // если метод не имеет аргументов: () -. {}
        // если метод имеет один аргумент:
        //  arg1 -> {}
        //   (arg1) -> {}
        // если метод имеет 2 и более аргументов^
        // (arg1, arg2, arg3) -> {}

        // ->

        // Тело метода интерфейса, который вы переопределяете
        // если в методе выполняется только одно выражение  (по аналогии с return)
        // (arg1, arg2) -> object.someMethod (arg1, arg2);
        // если в методе выполняется больше одного выражения:
        // (arg1, arg2) -> {
        //     object o1 = object.someMethod(arg1);
        //     object o2 = object.someMethod(arg2);
        //     return o1.collapse(o2);
        // };




//        runInTransaction(new MethodInvocation() {
//            @Override
//            public void process(Session session) {
//            Person loadedPerson  = (Person) session.merge(person);
//            Bank bank = session.get(Bank.class, bankId);
//
//            bank.getBankPersons().add(loadedPerson);
//            person.getBanks().add(bank);
//
//            session.persist(bank);
//            }
//        });

        runInTransaction(session -> {
            Person loadedPerson  = (Person) session.merge(person);
            Bank bank = session.get(Bank.class, bankId);

            bank.getBankPersons().add(loadedPerson);
            person.getBanks().add(bank);

            session.persist(bank);
        });

    }

    @Override
    public List<Bank> finaAllBanks() {

//        try (Session session = factory.openSession()){
//            return session.createQuery("from Bank", Bank.class)
//                    .getResultList();
//
//        }
        return runWithoutTransaction(session -> session
                .createQuery("from Bank", Bank.class))
                .getResultList();
    }
}
