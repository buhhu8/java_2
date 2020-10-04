package ru.levelup.musicians.library.jdbc.mapper;

import ru.levelup.musicians.library.jdbc.model.musicians;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicianMapper {
    public musicians mapResultSet(ResultSet rs) throws SQLException {
        return musicians.builder()
                    .id(rs.getInt("id"))
                    .first_name(rs.getString("first_name"))
                    .middle_name(rs.getString("middle_name"))
                    .last_name(rs.getString("last_name"))
                    .sex(rs.getString("sex"))
                    .date_of_birth(rs.getDate("date_of_birth"))
                    .country_id(rs.getInt("country_id"))
                    .build();
        }

    }

