package console;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import models.Model;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class ConsoleUI implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    @Override
    public String read() {
        System.out.println(">");
        return scanner.nextLine();
    }

    @SneakyThrows
    @Override
    public void show(Model model) {
        model.showEverything().forEach((k, v)-> System.out.println(k + " -- " + v));
    }

    @Override
    public void show(String s) {
        writer.println(s);
        writer.flush();
    }
}


