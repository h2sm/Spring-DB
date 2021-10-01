package commands;

import database.DBInterface;
import lombok.RequiredArgsConstructor;
import models.Model;

@RequiredArgsConstructor
public abstract class Command {
    private final DBInterface db;

    public abstract boolean checkCommand(String s);

    public abstract Model doCommand();

    protected DBInterface geDatabaseService() {
        return db;
    }
}