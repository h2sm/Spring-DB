package database;

import aspects.logging.Loggable;
import configuration.AuthProperties;
import org.springframework.stereotype.Service;

public class DBFactory {
    private static DBService service = null;
    public static synchronized DBInterface getInstance(AuthProperties p) {
        if (service == null) {
            service = new DBService(
                    new PGDataSource(p.getLogin(),p.getPassword(), p.getUrl()),
                    new DBRepository());
        }
        return service;
    }
}
