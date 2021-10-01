package logics;

import logging.Loggable;
import parser.Parser;
import console.UI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UI ui;
    private final Parser parser;
    //private final MessageService ms;

    @Override
    @Loggable
    public void start() {
        ui.show("ru/en/jp?????? Enter your command");
//        ms.askForLocale();
        var c = parser.parseCommand(ui.read());
        var model = c.doCommand();
    }
}