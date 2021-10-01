package services.database;

import models.Model;

public interface DBInterface {
   Model findAll();
   Model find(String str);
}
