package database;
import aspects.logging.Loggable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class DBService implements DBInterface {
    private final DataSource src;
    private final DBRepository repository;

    @SneakyThrows
    @Override
    @Loggable
    public ResultSet findAll() {
        var conn = src.getConnection();
        return repository.findAll(conn);
    }

    @Override
    @Loggable
    public ResultSet find(String str) {
        ResultSet rs = null;
        try {
            var conn = src.getConnection();
            rs = repository.find(conn,str);
            return rs;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
