package services.commands;

import crossFunctionality.logging.Loggable;
import services.database.DBInterface;
import models.Model;

public class FindAchievements extends Command {

    public FindAchievements(DBInterface db) {
        super(db);
    }

    @Override
    @Loggable
    public boolean checkCommand(String s) {
        return s.equalsIgnoreCase("find");
    }

    @Override
    @Loggable
    public Model doCommand() {
        return super.geDatabaseService().find("achievements");
    }
}
