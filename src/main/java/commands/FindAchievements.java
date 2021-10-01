package commands;

import database.DBInterface;
import models.FindAchievementsModel;
import models.Model;

import java.util.TreeMap;

public class FindAchievements extends Command {

    public FindAchievements(DBInterface db) {
        super(db);
    }

    @Override
    public boolean checkCommand(String s) {
        return s.toLowerCase().contains("find");
    }

    @Override
    public Model doCommand() {
        super.geDatabaseService().find("achievements");
        return new FindAchievementsModel(new TreeMap<>());
    }
}
