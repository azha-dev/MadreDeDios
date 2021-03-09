package Command;

import Game.Game;
import Hero.Hero;

import java.util.LinkedList;
import java.util.Queue;

public class HeroCommand extends Command {

    private String name;
    private String moves;
    private String orientation;

    public HeroCommand(String xCoordinate, String yCoordinate,  String name, String moves, String  orientation) {
        super(xCoordinate, yCoordinate);
        this.name = name;
        this.moves = moves;
        this.orientation = orientation;
    }



    @Override
    public void execCommand(Game game) {
        game.addHeroToGame(new Hero(this.name,stringsToPoint(this.xCoordinate, this.yCoordinate),this.orientation.charAt(0),stringToQueue(this.moves), 0, this.moves));
    }

    private Queue<Character> stringToQueue(String string){
        Queue<Character> charsQueue = new LinkedList<>();
        for (char c : string.toCharArray()) {
            charsQueue.offer(c);
        }
        return charsQueue;
    }

    public String getName() {
        return name;
    }

    public String getMoves() {
        return moves;
    }

    public String getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        HeroCommand other = (HeroCommand) obj;

        return other.getxCoordinate().equals(this.xCoordinate) &&
                other.getyCoordinate().equals(this.yCoordinate) &&
                other.getName().equals(this.name) &&
                other.getOrientation().equals(this.orientation) &&
                other.getMoves().equals(this.moves);
    }


}
