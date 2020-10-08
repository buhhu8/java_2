package ru.levelup.musicians.library.jdbc;

import ru.levelup.musicians.library.jdbc.mapper.MusicianMapper;
import ru.levelup.musicians.library.model.musicians;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class MusicianJdbcService {
        private JdbcConnectionService jdbcConnectionService;
        private MusicianMapper MusicianMapper;

        public MusicianJdbcService() {
            this.jdbcConnectionService = new JdbcConnectionService();
            this.MusicianMapper = new MusicianMapper();
        }


    public musicians createMusician(String first_name, String middle_name, String last_name, String sex, String date_of_birth, Integer country_id) {

        try (Connection connection = jdbcConnectionService.openConnection()) {
            // "Ivan;Drop database banks;--"
            int id=0;
            String sql = "insert into musicians values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // prepareStatement(sql, new String[] { "id" });
            Statement stmtSelect = connection.createStatement();
            ResultSet rs = stmtSelect.executeQuery("select * from musicians");
            while (rs.next()) {
                id=rs.getInt("id");
            }
            id++;
            stmt.setInt(1, id);
            stmt.setString(2, first_name);
            stmt.setString(3,middle_name);
            stmt.setString(4,last_name);
            stmt.setString(5,sex);
            stmt.setDate(6, Date.valueOf((date_of_birth)));
            stmt.setInt(7,country_id);

            int affectedRows = stmt.executeUpdate(); // <<< используем этот метод для операций INSERT, UPDATE, DELETE
            System.out.println("Affected rows: " + affectedRows); // <<< сколько строк было изменено/добавлено/удалено

            ResultSet keysRS = stmt.getGeneratedKeys(); // таблица из одной колонки

            keysRS.next();
            int generateKey = keysRS.getInt(1);

            return musicians.builder()
                    .country_id(generateKey)
                    .first_name(first_name)
                    .middle_name(middle_name)
                    .last_name(last_name)
                    .sex(sex)
                    .date_of_birth(Date.valueOf(date_of_birth))
                    .country_id(country_id)
                    .build();

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't create new musician", exc);
        }

    }

    public void updateMusician(Integer id,String first_name, String middle_name, String last_name, String sex, String date_of_birth, Integer country_id) {

        try (Connection connection = jdbcConnectionService.openConnection()) {


           String sql = ("update musicians SET id = " + id + ", first_name = " + "'" + first_name + "'" + ", middle_name = " + "'" + middle_name +"'"
                            + ", last_name= " + "'"+ last_name + "'" + ", sex= " + "'" + sex + "'" + ",date_of_birth= " + "'" + date_of_birth + "'" + ",country_id= " + country_id
                                + " where id=" + id);

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't update musicians", exc);
        }

    }

    public  void deleteMusician(int Id) {

        try (Connection connection = jdbcConnectionService.openConnection()) {


            String sql = ("delete from musicians where id = " + Id);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql); // <<< используем этот метод для операций INSERT, UPDATE, DELETE
        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't delete from musicians", exc);
        }

    }

    public Collection<musicians> findByName(String name) {
        try (Connection connection = jdbcConnectionService.openConnection()) {
            Statement stmt = connection.createStatement(); // <<< Statement - оболочка (представление) над SQL запросом
            String findedName = name;
            findedName = "'" + findedName + "'";
            ResultSet rs = stmt.executeQuery("select * from musicians where first_name like " + findedName);
            Collection<musicians> countries = new ArrayList<>();
            while (rs.next()) {
                countries.add(MusicianMapper.mapResultSet(rs));

            }

            System.out.println(countries);
            return countries;

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't execute findMusicianByName method", exc);
        }
    }

    public Collection<musicians> findByDateOfBirth(java.util.Date dateOfBirth) {
        try (Connection connection = jdbcConnectionService.openConnection()) {
            Statement stmt = connection.createStatement(); // <<< Statement - оболочка (представление) над SQL запросом
            String findedName = String.valueOf(dateOfBirth);
            String sql = "select * from musicians where date_of_birth = " + "'" + findedName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            Collection<musicians> countries = new ArrayList<>();
            while (rs.next()) {
                countries.add(MusicianMapper.mapResultSet(rs));

            }

            System.out.println(countries);
            return countries;

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't execute findMusicianByDateOfBirth method", exc);
        }
    }

    }
