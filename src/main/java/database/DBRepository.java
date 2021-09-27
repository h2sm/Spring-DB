package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBRepository {

    public ResultSet find(Connection conn, String str) throws SQLException {
        try (var ps = conn.prepareStatement("select * from " + str)) {
            return ps.executeQuery();
        }
    }

    public ResultSet findAll(Connection conn) throws SQLException {
        try (var ps = conn.prepareStatement("select ")) {
            return ps.executeQuery();
        }
    }
}
