import FileFormatter.EntryFileFormatter;
import Game.Game;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> commandsLine = EntryFileFormatter.fileToStringArrayListByLines(args[0]);

        Game game = new Game();

        game.initGame(commandsLine);
        game.startGame();
    }
}