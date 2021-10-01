package services.parser;

import services.commands.Command;

public interface Parser {
    Command parseCommand(String str);
}
