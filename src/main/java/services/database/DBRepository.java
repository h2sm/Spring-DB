package services.database;

import models.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class DBRepository {

    public Collection<Client> findAllClients(Connection conn) throws SQLException {
        var sql = "select * from client";
        var col = new ArrayList<Client>();
        try (var statement = conn.prepareStatement(sql)) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                col.add(new Client(
                        rs.getInt("client_id"),
                        rs.getString("full_name"),
                        rs.getString("passport"),
                        rs.getString("tel_name"),
                        rs.getDate("date_of_birth")
                ));
            }
        }
        return col;
    }

    public Collection<Client> findClientByNamePart(Connection conn, String namePart) throws SQLException {
        var sql = "select * from client where full_name like '%" + namePart + "%'";
        var col = new ArrayList<Client>();
        try (var statement = conn.prepareStatement(sql)) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                col.add(new Client(
                        rs.getInt("client_id"),
                        rs.getString("full_name"),
                        rs.getString("passport"),
                        rs.getString("tel_name"),
                        rs.getDate("date_of_birth")
                ));
            }
        }
        return col;
    }

    public Collection<Attendant> findAllAttendants(Connection conn) throws SQLException {
        var sql = "select * from attendant";
        var col = new ArrayList<Attendant>();
        try (var stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                col.add(new Attendant(
                        rs.getInt("attendant_id"),
                        rs.getString("attendant_name"),
                        rs.getString("tel_number")
                ));
            }
        }
        return col;
    }

    public Collection<Attendant> findAttendantsByNamePart(Connection conn, String s) throws SQLException {
        var sql = "select * from attendant a where a.attendant_name = " + "\'" + s + "\'";
        var col = new ArrayList<Attendant>();
        try (var stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                col.add(new Attendant(
                        rs.getInt("attendant_id"),
                        rs.getString("attendant_name"),
                        rs.getString("tel_number")
                ));
            }
        }
        return col;
    }

}
