package logics;

import console.ConsolePrint;
import database.DBInterface;

public class UserServiceImpl implements UserService {
    private final ConsolePrint cp;
    private final DBInterface db;

    public UserServiceImpl(ConsolePrint cp, DBInterface dbInterface) {
        this.cp=cp;
        this.db=dbInterface;
    }

    @Override
    public void setup() {

    }

    @Override
    public void retrieveCommand() {
        cp.read();
    }

    @Override
    public void returnInformation() {

    }

    @Override
    public void exit() {

    }
}
