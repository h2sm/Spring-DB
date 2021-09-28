package database;
import localization.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@RequiredArgsConstructor
public class DBService implements DBInterface {
    private final DataSource src;
    private final DBRepository repository;
    private final MessageService ms;

    @SneakyThrows
    @Override
    public ResultSet findAll() {
        log.info(ms.localize("logging.findInitiated"));
        var conn = src.getConnection();
        return repository.findAll(conn);
    }

    @Override
    public ResultSet find(String str) {
        log.info(ms.localize("logging.findAllInitiated"));
        ResultSet rs = null;
        try {
            var conn = src.getConnection();
            rs = repository.find(conn,str);
            return rs;
        }
        catch (SQLException e){
            log.error(ms.localize("logging.cantHandleCommException"));
        }
        return rs;
    }
}
