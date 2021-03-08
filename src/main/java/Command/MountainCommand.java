package Command;

import Game.Game;

public class MountainCommand extends Command {


    public MountainCommand(String xCoordinate, String yCoordinate) {
        super(xCoordinate, yCoordinate);
    }

    @Override
    public void execCommand(Game game) {
        game.addMountainToGame(stringsToPoint(xCoordinate, yCoordinate));
    }
}
