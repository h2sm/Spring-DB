package logics;

import commands.*;
import commands.parsing.Parser;
import console.UI;
import database.DBInterface;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;

@Slf4j
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
        log.info("User Service started");
        do {
            var comm = retrieveCommand();
            handleCommand(comm);
        } while (true);
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

    private ResultSet find(Find command) {
        return db.find(command.getParam());
    }

    private ResultSet findAll(FindAll command) {
        return db.findAll();
    }

    @Override
    public void returnInformation(ResultSet rs) {
        ui.show("Nothing ");
    }

    @Override
    public void exit(Exit command) {
        command.doExit();
    }
}