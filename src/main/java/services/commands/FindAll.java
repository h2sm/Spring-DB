package services.commands;

import crossFunctionality.logging.Loggable;
import services.database.DBInterface;
import models.Model;

public class FindAll extends Command {

    public FindAll(DBInterface db) {
        super(db);
    }

    @Override
    @Loggable
    public boolean checkCommand(String s) {
        return s.toLowerCase().contains("find-all");
    }

    @Override
    @Loggable
    public Model doCommand() {
        return super.geDatabaseService().findAll();
    }
}
