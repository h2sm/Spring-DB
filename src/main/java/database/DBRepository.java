package database;

import commands.FindAchievements;
import models.FindAchievementsModel;
import models.FindAllModel;
import models.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class DBRepository {

    public Model find(Connection conn, String str) throws SQLException {
        try (var statement = conn.prepareStatement("select * from " + str)) {
            var map = new TreeMap<Integer, String>();
            var rs = statement.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("achievements_id");
                var text = rs.getString("achievement");
                map.put(num, text);
            }
            conn.close();
            return new FindAchievementsModel(map);
        }
    }

    public Model findAll(Connection conn) throws SQLException { //select tablename from pg_catalog.pg_tables where schemaname = 'public';
        var statement = conn.prepareStatement("SELECT * FROM pg_catalog.pg_tables where schemaname = 'public';");
        var rs = statement.executeQuery();
        conn.close();
        return new FindAllModel();
    }
}
