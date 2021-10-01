package logics;

import logging.Loggable;
import commands.*;
import parse.Parser;
import console.UI;
import database.DBInterface;
import localization.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UI ui;
    private final DBInterface db;
    private final Parser parser;
    private final MessageService ms;

    @Override
    @Loggable
    public void start() {
        ui.show("ru/en/jp??????");
        ms.askForLocale();
        var c = parser.parseCommand(ui.read());
        System.out.println(c.getClass().getSimpleName());
        c.doCommand();

    }

    @Override
    public Command retrieveCommand() {
        return null;
    }

    @Override
    public void returnInformation(ResultSet rs) {

    }

    @Override
    public void exit(Exit command) {

    }


}