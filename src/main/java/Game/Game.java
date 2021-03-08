package Game;

import Hero.Hero;
import Log.SimpleLog;
import TreasureMap.TreasureMap;

import java.awt.*;
import java.util.ArrayList;

public class Game {
    TreasureMap treasureMap;
    ArrayList<Hero> heroes;

    public void initGame(ArrayList<String> commands){

    }

    public void initGameMap(int width, int height){
        if(this.treasureMap == null) {
            this.treasureMap = new TreasureMap(width, height);
        } else {
            SimpleLog.logMessage("Map already been initialized, this one : C - \"" + width + " - " + height + "\" was ignored");
        }
    }

    public void addMountainToGame(Point coordinates){
        this.treasureMap.addMountain(coordinates);
    }

    public void addTreasureToGame(Point coordinates, int nbTreasure) {
        this.treasureMap.addTreasure(coordinates, nbTreasure);
    }

    public void addHeroToGame(Hero hero){
        this.heroes.add(hero);
    }
}
