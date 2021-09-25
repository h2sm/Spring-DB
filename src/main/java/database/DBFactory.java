package database;

import configuration.AuthProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBFactory {
    private static DBService service = null;
    public static synchronized DBInterface getInstance(AuthProperties p) {
        if (service == null) {
            log.info("DBService launched");
            service = new DBService(
                    new PGDataSource(p.getLogin(),p.getPassword(), p.getUrl()),
                    new DBRepository()
            );
        }
        return service;
    }
}
