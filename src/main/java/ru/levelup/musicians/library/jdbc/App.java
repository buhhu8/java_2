package ru.levelup.musicians.library.jdbc;


import java.sql.Date;

public class App {

    public static void main(String[] args) {
        CountriesJdbcService countriesJdbcService = new CountriesJdbcService();
        MusicianJdbcService musicianJdbcService = new MusicianJdbcService();
        musicianJdbcService.findByDateOfBirth(new Date(-289798384000L));
       // musicianJdbcService.createMusician("Igor","Talkov","SA","m","1980-11-11",2);
       // musicianJdbcService.findByDateOfBirth(new Date(1960,10,25));
      //  musicianJdbcService.updateMusician(5,"Ket","Kot","Nik", "f", "1988-04-27",2);
        //countriesJdbcService.createCountry("Belgium");
       //countriesJdbcService.deleteCountry(4);
      //  countriesJdbcService.findCountries();
       // MusicianJdbcService musicianJdbcService = new MusicianJdbcService();
       // musicianJdbcService.findAllDeposits();


        /*musicians newMusicians = musicianJdbcService.createNewDeposit(
                "Мечтай!", 9.87, true, true, 1000
        );
        System.out.println(newDeposit); */
    }

}
