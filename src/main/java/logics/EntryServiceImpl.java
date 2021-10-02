package logics;

import crossFunctionality.localization.MessageService;
import crossFunctionality.logging.Loggable;
import services.parser.Parser;
import services.consoleIO.UI;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService {
    private final UI ui;
    private final Parser parser;
    private final MessageService ms;

    @Override
    @Loggable
    public void start() {
        setLocale();
        while (true) {
            var c = parser.parseCommand(ui.read());
            var model = c.doCommand();
            ui.show(model);
        }
    }

    private void setLocale() {
        ui.show("Select locale: ru/en/jp");
        ms.askForLocale(ui.read());
    }
}