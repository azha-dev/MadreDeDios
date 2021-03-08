package Command;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CommandCreatorTest {

    CommandCreator commandCreator = new CommandCreator();

    @Test
    public void getCommandFromString_should_return_a_MapCommand_if_first_char_is_C(){
        String inputCommand = "C - 3 - 7";
        Command expectedCommand = new MapCommand("3", "7");

        assertEquals(expectedCommand, CommandCreator.getCommandFromString(inputCommand));
    }

    @Test
    public void getCommandFromString_should_return_a_MountainCommand_if_first_char_is_M(){
        String inputCommand = "M - 7 - 2";
        Command expectedCommand = new MountainCommand("7", "2");

        assertEquals(expectedCommand, CommandCreator.getCommandFromString(inputCommand));
    }

    @Test
    public void getCommandFromString_should_return_a_TreasureCommand_if_first_char_is_T(){
        String inputCommand = "T - 4 - 4 - 2";
        Command expectedCommand = new TreasureCommand("4", "4", "2");
        assertEquals(expectedCommand, CommandCreator.getCommandFromString(inputCommand));
    }
    @Test
    public void getCommandFromString_should_return_a_HeroCommand_if_first_char_is_A(){
        String inputCommand = "A - TestHero - 4 - 7 - N - AAGDA";
        Command expectedCommand = new HeroCommand("4", "7", "TestHero", "AAGDA", "N" );
        Command testResult = CommandCreator.getCommandFromString(inputCommand);
        assertEquals(expectedCommand, CommandCreator.getCommandFromString(inputCommand));
    }

    @Test
    public void arrayLisStringToArrayListCommand_should_return_ArrayList_of_commands_with_correct_data(){
        ArrayList<String> inputLines = new ArrayList<>();
        inputLines.add("C - 2 - 9");
        inputLines.add("M - 1 - 2");
        inputLines.add("T - 4 - 4 - 2");
        inputLines.add("A - TestHero - 4 - 7 - N - AAGDA");

        ArrayList<Command> expectedResult = new ArrayList<Command>();
        expectedResult.add(new MapCommand("2", "9"));
        expectedResult.add( new MountainCommand("1", "2"));
        expectedResult.add(new TreasureCommand("4", "4", "2"));
        expectedResult.add(new HeroCommand("4", "7", "TestHero", "AAGDA", "N" ));

        assertEquals(expectedResult, commandCreator.arrayLisStringToArrayListCommand(inputLines));
    }
}
