package database;

import commands.FindAchievements;
import models.FindAchievementsModel;
import models.FindAllModel;
import models.Model;

import java.sql.Connection;
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

    public Model findAll(Connection conn) throws SQLException {
        String sqlStatement = "SELECT t.tablename, ROW_NUMBER() OVER (ORDER BY (SELECT 1)) AS number FROM pg_catalog.pg_tables AS t where schemaname = 'public'";
        try (var statement = conn.prepareStatement(sqlStatement)) {
            var map = new TreeMap<Integer, String>();
            var rs = statement.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("number");
                var text = rs.getString("tablename");
                map.put(num, text);
            }
            conn.close();
            return new FindAllModel(map);
        }

    }
}
