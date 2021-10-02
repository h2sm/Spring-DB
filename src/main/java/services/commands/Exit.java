package services.commands;

import crossFunctionality.logging.Loggable;
import org.springframework.stereotype.Service;
import services.database.DBInterface;
import models.Model;

public class Exit extends Command {
    public Exit(DBInterface db) {
        super(db);
    }

    @Override
    @Loggable
    public boolean checkCommand(String s) {
        return s.toLowerCase().contains("exit");
    }

    @Override
    @Loggable
    public Model doCommand() {
        System.exit(0);
        return null;
    }
}
