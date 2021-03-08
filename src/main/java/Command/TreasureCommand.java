package Command;

import Game.Game;

import static java.lang.Integer.parseInt;

public class TreasureCommand extends Command {
    private String nbTreasure;

    public TreasureCommand(String xCoordinate, String yCoordinate, String nbTreasure) {
        super(xCoordinate, yCoordinate);
        this.nbTreasure = nbTreasure;
    }


    @Override
    public void execCommand(Game game) {
        game.addTreasureToGame(stringsToPoint(xCoordinate, yCoordinate), parseInt(nbTreasure));
    }

    public String getNbTreasure() {
        return nbTreasure;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        TreasureCommand other = (TreasureCommand) obj;

        return other.getxCoordinate().equals(this.xCoordinate) &&
                other.getyCoordinate().equals(this.yCoordinate) &&
                other.getNbTreasure().equals(this.nbTreasure);
    }


}
