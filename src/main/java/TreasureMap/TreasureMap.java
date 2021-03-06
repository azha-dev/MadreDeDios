package TreasureMap;

import TreasureMap.Boxes.Box;
import TreasureMap.Boxes.Plain;

public class TreasureMap {
    private Box[][] boxes;
    private int width;
    private int height;

    public TreasureMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.boxes = initArrayOfPlainBoxes(width,height);
    }

    private Box[][] initArrayOfPlainBoxes(int width, int height){
        Box[][] arrayOfPlainBoxes = new Box[width][height];

        for(int i = 0; i<arrayOfPlainBoxes.length; i++){
            for(int j = 0; j<arrayOfPlainBoxes[0].length; j++){
                arrayOfPlainBoxes[i][j] = new Plain();
            }
        }

        return arrayOfPlainBoxes;
    }


}
