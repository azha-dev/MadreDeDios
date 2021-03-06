package TreasureMap.Boxes;

public class Treasure implements Box {
    private int nbTreasures;

    public Treasure(int nbTreasures){
        this.nbTreasures = nbTreasures;
    }

    public int getNbTreasures() {
        return nbTreasures;
    }

    public void setNbTreasures(int nbTreasures) {
        this.nbTreasures = nbTreasures;
    }
}
