package services.commands;

import crossFunctionality.logging.Loggable;
import services.database.DBInterface;
import lombok.RequiredArgsConstructor;
import models.Model;

@RequiredArgsConstructor
public abstract class Command {
    private final DBInterface db;
    @Loggable
    public abstract boolean checkCommand(String s);
    @Loggable
    public abstract Model doCommand();

    protected DBInterface geDatabaseService() {
        return db;
    }
}