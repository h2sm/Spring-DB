package console;

import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Console implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out);

    @Override
    public String read() {
        System.out.println(">");
        return scanner.nextLine();
    }

    @SneakyThrows
    @Override
    public void show(ResultSet rs) {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }
}
