package services.database;

import crossFunctionality.logging.Loggable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import models.Attendant;
import models.Client;
import models.Model;

import javax.sql.DataSource;
import java.util.Collection;

@RequiredArgsConstructor
public class DBService implements DBInterface {
    private final DataSource src;
    private final DBRepository repository;

    @Override
    @SneakyThrows
    public Collection<Client> findAllClients() {
        var conn = src.getConnection();
        return repository.findAllClients(conn);

    }

    @Override
    @SneakyThrows
    public Collection<Client> findClientsByNamePart(String str) {
        var conn = src.getConnection();
        return repository.findClientByNamePart(conn,str);
    }

    @Override
    @SneakyThrows
    public Collection<Attendant> findAllAttendants() {
        var conn = src.getConnection();
        return repository.findAllAttendants(conn);
    }

    @Override
    @SneakyThrows
    public Collection<Attendant> findAttendantsByNamePart(String str) {
        var conn = src.getConnection();
        return repository.findAttendantsByNamePart(conn,str);
    }
}
