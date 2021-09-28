package commands;

public class Exit extends Command {
    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
    public void doExit(){
        System.exit(0);
    }
}
