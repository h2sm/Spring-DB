package logics;

import commands.Command;
import console.ConsolePrint;
import database.DBInterface;

public interface UserService {
    void setup(DBInterface dbInterface, ConsolePrint console);
    void retrieveCommand(Command command);
    void returnInformation();
    void exit();
}
