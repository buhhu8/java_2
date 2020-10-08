package ru.levelup.musicians.library;

import org.hibernate.SessionFactory;
import ru.levelup.musicians.library.hibernate.HibernateUtils;
import ru.levelup.musicians.library.model.Person;
import ru.levelup.musicians.library.repository.PersonRepository;
import ru.levelup.musicians.library.repository.impl.HibernatePersonRepository;

import java.time.LocalDate;
import java.util.List;

public class testApp {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getFactory();
        PersonRepository personRepository = new HibernatePersonRepository(factory);

//        personRepository.createNewPerson(
//                234,
//                "Oleg",
//                "Petrov",
//                null,
//                LocalDate.of(1994,4,29)
//        );

        Person byID= personRepository.findById(234);
        System.out.println(byID);

        List<Person> byLastName = personRepository.findByLastName("%ов%");
        System.out.println(byLastName);

        factory.close();
    }
}
