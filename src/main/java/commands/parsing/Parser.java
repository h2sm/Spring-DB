package commands.parsing;

import commands.Command;

public interface Parser {
    Command parseCommand(String str);
}
