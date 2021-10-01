package parse;

import commands.Command;
import lombok.RequiredArgsConstructor;
import models.Model;

import java.util.HashSet;

@RequiredArgsConstructor
public class ParserImpl implements Parser {
    private final HashSet<Command> commands;

    @Override
    public Command parseCommand(String fullCommand) {
       return commands.stream().filter(command -> command.checkCommand(fullCommand)).findFirst().get();
    }

}
