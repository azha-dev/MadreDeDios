package Command;

import Game.Game;

import static java.lang.Integer.parseInt;

public class MapCommand extends Command{


    public MapCommand(String xCoordinate, String yCoordinate) {
        super(xCoordinate, yCoordinate);
    }

    @Override
    public void execCommand(Game game) {
        game.initGameMap(parseInt(xCoordinate), parseInt(yCoordinate));
    }

}
