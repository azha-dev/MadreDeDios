package Command;

import Game.Game;
import Hero.Hero;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HeroCommandTest {
    @Mock Game game;

    @Test
    public void execCommand_should_execute_addHeroToGame_function(){
        String testXCoordinate = "4";
        String testYCoordinate = "3";
        String testName = "SuperTest";
        String testMoves = "AADG";
        String testOrientation = "N";
        Queue<Character> testQueue= new LinkedList<>();

        testQueue.add('A');
        testQueue.add('A');
        testQueue.add('D');
        testQueue.add('G');

        Point testCoordinates = new Point(4,3);
        Hero expectedHero = new Hero(testName, testCoordinates, 'N', testQueue,0, testMoves);

        HeroCommand testHeroCommand = new HeroCommand(testXCoordinate, testYCoordinate, testName, testMoves, testOrientation);

        testHeroCommand.execCommand(game);

        verify(game, times(1)).addHeroToGame(ArgumentMatchers.refEq(expectedHero));
    }
}
