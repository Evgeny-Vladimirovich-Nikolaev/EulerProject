package utils.primes;

import java.sql.*;

public class PrimesFromDB {

    private Connection connection;

    public PrimesFromDB (String url, String user, String password) {
        try {
            this.connection = getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection(String url, String user, String password) throws SQLException {
        return  DriverManager.getConnection(url, user, password);
    }

}
