package ru.levelup.musicianHomework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.levelup.musicianHomework.hibernate.HibernateUtils;
import ru.levelup.musicianHomework.model.Musicians;
import ru.levelup.musicianHomework.repository.AlbumsRepository;
import ru.levelup.musicianHomework.repository.CountriesRepository;
import ru.levelup.musicianHomework.repository.GenresRepository;
import ru.levelup.musicianHomework.repository.impl.HibernateAlbumsRepository;
import ru.levelup.musicianHomework.repository.impl.HibernateGenresRepository;
import ru.levelup.musicianHomework.repository.impl.HibernateMusiciansRepositories;
import ru.levelup.musicianHomework.repository.MusiciansRepository;
import ru.levelup.musicianHomework.repository.impl.HibernateCountriesRepository;

import java.util.List;

public class testApp {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getFactory();
        CountriesRepository countriesRepository = new HibernateCountriesRepository(factory);
        MusiciansRepository musiciansRepository = new HibernateMusiciansRepositories(factory);
        AlbumsRepository albumsRepository = new HibernateAlbumsRepository(factory);
        GenresRepository genresRepository = new HibernateGenresRepository(factory);
        genresRepository.findMusiciansGenres();


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
  //       musiciansRepository.findByName("Ket");
   //     musiciansRepository.findByDateOfBirth(new Date (578169999000L));

     //   albumsRepository.findAlbums();

        //musiciansRepository.findMusicainsBands();
        factory.close();
    }
}
