package TreasureMap;

import Log.SimpleLog;
import TreasureMap.Boxes.Box;
import TreasureMap.Boxes.Mountain;
import TreasureMap.Boxes.Plain;
import TreasureMap.Boxes.Treasure;

import java.awt.*;
import java.util.Arrays;

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
        Box[][] arrayOfPlainBoxes = new Box[height][width];

        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                arrayOfPlainBoxes[i][j] = new Plain();
            }
        }

        return arrayOfPlainBoxes;
    }

    public void addMountain(Point coordinates) {
        int x = coordinates.x;
        int y = coordinates.y;

        if (x < 0 || y < 0 || x > height || y > width) {
            SimpleLog.logMessage("Mountain \"M - " + x + " - "+ y +"\" is out of the map\n");
        } else {
            this.boxes[x][y] = new Mountain();
        }
    }
    public void addTreasure(Point coordinates, int  nbTreasure) {
        int x = coordinates.x;
        int y = coordinates.y;

        if (x < 0 || y < 0 || x > height || y > width) {
            SimpleLog.logMessage("Treasure \"T - " + x + " - " + y + "\" is out of the map\n");
        } else {
            this.boxes[x][y] = new Treasure(nbTreasure);
        }
    }

    public Box getBoxAtCoordinate(Point point){
        if (point.x >= 0 && point.y >= 0 && point.x < this.height && point.y < this.width) {
            return this.boxes[point.x][point.y];
        }
        return null;
    }

    public Box[][] getBoxes() {
        return boxes;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        TreasureMap other = (TreasureMap) obj;

        return other.getWidth() == this.width && other.getHeight() == this.height && Arrays.deepEquals(other.getBoxes(), this.boxes);
    }
}
