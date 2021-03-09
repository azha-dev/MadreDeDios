package TreasureMap;
import TreasureMap.Boxes.Mountain;

import TreasureMap.Boxes.Treasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import TreasureMap.Boxes.Box;
import TreasureMap.Boxes.Plain;

import java.awt.*;

public class TreasureMapTest {


    private int testWidth;
    private int testHeight;
    private Box[][] testBoxes;

    @BeforeEach
    public void setUp(){
        testWidth = 5;
        testHeight = 7;
        testBoxes = new Box[testHeight][testWidth];

        for(int i = 0; i < testHeight; i++) {
            for (int j = 0; j < testWidth; j++) {
                testBoxes[i][j] = new Plain();
            }
        }
    }


    @Test
    public void initArrayOfPlainBoxes_should_return_Plain_array_with_good_lengths(){
        Box[][] expectedResult = this.testBoxes;
        assertArrayEquals(expectedResult, TreasureMap.initArrayOfPlainBoxes(this.testWidth, this.testHeight));
    }

    @Test
    public void addMountain_should_add_mountain_to_given_coordinates(){
        int mountainX = 6;
        int mountainY = 4;
        Point testPoint = new Point(mountainX, mountainY);

        Box [][] expectedResult = testBoxes;

        expectedResult[mountainX][mountainY] = new Mountain();

        TreasureMap testTreasureMap = new TreasureMap(testWidth, testHeight);
        testTreasureMap.addMountain(testPoint);

        assertArrayEquals(expectedResult, testTreasureMap.getBoxes());
    }

    @Test
    public void addTreasure_should_add_treasure_to_given_coordinates_with_same_nbTreasure(){
        int treasureX = 3;
        int treasureY = 3;
        Point testPoint = new Point(treasureX, treasureY);
        int nbTreasure = 8;

        Box [][] expectedResult = testBoxes;

        expectedResult[treasureX][treasureY] = new Treasure(nbTreasure);

        TreasureMap testTreasureMap = new TreasureMap(testWidth, testHeight);
        testTreasureMap.addTreasure(testPoint, nbTreasure);

        assertArrayEquals(expectedResult, testTreasureMap.getBoxes());
    }

}
