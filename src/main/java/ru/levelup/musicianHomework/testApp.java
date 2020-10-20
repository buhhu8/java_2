package ru.levelup.musicianHomework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.musicianHomework.hibernate.HibernateUtils;
import ru.levelup.musicianHomework.model.Genres;
import ru.levelup.musicianHomework.model.Musicians;
import ru.levelup.musicianHomework.repository.*;
import ru.levelup.musicianHomework.repository.impl.*;

import java.util.List;

public class testApp {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getFactory();
        CountriesRepository countriesRepository = new HibernateCountriesRepository(factory);
        MusiciansRepository musiciansRepository = new HibernateMusiciansRepositories(factory);
        AlbumsRepository albumsRepository = new HibernateAlbumsRepository(factory);
        GenresRepository genresRepository = new HibernateGenresRepository(factory);
        BandsRepository bandsRepository = new HibernateBandsRepository(factory);

        albumsRepository.findAlbums();

        //musiciansRepository.findMusicainsBands();




//        System.out.println(countriesRepository.findCountryByName("Russia"));
//        countriesRepository.deleteCountry(5);
//        countries country  = countriesRepository.createCountry(
//                5,
//                "Belgium"
//        );
    //    countriesRepository.findCountries();



   //     Musicians Musicians = musiciansRepository.createMusician(1, "Jaba", "Jaba", "m", "m", new Date(-289798384000L),3);
   //   musiciansRepository.updateMusician(1,"Denis","df","dfgd","f",new Date(-289798384000L),3);
   //     musiciansRepository.deleteMusician(1);
  //       musiciansRepository.findById("Ket");
   //     musiciansRepository.findByDateOfBirth(new Date (578169999000L));

     //   albumsRepository.findAlbums();

        //musiciansRepository.findMusicainsBands();
        factory.close();
    }
}
