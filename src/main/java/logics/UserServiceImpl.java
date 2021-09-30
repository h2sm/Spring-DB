package logics;

import commands.*;
import commands.parsing.Parser;
import console.UI;
import database.DBInterface;
import localization.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UI ui;
    private final DBInterface db;
    private final Parser parser;
    private final MessageService ms;

    @Override
    public void start() {
        ui.show("ru/en/jp??????");
        ms.askForLocale();
        do {
            ResultSet rs = null;
            var comm = retrieveCommand();
            if (comm.getClass() == Exit.class) exit((Exit) comm);
            if (comm.getClass() == Find.class) rs = find((Find) comm);
            if (comm.getClass() == FindAll.class) rs = findAll((FindAll) comm);
            returnInformation(rs);
        } while (true);
    }

    public String returnString() {
        return ui.read();
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