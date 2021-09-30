package commands.parsing;

import commands.Command;
import commands.Exit;
import commands.Find;
import commands.FindAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParserImplTest {
    private final String[] str = {"exit", "find sheesh", "find-all", "eahrbfahsb"};
    private final Command[] cmdList = {new Exit(), new Find("sheesh"), new FindAll(), new Exit()};

    @Test
    void parseCommand() {
        var parser = new ParserImpl();
        for (int i = 0; i < str.length; i++) {
            assertEquals(cmdList[i].getClass(), parser.parseCommand(str[i]).getClass());
        }
    }
}