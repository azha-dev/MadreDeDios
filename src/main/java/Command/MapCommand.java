package Command;

import Game.Game;

import static java.lang.Integer.parseInt;

public class MapCommand extends Command{


    public MapCommand(String yCoordinate, String xCoordinate) {
        super(xCoordinate, yCoordinate);
    }

    @Override
    public void execCommand(Game game) {
        game.initGameMap(parseInt(yCoordinate), parseInt(xCoordinate));
    }

}
