package TreasureMap.Boxes;

public class Plain implements Box {

    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        Plain other = (Plain) obj;

        return other.isPassable() == this.isPassable();
    }


    @Override
    public String printBox() {
        return ".";
    }
}
