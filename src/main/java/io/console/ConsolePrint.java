package io.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
