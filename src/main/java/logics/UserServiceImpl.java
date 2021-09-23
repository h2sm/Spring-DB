package logics;

import commands.*;
import commands.parsing.Parser;
import console.UI;
import database.DBInterface;

public class UserServiceImpl implements UserService {
    private final UI ui;
    private final DBInterface db;
    private final Parser parser;

    public UserServiceImpl(UI ui, DBInterface dbInterface, Parser parser) {
        this.ui = ui;
        this.db = dbInterface;
        this.parser = parser;
    }

    @Override
    public void start() {
        while (true) {
            var comm = retrieveCommand();
            handleCommand(comm);
        }
    }

    @Override
    public Command retrieveCommand() {
        var str = ui.read();
        return parser.parse(str);
    }

    @Override
    public void handleCommand(Command command) {
        if (command.getClass() == Exit.class) exit((Exit) command);
        if (command.getClass() == Find.class) find((Find) command);
        if (command.getClass() == FindAll.class) findAll((FindAll) command);
    }

    private void find(Find command) {
        db.find(command.getParam());
    }

    private void findAll(FindAll command) {
        db.findAll();
    }

    @Override
    public void returnInformation() {

    }

    @Override
    public void exit(Exit command) {
        command.doExit();
    }
}