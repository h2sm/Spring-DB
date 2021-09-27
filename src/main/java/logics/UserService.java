package logics;

import commands.Command;
import commands.Exit;

import java.sql.ResultSet;

public interface UserService {
    void start();
    Command retrieveCommand();
    void handleCommand(Command command);
    void returnInformation(ResultSet rs);
    void exit(Exit command);
}
