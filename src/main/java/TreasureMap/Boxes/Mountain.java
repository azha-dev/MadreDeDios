package TreasureMap.Boxes;

import Log.SimpleLog;

public class Mountain implements Box {

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Mountain other = (Mountain) obj;

        return other.isPassable() == this.isPassable();
    }

    @Override
    public String printBox() {
        return "M";
    }
}
