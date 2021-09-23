package commands;

public class FindAll extends Command {
    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
}
