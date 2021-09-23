package logics;

import commands.Command;
import commands.Exit;
import commands.Find;
import commands.FindAll;
import configuration.AuthProperties;
import console.UI;
import database.DBInterface;

public class UserServiceImpl implements UserService {
    private final UI ui;
    private final DBInterface db;
    private final AuthProperties ap;

    public UserServiceImpl(UI ui, DBInterface dbInterface, AuthProperties properties) {
        this.ui=ui;
        this.db=dbInterface;
        this.ap = properties;
    }

    @Override
    public void start() {
        var comm = retrieveCommand();
        handleCommand(comm);
    }

    @Override
    public Command retrieveCommand() {
        var str = ui.read();
        if (str.equalsIgnoreCase("find-all")) return new FindAll();
        if (str.equalsIgnoreCase("exit")) return new Exit();
        else {
            str = str.substring("find ".length());
            return new Find(str);
        }
    }

    @Override
    public void handleCommand(Command command){
        if (command.getClass() == Exit.class) exit((Exit) command);
        if (command.getClass() == Find.class) findData((Find) command);
        if (command.getClass() == FindAll.class) findAll((FindAll) command);
    }

    private void findData(Find command){
        System.out.println(command.getClass() + " " + command.getParam());
        //db.find(command.getParam());
    }

    private void findAll (FindAll command){
        System.out.println(command.getClass().getSimpleName());
        //db.findAll();
    }


    @Override
    public void returnInformation() {

    }

    @Override
    public void exit(Exit command) {
        command.doExit();
    }
}
