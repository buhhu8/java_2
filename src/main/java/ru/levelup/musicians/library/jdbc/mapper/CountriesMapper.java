package ru.levelup.musicians.library.jdbc.mapper;
import ru.levelup.musicians.library.jdbc.model.countries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountriesMapper {
    public countries mapResultSet(ResultSet rs) throws SQLException {
        return countries.builder()
                .country_id(rs.getInt("country_id"))
                .country_name(rs.getString("country_name"))
                .build();
    }

}
