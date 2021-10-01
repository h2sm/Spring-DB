package services.consoleIO;

import models.Model;

public interface UI {
    String read();
    void show(Model model);
    void show(String s);
}
