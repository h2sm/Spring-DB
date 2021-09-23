package commands.parsing;


import commands.Command;
import commands.Exit;
import commands.Find;
import commands.FindAll;

public class ParserImpl implements Parser {

    @Override
    public Command parse(String fullCommand) {
        var commandLowerCase = fullCommand.split("\\s")[0].toLowerCase();
        if (commandLowerCase.equals("find-all")) return new FindAll();
        if (commandLowerCase.equals("exit")) return new Exit();
        if (fullCommand.toLowerCase().startsWith("find ")) {
            fullCommand = fullCommand.substring("find ".length());
            return new Find(fullCommand);
        }
        else return new Exit();
    }
}
