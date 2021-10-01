package console;

import models.Model;

import java.sql.ResultSet;

public interface UI {
    String read();
    void show(Model model);
    void show(String s);
}
