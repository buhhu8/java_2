package ru.levelup.musicians.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.musicianHomework.model.Bands;
import ru.levelup.musicians.library.hibernate.HibernateUtils;
import ru.levelup.musicians.library.model.Bank;
import ru.levelup.musicians.library.model.Person;
import ru.levelup.musicians.library.repository.BankRepository;
import ru.levelup.musicians.library.repository.DepositRepository;
import ru.levelup.musicians.library.repository.PersonRepository;
import ru.levelup.musicians.library.repository.impl.HibernateBankRepository;
import ru.levelup.musicians.library.repository.impl.HibernateDepositRepository;
import ru.levelup.musicians.library.repository.impl.HibernatePersonRepository;

import java.util.List;

public class TestApp {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getFactory();
        PersonRepository personRepository = new HibernatePersonRepository(factory);
        DepositRepository depositRepository = new HibernateDepositRepository(factory);

//        PersonLegalInfo legalInfo = personRepository.updateLegalInfo(
//                234,
//                "3453",
//                "534534",
//                "5987632",
//                "32987643"
//        );
        // PersonLegalInfo legalInfo = personRepository.getPersonLegalInfo(234);
        // System.out.println(legalInfo);
//
//        Person person = personRepository.findById(3);
//        System.out.println(person);
//
//        Person loadedPerson = personRepository.loadById(3);
//        System.out.println(loadedPerson);

//        Deposit deposit = depositRepository.createDeposit(
//                "СберКнижка3",
//                1.24,
//                false,
//                false,
//                10000
//        );
//
//        depositRepository.createDeposit(
//                "СберМаркет3",
//                0.45,
//                false,
//                false,
//                5000
//        );


//        Person person = personRepository.createNewPerson(
//                234,
//                "Oleg",
//                "Petrov",
//                null,
//                LocalDate.of(1994, 4, 29)
//        );

        // person - detached
//
//        Person byId = personRepository.findById(234);
//        System.out.println(byId);
//
//        List<Person> byLastName = personRepository.findByLastName("%ов%");
//        System.out.println(byLastName);
//
//        Session s = factory.openSession();
//        Transaction tx = s.beginTransaction();
//
//        s.createNativeQuery("drop database banks")
//                .executeUpdate();
//
//        tx.rollback();
//        s.close();

        BankRepository bankRepository = new HibernateBankRepository(factory);

        Bank bank = bankRepository.createBank("Сберwe2121212121212121212121r1");


        Person p1 = personRepository.findById(234);
        Person p2 = personRepository.findById(3);

        bankRepository.addClient(bank.getId(), p1);
        bankRepository.addClient(bank.getId(),p2);

        try (Session session = factory.openSession()){
            bank = session.get(bank.getClass(),bank.getId()); //переводим объект в persistance из detached
            List<Person> persons = bank.getBankPersons();
            System.out.println(persons);
        }

        factory.close();

    }

}
