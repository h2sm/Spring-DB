package services.parser;

import crossFunctionality.logging.Loggable;
import services.commands.Command;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;

@RequiredArgsConstructor
public class ParserImpl implements Parser {
    private final HashSet<Command> commands;

    @Override
    @Loggable
    public Command parseCommand(String fullCommand) {
       return commands.stream().filter(command -> command.checkCommand(fullCommand)).findFirst().get();
    }

}
