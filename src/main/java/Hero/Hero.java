package Hero;

import java.awt.*;
import java.util.Queue;

public class Hero {
    private String name;
    private Point coordinates;
    private Character orientation;
    private Queue<Character> movement;
    private int nbTreasures;

    public Hero(String name, Point coordinates, Character orientation, Queue<Character> movement, int nbTreasures) {
        this.name = name;
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.movement = movement;
        this.nbTreasures = nbTreasures;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public Character getOrientation() {
        return orientation;
    }

    public void setOrientation(Character orientation) {
        this.orientation = orientation;
    }

    public Queue<Character> getMovement() {
        return movement;
    }

    public void setMovement(Queue<Character> movement) {
        this.movement = movement;
    }

    public int getNbTreasures() {
        return nbTreasures;
    }

    public void setNbTreasures(int nbTreasures) {
        this.nbTreasures = nbTreasures;
    }

    public String printHero(){
        return "A("+name+")";
    }

    public String printOutputFormat(){
        return "A - "+this.name+" - "+this.coordinates.x+" - "+this.coordinates.y+" - "+this.orientation+" - "+this.nbTreasures;
    }
}
