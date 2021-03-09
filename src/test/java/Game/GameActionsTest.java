package Game;

import Hero.Hero;
import TreasureMap.Boxes.Treasure;
import TreasureMap.TreasureMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameActionsTest {

    private GameActions gameActions = new GameActions();
    private static Hero testHero;
    @Mock Game game;

    @BeforeAll
    static void setup(){
        Queue<Character> testQueue= new LinkedList<>();

        testQueue.add('A');
        testQueue.add('A');
        testQueue.add('D');
        testHero = new Hero("TestHero", new Point(0,0),'S', testQueue,0,"AAD");

        Game game = new Game();
    }

    @Test
    void twoCharToString_should_return_two_char_parameter_concatenate_in_String(){
        Character charA = 'A';
        Character charB = 'B';
        String expectedResult = "AB";

        assertEquals(expectedResult, gameActions.twoCharToString(charA, charB));
    }

    @Test
    void collectTreasure_should_take_one_treasure_from_treasure_and_give_it_to_hero(){
        Treasure treasureBoxTest = new Treasure(3);
        gameActions.collectTreasure(testHero, treasureBoxTest);

        assertEquals(2, treasureBoxTest.getNbTreasures());
        assertEquals(1, testHero.getNbTreasures());
    }

}
