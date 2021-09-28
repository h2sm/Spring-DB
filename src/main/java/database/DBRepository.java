package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBRepository {

    public ResultSet find(Connection conn, String str) throws SQLException {
        var statement = conn.prepareStatement("select * from " + str);
        var rs = statement.executeQuery();
        conn.close();
        return rs;
    }

    public ResultSet findAll(Connection conn) throws SQLException { //select tablename from pg_catalog.pg_tables where schemaname = 'public';
        var statement = conn.prepareStatement("SELECT * FROM pg_catalog.pg_tables where schemaname = 'public';");
        var rs = statement.executeQuery();
        conn.close();
        return rs;
    }
}
