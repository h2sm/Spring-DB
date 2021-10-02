package logics;

import crossFunctionality.logging.Loggable;
import services.parser.Parser;
import services.consoleIO.UI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UI ui;
    private final Parser parser;

    @Override
    @Loggable
    public void start() {
        while (true) {
            ui.show("ru/en/jp?????? Enter your command");
            var c = parser.parseCommand(ui.read());
            var model = c.doCommand();
            ui.show(model);
        }
    }
}