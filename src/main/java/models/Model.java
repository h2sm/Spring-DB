package models;

import java.util.TreeMap;

public interface Model {
    String findById(int id);
    TreeMap showEverything();
}
