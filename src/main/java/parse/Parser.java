package parse;

import commands.Command;

public interface Parser {
    Command parseCommand(String str);
}
