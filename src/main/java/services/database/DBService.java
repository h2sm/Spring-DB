package services.database;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import models.Model;

import javax.sql.DataSource;

@RequiredArgsConstructor
public class DBService implements DBInterface {
    private final DataSource src;
    private final DBRepository repository;

    @SneakyThrows
    @Override
    public Model findAll() {
        var conn = src.getConnection();
        return (Model) repository.findAll(conn);
    }

    @Override
    @SneakyThrows
    public Model find(String str) {
        var conn = src.getConnection();
        return repository.find(conn, str);
    }
}
