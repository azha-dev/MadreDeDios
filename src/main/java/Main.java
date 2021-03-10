import FileFormatter.EntryFileFormatter;
import FileFormatter.OutputFileFormatter;
import Game.Game;
import Log.SimpleLog;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        if(args.length < 2){
            SimpleLog.logMessage("One argument is missing");
        } else {
            ArrayList<String> commandsLine = EntryFileFormatter.fileToStringArrayListByLines(args[0]);

            if(EntryFileFormatter.validateAllLines(commandsLine)) {
                Game game = new Game();

                game.initGame(commandsLine);
                game.startGame();
                OutputFileFormatter.writeArrayListStringInFile(args[1], game.gameToOutputArrayList());
            }
        }

    }
}