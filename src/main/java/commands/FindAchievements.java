package commands;

import database.DBInterface;
import models.Model;

public class FindAchievements extends Command {

    public FindAchievements(DBInterface db) {
        super(db);
    }

    @Override
    public boolean checkCommand(String s) {
        return s.equalsIgnoreCase("find");
    }

    @Override
    public Model doCommand() {
        return super.geDatabaseService().find("achievements");
    }
}
