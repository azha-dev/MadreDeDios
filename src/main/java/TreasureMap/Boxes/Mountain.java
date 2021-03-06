package TreasureMap.Boxes;

public class Mountain implements Box {

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        Mountain other = (Mountain) obj;

        return other.isPassable() == this.isPassable();
    }
}
