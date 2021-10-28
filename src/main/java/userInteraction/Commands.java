package userInteraction;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Commands {
    @ShellMethod(value = "get all clients", key = {"all-clients", "find-all clients", "clients"})
    public void getAllClients() {

    }

    @ShellMethod(value = "clients by name part", key = {"find name", "client"})
    public void getClientsByNamePart(@ShellOption(defaultValue = "") String namepart) {

    }

    @ShellMethod(value = "get all attendants", key = {"find-all attendants", "attendants"})
    public void getAllAttendants() {

    }

    @ShellMethod(value = "get attendant/attendants by name", key={"find attendant", "attendant"})
    public void getAttendantsByName(@ShellOption(defaultValue = "") String namepart) {
    }


}
