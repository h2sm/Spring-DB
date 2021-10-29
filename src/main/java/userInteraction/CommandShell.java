package userInteraction;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import services.database.DBService;

import java.util.Collection;

@ShellComponent
@RequiredArgsConstructor
public class CommandShell {
    private final DBService service;
    @ShellMethod(value = "get all clients", key = {"all-clients", "find-all clients", "clients"})
    public void getAllClients() {
        print(service.findAllClients());
    }

    @ShellMethod(value = "clients by name part", key = {"find name", "client"})
    public void getClientsByNamePart(@ShellOption(defaultValue = "") String namepart) {
        print(service.findClientsByNamePart(namepart));
    }

    @ShellMethod(value = "get all attendants", key = {"find-all attendants", "attendants"})
    public void getAllAttendants() {
        print(service.findAllAttendants());
    }

    @ShellMethod(value = "get attendant/attendants by name", key = {"find attendant", "attendant"})
    public void getAttendantsByName(@ShellOption(defaultValue = "") String namepart) {
        print(service.findAttendantsByNamePart(namepart));
    }

    @ShellMethod(value = "set local for this session", key = {"set language", "lang"})
    public void setLocale(@ShellOption(defaultValue = "ru") String localeStr) {


    }
    private void print(Collection<?> col){
        col.forEach(System.out::println);
    }


}
