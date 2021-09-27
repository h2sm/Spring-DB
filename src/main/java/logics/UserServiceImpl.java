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
            ResultSet rs = null;
            var comm = retrieveCommand();
            if (comm.getClass()==Exit.class) exit((Exit) comm);
            if (comm.getClass()==Find.class) rs = find((Find) comm);
            if (comm.getClass()==FindAll.class) rs = findAll((FindAll) comm);
            returnInformation(rs);
        } while (true);
    }

    @Override
    public Command retrieveCommand() {
        var str = ui.read();
        return parser.parseCommand(str);
    }

    private ResultSet find(Find command) {
        return db.find(command.getParam());
    }

    private ResultSet findAll(FindAll command) {
        return db.findAll();
    }

    @Override
    public void returnInformation(ResultSet rs) {
        ui.show(rs);
    }

    @Override
    public void exit(Exit command) {
        command.doExit();
    }
}