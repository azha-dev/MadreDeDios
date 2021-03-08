package Command;

import Game.Game;

import java.awt.*;

import static java.lang.Integer.parseInt;

public abstract class Command {
    protected String xCoordinate;
    protected String yCoordinate;

    public Command(String xCoordinate, String yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Point stringsToPoint(String xCoordinate, String yCoordinate){
        return new Point(parseInt(xCoordinate), parseInt(yCoordinate));
    }

    public String getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(String xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public String getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(String yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public abstract void execCommand(Game game);

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        Command other = (Command) obj;

        return other.getxCoordinate().equals(this.xCoordinate) &&
                other.getyCoordinate().equals(this.yCoordinate);
    }
}
