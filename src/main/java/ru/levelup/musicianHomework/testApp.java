package ru.levelup.musicianHomework;

import org.hibernate.SessionFactory;
import ru.levelup.musicianHomework.hibernate.HibernateUtils;
import ru.levelup.musicianHomework.model.musicians;
import ru.levelup.musicianHomework.repository.CountriesRepository;
import ru.levelup.musicianHomework.repository.HibernateCountriesRepository;
import ru.levelup.musicianHomework.repository.HibernateMusiciansRepositories;
import ru.levelup.musicianHomework.repository.MusiciansRepository;

import java.sql.Date;

public class testApp {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getFactory();
        CountriesRepository countriesRepository = new HibernateCountriesRepository(factory);
        MusiciansRepository musiciansRepository = new HibernateMusiciansRepositories(factory);

        countriesRepository.findCountries();
        System.out.println(countriesRepository.findCountryByName("Russia"));

//        countries country  = countriesRepository.createCountry(
//                4,
//                "Iran"
//        );

 //    countriesRepository.deleteCountry(4);

   //     musicians musicians = musiciansRepository.createMusician(1, "Jaba", "Jaba", "m", "m", new Date(-289798384000L),3);
        musiciansRepository.updateMusician(1,"Denis","df","dfgd","f",new Date(-289798384000L),3);
   //     musiciansRepository.deleteMusician(1);
  //       musiciansRepository.findByName("Ket");
   //     musiciansRepository.findByDateOfBirth(new Date (578169999000L));
        factory.close();
    }
}
