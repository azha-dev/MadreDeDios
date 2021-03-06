package TreasureMap;
import TreasureMap.Boxes.Mountain;

import TreasureMap.Boxes.Treasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import TreasureMap.Boxes.Box;
import TreasureMap.Boxes.Plain;

public class TreasureMapTest {


    private int testWidth;
    private int testHeight;
    private Box[][] testBoxes;

    @BeforeEach
    public void setUp(){
        testWidth = 5;
        testHeight = 7;
        testBoxes = new Box[testWidth][testHeight];

        for(int i = 0; i < testWidth; i++) {
            for (int j = 0; j < testHeight; j++) {
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
        int mountainX = 4;
        int mountainY = 6;

        Box [][] expectedResult = testBoxes;

        expectedResult[mountainX][mountainY] = new Mountain();

        TreasureMap testTreasureMap = new TreasureMap(testWidth, testHeight);
        testTreasureMap.addMountain(mountainX, mountainY);

        assertArrayEquals(expectedResult, testTreasureMap.getBoxes());
    }

    @Test
    public void addTreasure_should_add_treasure_to_given_coordinates_with_same_nbTreasure(){
        int treasureX = 3;
        int treasureY = 3;
        int nbTreasure = 8;

        Box [][] expectedResult = testBoxes;

        expectedResult[treasureX][treasureY] = new Treasure(nbTreasure);

        TreasureMap testTreasureMap = new TreasureMap(testWidth, testHeight);
        testTreasureMap.addTreasure(treasureX, treasureY, nbTreasure);

        assertArrayEquals(expectedResult, testTreasureMap.getBoxes());
    }

}
