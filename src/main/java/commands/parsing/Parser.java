package commands.parsing;

import commands.Command;

public interface Parser {
    Command parse(String str);
}
