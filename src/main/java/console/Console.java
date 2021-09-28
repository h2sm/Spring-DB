package console;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;
@Slf4j
public class Console implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    @Override
    public String read() {
        log.info("read method called");
        System.out.println(">");
        return scanner.nextLine();
    }

    @SneakyThrows
    @Override
    public void show(ResultSet rs) {
        log.info("Show method called");
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
}
