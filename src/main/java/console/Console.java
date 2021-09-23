package console;

import java.io.PrintWriter;
import java.util.Scanner;

public class Console implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    @Override
    public String read() {
        System.out.println(">");
        return scanner.nextLine();
    }

    @Override
    public void show(String msg) {
        writer.println(msg);
    }
}
