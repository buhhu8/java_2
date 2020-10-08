package ru.levelup.musicians.library.jdbc;

import ru.levelup.musicians.library.jdbc.mapper.CountriesMapper;
import ru.levelup.musicians.library.model.countries;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CountriesJdbcService {
    private JdbcConnectionService jdbcConnectionService;
    private CountriesMapper countriesMapper;

    public CountriesJdbcService() {
        this.jdbcConnectionService = new JdbcConnectionService();
        this.countriesMapper = new CountriesMapper();
    }

    public Collection<countries> findCountries() {
        try (Connection connection = jdbcConnectionService.openConnection()) {
            Statement stmt = connection.createStatement(); // <<< Statement - оболочка (представление) над SQL запросом
            ResultSet rs = stmt.executeQuery("select * from countries");
            Collection<countries> countries = new ArrayList<>();
            while (rs.next()) {
                countries.add(countriesMapper.mapResultSet(rs));
            }
            System.out.println(countries);
            return countries;

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't execute findAllCountries method", exc);
        }
    }

    public Collection<countries> findCountryByName(String name) {
        try (Connection connection = jdbcConnectionService.openConnection()) {
            Statement stmt = connection.createStatement(); // <<< Statement - оболочка (представление) над SQL запросом
            String findedName = name;
            findedName = "'" + findedName + "'";
            ResultSet rs = stmt.executeQuery("select * from countries where country_name like " + findedName);
            Collection<countries> countries = new ArrayList<>();
            while (rs.next()) {
                countries.add(countriesMapper.mapResultSet(rs));

            }

            System.out.println(countries);
            return countries;

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't execute findCountryByName method", exc);
        }
    }

    public countries createCountry( String name) {

        try (Connection connection = jdbcConnectionService.openConnection()) {
            // "Ivan;Drop database banks;--"
            int id=0;
            String sql = "insert into countries values (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // prepareStatement(sql, new String[] { "id" });
            Statement stmtSelect = connection.createStatement();
            ResultSet rs = stmtSelect.executeQuery("select * from countries");
            while (rs.next()) {
                id=rs.getInt("country_id");
            }
            id++;
            stmt.setInt(1, id);
            stmt.setString(2, name);

            int affectedRows = stmt.executeUpdate(); // <<< используем этот метод для операций INSERT, UPDATE, DELETE
            System.out.println("Affected rows: " + affectedRows); // <<< сколько строк было изменено/добавлено/удалено

            ResultSet keysRS = stmt.getGeneratedKeys(); // таблица из одной колонки

            keysRS.next();
            int generateKey = keysRS.getInt(1);

            return countries.builder()
                    .country_id(generateKey)
                    .country_name(name)
                    .build();

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't create new Country", exc);
        }

    }
    public  void deleteCountry(int countryId) {

        try (Connection connection = jdbcConnectionService.openConnection()) {


            String sql = ("delete from countries where country_id = " + countryId);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql); // <<< используем этот метод для операций INSERT, UPDATE, DELETE
         } catch (SQLException exc) {
            throw new RuntimeException("Couldn't delete country", exc);
        }

    }
}