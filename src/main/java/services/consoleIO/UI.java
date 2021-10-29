package services.consoleIO;

import java.util.Collection;

public interface UI {
    void show(String s);
    void printCollection(Collection<?> col);
}
