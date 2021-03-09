package TreasureMap.Boxes;

public interface Box {

     default boolean isPassable(){
          return true;
     }

     String printBox();
}
