package az.edu.turing.module4.lesson01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionDao {

    public Connection connect() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String name = "postgres";
        String password = "admin";

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(url, name, password);
    }

}
