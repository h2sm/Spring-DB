package userInteraction;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import services.consoleIO.ConsoleUI;
import services.database.DBService;
import services.localization.MessageService;

import java.util.Collection;

@ShellComponent
@RequiredArgsConstructor
public class CommandShell {
    private final DBService service;
    private final ConsoleUI ui;

    @ShellMethod(value = "get all clients", key = {"all-clients", "find-all clients", "clients"})
    public void getAllClients() {
        ui.localize("logging.loadingAllCLients");
        ui.printCollection(service.findAllClients());
    }

    @ShellMethod(value = "clients by name part", key = {"find name", "client"})
    public void getClientsByNamePart(@ShellOption(defaultValue = "") String namepart) {
        ui.localize("logging.loadingClient");
        ui.printCollection(service.findClientsByNamePart(namepart));
    }

    @ShellMethod(value = "get all attendants", key = {"find-all attendants", "attendants"})
    public void getAllAttendants() {
        ui.localize("logging.loadingAllAttendants");
        ui.printCollection(service.findAllAttendants());
    }

    @ShellMethod(value = "get attendant/attendants by name", key = {"find attendant", "attendant"})
    public void getAttendantsByName(@ShellOption(defaultValue = "") String namepart) {
        ui.localize("logging.loadingAttendant");
        ui.printCollection(service.findAttendantsByNamePart(namepart));
    }

    @ShellMethod(value = "set local for this session", key = {"set language", "lang"})
    public void setLocale(@ShellOption(defaultValue = "ru") String localeStr) {
        ui.changeLocale(localeStr);
    }

}
