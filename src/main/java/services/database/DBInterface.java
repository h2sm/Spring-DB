package services.database;

import models.Attendant;
import models.Client;
import models.Model;

import java.util.Collection;

public interface DBInterface {
   Collection<Client> findAllClients();
   Collection<Client> findClientsByNamePart(String str);
   Collection<Attendant> findAllAttendants();
   Collection<Attendant> findAttendantsByNamePart(String str);
}
