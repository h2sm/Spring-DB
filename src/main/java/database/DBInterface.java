package database;

import java.sql.ResultSet;

public interface DBInterface {
   ResultSet findAll();
   ResultSet find(String str);
}
