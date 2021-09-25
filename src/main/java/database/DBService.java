package database;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

@Slf4j
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
        log.info("findAll command was launched");
        var conn = src.getConnection();
        repository.findAll(conn);
    }

    @SneakyThrows
    @Override
    public void find(String str) {
        log.info("find command was launched");
        var conn = src.getConnection();
        repository.find(conn,str);
    }
}
