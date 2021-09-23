package logics;

import commands.Command;
import commands.Exit;

public interface UserService {
    void start();
    Command retrieveCommand();
    void handleCommand(Command command);
    void returnInformation();
    void exit(Exit command);
}
