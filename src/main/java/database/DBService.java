package database;
import lombok.SneakyThrows;

import javax.sql.DataSource;

public class DBService implements DBInterface {
    private final DataSource src;
    private final DBRepository repository;

    public DBService(DataSource ds, DBRepository dbr) {
        this.src = ds;
        this.repository = dbr;
    }
    @SneakyThrows
    @Override
    public void findAll() {
        var conn = src.getConnection();
        repository.findAll(conn);
    }

    @SneakyThrows
    @Override
    public void find(String str) {
        var conn = src.getConnection();
        repository.find(conn,str);
    }
}
