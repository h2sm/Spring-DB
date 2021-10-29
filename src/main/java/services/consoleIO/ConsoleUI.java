package services.consoleIO;

import crossFunctionality.localization.MessageService;
import crossFunctionality.logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class ConsoleUI implements UI {
    private final PrintWriter writer = new PrintWriter(System.out);
    private final MessageService ms;


    @Override
    @Loggable
    public void show(String s) {
        writer.println(s);
        writer.flush();
    }

    @Override
    public void printCollection(Collection<?> col) {

    }
}


