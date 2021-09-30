package console;

import aspects.logging.Loggable;
import localization.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class Console implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    @Override
    @Loggable
    public String read() {
        //log.info(ms.localize("logging.readMethodUiInitiated"));
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
