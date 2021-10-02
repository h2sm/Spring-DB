package services.consoleIO;

import crossFunctionality.localization.MessageService;
import crossFunctionality.logging.Loggable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import models.Model;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@RequiredArgsConstructor
public class ConsoleUI implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);
    private final MessageService ms;

    @Override
    @Loggable
    public String read() {
        System.out.println(">");
        return scanner.nextLine();
    }

    @SneakyThrows
    @Override
    @Loggable
    public void show(Model model) {
        show(ms.localize("crossFunctionality." + model.getClass().getSimpleName()));
        model.showEverything().forEach((k, v) -> {
            show(ms.localize("crossFunctionality.writeAll", k, v));
            show(ms.localize("crossFunctionality.addEmptySpace"));
        });
    }

    @Override
    @Loggable
    public void show(String s) {
        writer.println(s);
        writer.flush();
    }
}


