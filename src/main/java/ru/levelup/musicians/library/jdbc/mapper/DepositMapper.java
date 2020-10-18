package ru.levelup.musicians.library.jdbc.mapper;

import ru.levelup.musicians.library.model.Deposit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositMapper {

    public Deposit mapResultSet(ResultSet rs) throws SQLException {
        return Deposit.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .rate(rs.getDouble("rate"))
                .canPartialRemoval(rs.getBoolean("can_partial_removal"))
                .canReplenishment(rs.getBoolean("can_replenishment"))
                .amount((int)rs.getDouble("amount"))
                .build();
    }

}
