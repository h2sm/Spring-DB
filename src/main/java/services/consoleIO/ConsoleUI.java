package services.consoleIO;

import logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import services.localization.MessageService;

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
        col.forEach(System.out::println);
    }

    public void changeLocale(String loc){
        ms.askForLocale(loc);
    }
    public void localize(String code){
        show(ms.localize(code));
    }
}


