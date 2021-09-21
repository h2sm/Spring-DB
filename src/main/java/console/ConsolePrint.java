package console;

import java.io.PrintWriter;
import java.util.Scanner;

public class ConsolePrint {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    public String read() {
        System.out.println(">");
        return scanner.nextLine();
    }
    public void write(String line) {
        writer.println(line);
    }
}
