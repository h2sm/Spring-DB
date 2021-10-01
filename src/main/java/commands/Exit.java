package commands;

import database.DBInterface;
import models.Model;

public class Exit extends Command {


    public Exit(DBInterface db) {
        super(db);
    }

    @Override
    public boolean checkCommand(String s) {
        return s.toLowerCase().contains("exit");
    }

    @Override
    public Model doCommand() {
        System.exit(0);
        return null;
    }
}
