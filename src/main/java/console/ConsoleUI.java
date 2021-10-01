package console;

import logging.Loggable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class ConsoleUI implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    @Override
    @Loggable
    public String read() {
        System.out.println(">");
        return scanner.nextLine();
    }

    @SneakyThrows
    @Override
    @Loggable
    public void show(ResultSet rs) {
        if (rs != null) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + " - " + columnValue);
                }
                System.out.println("");
            }
            rs.close();
        }
    }
    @Override
    @Loggable
    public void show(String s) {
        writer.print(s);
        writer.flush();
    }
}
