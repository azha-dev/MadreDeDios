package Command;

import Game.Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TreasureCommandTest {
    @Mock
    Game game;

    @Test
    public void execCommand_should_execute_addTreasureToGame_function(){
        String testXCoordinate = "7";
        String testYCoordinate = "2";
        String testNbTreasure = "2";
        
        int intTestXCoordinate = 7;
        int intTestYCoordinate = 2;
        Point testCoordinates = new Point(intTestXCoordinate, intTestYCoordinate);

        int intTestNbTreasure = 2;


        TreasureCommand testTreasureCommand = new TreasureCommand(testXCoordinate, testYCoordinate, testNbTreasure);

        testTreasureCommand.execCommand(game);

        verify(game, times(1)).addTreasureToGame(testCoordinates, intTestNbTreasure);
    }
}
