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

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        Treasure other = (Treasure) obj;

        return other.isPassable() == this.isPassable() && other.getNbTreasures() == this.getNbTreasures();
    }
}
