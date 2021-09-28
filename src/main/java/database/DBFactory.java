package database;

import configuration.AuthProperties;
import localization.MessageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBFactory {
    private static DBService service = null;
    public static synchronized DBInterface getInstance(AuthProperties p, MessageService messageService) {
        if (service == null) {
            log.info(messageService.localize("logging.dbGetInstanceMethodInitiated"));
            service = new DBService(
                    new PGDataSource(p.getLogin(),p.getPassword(), p.getUrl()),
                    new DBRepository()
            );
        }
        return service;
    }
}
