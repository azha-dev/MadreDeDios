package Command;

import Game.Game;
import TreasureMap.Boxes.Mountain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MountainCommandTest {
    @Mock Game game;

    @Test
    public void execCommand_should_execute_addMountainToGame_function(){
        String testXCoordinate = "7";
        String testYCoordinate = "2";
        int intTestXCoordinate = 7;
        int intTestYCoordinate = 2;
        Point testCoordinates = new Point(intTestXCoordinate, intTestYCoordinate);

        MountainCommand testMountainCommand = new MountainCommand(testXCoordinate, testYCoordinate);

        testMountainCommand.execCommand(game);

        verify(game, times(1)).addMountainToGame(testCoordinates);
    }
}
