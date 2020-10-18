package ru.levelup.musicians.library.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionService {

    static {
        registerJdbcDriver();
    }

    private static void registerJdbcDriver() {
        try {
            Class.forName("org.postgresql.Driver"); // <<< загружаются в память
            // инициализируется объект Class для этого класса (загруженного)
            // дальше отрабатывает static
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't register JDBC driver", e);
        }
    }

    public Connection openConnection() {
        // Connection - объектное представление физического соединения к базе
        try {
            return DriverManager.getConnection(
                    // jdbc:<vendor_name>://<host>:<port>/<db_name>?<external_parameter>
                    "jdbc:postgresql://127.0.0.1:5432/banks",
                    "postgres",
                    "0280829Denis"
            );
        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't open connection to database", exc);
        }
    }

}
