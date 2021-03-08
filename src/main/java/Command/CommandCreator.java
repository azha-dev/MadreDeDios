package Command;

import java.util.ArrayList;


public class CommandCreator {

    public ArrayList<Command> arrayLisStringToArrayListCommand(ArrayList<String> commandLines){
        ArrayList<Command> commandsObject = new ArrayList<Command>();

        for (String commandLine: commandLines) {
            commandsObject.add(getCommandFromString(commandLine));
        }

        return commandsObject;
    }

    public static Command getCommandFromString(String commandLine){
        String[] commandLineArray = commandLine.split(" - ");
        String commandType = commandLineArray[0];

        switch (commandType) {
            case "C":
                return new MapCommand(commandLineArray[1], commandLineArray[2]);
            case "M":
                return new MountainCommand(commandLineArray[1], commandLineArray[2]);
            case "T":
                return new TreasureCommand(commandLineArray[1], commandLineArray[2], commandLineArray[3]);
            case "A":
                return new HeroCommand(commandLineArray[2], commandLineArray[3], commandLineArray[1], commandLineArray[5], commandLineArray[4]);
        }
        return null;
    }
}
