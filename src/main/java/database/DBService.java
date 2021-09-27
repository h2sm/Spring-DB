package database;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public ResultSet findAll() {
        log.info("findAll command was launched");
        var conn = src.getConnection();
        return repository.findAll(conn);
    }

    @Override
    public ResultSet find(String str) {
        log.info("find command was launched");
        ResultSet rs = null;
        try {
            var conn = src.getConnection();
            rs = repository.find(conn,str);
            return rs;
        }
        catch (SQLException e){
            log.error("Cant handle this find command");
        }
        return rs;
    }
}
