package commands;

import database.DBInterface;
import models.Model;

public class FindAll extends Command {

    public FindAll(DBInterface db) {
        super(db);
    }

    @Override
    public boolean checkCommand(String s) {
        return s.toLowerCase().contains("find-all");
    }

    @Override
    public Model doCommand() {
        return super.geDatabaseService().findAll();
    }
}
