package Command;


import Game.Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MapCommandTest {
    @Mock Game game;

    @Test
    public void execCommand_should_execute_initGameMap_function(){
        String testXCoordinate = "4";
        String testYCoordinate = "3";
        int intTestXCoordinate = 4;
        int intTestYCoordinate = 3;

        MapCommand testMapCommand = new MapCommand(testXCoordinate, testYCoordinate);

        testMapCommand.execCommand(game);

        verify(game, times(1)).initGameMap(intTestXCoordinate, intTestYCoordinate);
    }

}
