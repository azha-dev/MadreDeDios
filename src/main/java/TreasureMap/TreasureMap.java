package TreasureMap;

import Log.SimpleLog;
import TreasureMap.Boxes.Box;
import TreasureMap.Boxes.Mountain;
import TreasureMap.Boxes.Plain;
import TreasureMap.Boxes.Treasure;

import java.awt.*;

public class TreasureMap {
    private Box[][] boxes;
    private int width;
    private int height;

    public TreasureMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.boxes = initArrayOfPlainBoxes(width, height);
    }

    public static Box[][] initArrayOfPlainBoxes(int width, int height){
        Box[][] arrayOfPlainBoxes = new Box[width][height];

        for(int i = 0; i<arrayOfPlainBoxes.length; i++){
            for(int j = 0; j<arrayOfPlainBoxes[0].length; j++){
                arrayOfPlainBoxes[i][j] = new Plain();
            }
        }

        return arrayOfPlainBoxes;
    }

    public void addMountain(Point coordinates) {
        int x = coordinates.x;
        int y = coordinates.y;

        if (x < 0 || y < 0 || x > width || y > height) {
            SimpleLog.logMessage("Mountain \"M - " + x + " - "+ y +"\" is out of the map");
        } else {
            this.boxes[x][y] = new Mountain();
        }
    }
    public void addTreasure(Point coordinates, int  nbTreasure) {
        int x = coordinates.x;
        int y = coordinates.y;

        if (x < 0 || y < 0 || x > width || y > height) {
            SimpleLog.logMessage("Treasure \"T - " + x + " - " + y + "\" is out of the map");
        } else {
            this.boxes[x][y] = new Treasure(nbTreasure);
        }
    }

    public Box[][] getBoxes() {
        return boxes;
    }
}
