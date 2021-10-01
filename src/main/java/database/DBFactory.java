package database;

import configurations.AuthProperties;

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
