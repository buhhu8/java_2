package ru.levelup.musicians.library.jdbc;

import ru.levelup.musicians.library.jdbc.mapper.DepositMapper;
import ru.levelup.musicians.library.model.Deposit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DepositJdbcService {

    private JdbcConnectionService jdbcConnectionService;
    private DepositMapper depositMapper;

    public DepositJdbcService() {
        this.jdbcConnectionService = new JdbcConnectionService();
        this.depositMapper = new DepositMapper();
    }

    public Collection<Deposit> findAllDeposits() {
        try (Connection connection = jdbcConnectionService.openConnection()) {
            // select * from deposits
            Statement stmt = connection.createStatement(); // <<< Statement - оболочка (представление) над SQL запросом
            ResultSet rs = stmt.executeQuery("select * from deposits");
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                double rate = rs.getDouble(3);
//                boolean canPartialRemoval = rs.getBoolean(4);
//                boolean canReplenishment = rs.getBoolean(5);
//                double minAmount = rs.getDouble(6);
//
//                String line = String.join(" | ",
//                        String.valueOf(id),
//                        name,
//                        String.valueOf(rate),
//                        String.valueOf(canPartialRemoval),
//                        String.valueOf(canReplenishment),
//                        String.valueOf(minAmount)
//                );
//                System.out.println(line);
//            }

            Collection<Deposit> deposits = new ArrayList<>();
            while (rs.next()) {
                deposits.add(depositMapper.mapResultSet(rs));
            }

            return deposits;

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't execute findAllDeposits method", exc);
        }
    }

    public Deposit createNewDeposit(String name, double rate, boolean canPartialRemoval, boolean canReplenishment, double minAmount) {

        try (Connection connection = jdbcConnectionService.openConnection()) {
            // "Ivan;Drop database banks;--"

            String sql = "insert into deposits values (nextval('deposit_id_sequence'), ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // prepareStatement(sql, new String[] { "id" });

            stmt.setString(1, name);
            stmt.setDouble(2, rate);
            stmt.setBoolean(3, canPartialRemoval);
            stmt.setBoolean(4, canReplenishment);
            stmt.setDouble(5, minAmount);

            int affectedRows = stmt.executeUpdate(); // <<< используем этот метод для операций INSERT, UPDATE, DELETE
            System.out.println("Affected rows: " + affectedRows); // <<< сколько строк было изменено/добавлено/удалено

            ResultSet keysRS = stmt.getGeneratedKeys(); // таблица из одной колонки

            keysRS.next();
            int generateKey = keysRS.getInt(1);

            return Deposit.builder()
                    .id(generateKey)
                    .name(name)
                    .rate(rate)
                    .canPartialRemoval(canPartialRemoval)
                    .canReplenishment(canReplenishment)
                    .amount(minAmount)
                    .build();

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't create new deposit", exc);
        }

    }

}