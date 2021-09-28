package console;

import java.sql.ResultSet;

public interface UI {
    String read();
    void show(ResultSet rs);
    void show(String s);
}
