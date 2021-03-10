package Game;

import Hero.Hero;
import TreasureMap.TreasureMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class GameTest {
    Game game = new Game();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void atLeastOneHeroHasMoves_should_return_true_if_one_hero_have_a_move(){
        Queue<Character> testQueue= new LinkedList<>();

        testQueue.add('A');
        testQueue.add('A');
        testQueue.add('D');
        Hero firstTestHero = new Hero("TestHero", new Point(0,0),'S', testQueue,0);
        Hero secondTestHero = new Hero("TestHero", new Point(0,0),'S', new LinkedList<>(),0);


        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(firstTestHero);
        heroes.add(secondTestHero);

        assertTrue(game.atLeastOneHeroHasMoves(heroes));
    }

    @Test
    void atLeastOneHeroHasMoves_should_return_false_if_no_hero_have_a_move(){
        Hero firstTestHero = new Hero("TestHero", new Point(0,0),'S', new LinkedList<>(),0);
        Hero secondTestHero = new Hero("TestHero", new Point(0,0),'S', new LinkedList<>(),0);


        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(firstTestHero);
        heroes.add(secondTestHero);

        assertFalse(game.atLeastOneHeroHasMoves(heroes));
    }

    @Test
    void isOneHeroOnBox_should_return_true_if_one_hero_is_on_coordinates(){
        Hero firstTestHero = new Hero("TestHero", new Point(0,0),'S', new LinkedList<>(),0);

        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(firstTestHero);
        game.setHeroes(heroes);

        assertTrue(game.isOneHeroOnBox(new Point(0,0)));

    }

    @Test
    void isOneHeroOnBox_should_return_false_if_no_hero_is_on_coordinates(){
        Hero firstTestHero = new Hero("TestHero", new Point(0,0),'S', new LinkedList<>(),0);

        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(firstTestHero);
        game.setHeroes(heroes);

        assertFalse(game.isOneHeroOnBox(new Point(1,0)));

    }
    
    @Test
    void getHeroOnCoordinate_should_return_Optional_with_hero_if_hero_on_coordinates(){
        Hero expectedHero = new Hero("TestHero", new Point(0,0),'S', new LinkedList<>(),0);

        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(expectedHero);
        game.setHeroes(heroes);
        assertEquals(expectedHero, game.getHeroOnCoordinate(new Point(0, 0)).get());
    }

    @Test
    void getHeroOnCoordinate_should_return_empty_Optional_hero_if_hero_on_coordinates(){
        ArrayList<Hero> heroes = new ArrayList<>();
        game.setHeroes(heroes);
        assertEquals(Optional.empty(), game.getHeroOnCoordinate(new Point(0, 0)));
    }

    @Test
    void initGameMap_should_create_Game_TreasureMap_with_given_size(){
        TreasureMap expectedTreasureMap = new TreasureMap(4,5);

        game.initGameMap(4,5);

        assertEquals(expectedTreasureMap, game.getTreasureMap());
    }

    @Test
    void initGameMap_should_log_message_if_map_already_created(){
        TreasureMap expectedTreasureMap = new TreasureMap(4,5);

        game.setTreasureMap(expectedTreasureMap);

        game.initGameMap(6, 8);
        assertEquals("Map already been initialized, this one : C - 6 - 8 was ignored", outputStreamCaptor.toString());
    }

}
