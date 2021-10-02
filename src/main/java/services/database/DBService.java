package services.database;

import crossFunctionality.logging.Loggable;
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
    @Loggable
    public Model findAll() {
        var conn = src.getConnection();
        return (Model) repository.findAll(conn);
    }

    @Override
    @SneakyThrows
    @Loggable
    public Model find(String str) {
        var conn = src.getConnection();
        return repository.find(conn, str);
    }
}
