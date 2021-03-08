package Hero;

import java.awt.*;
import java.util.Queue;

public class Hero {
    private String name;
    private Point coordinates;
    private Character orientation;
    private Queue<Character> movement;

    public Hero(String name, Point coordinates, Character orientation, Queue<Character> movement) {
        this.name = name;
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.movement = movement;
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
}
