package Game;

import Hero.Hero;
import TreasureMap.Boxes.Box;
import TreasureMap.Boxes.Plain;
import TreasureMap.Boxes.Treasure;
import TreasureMap.TreasureMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameActions {
   private final HashMap<String, String> movementsFromOrientation;

    public GameActions() {
        this.movementsFromOrientation = new HashMap<>();
        movementsFromOrientation.put("SA", "down");
        movementsFromOrientation.put("SD", "left");
        movementsFromOrientation.put("SG", "right");
        movementsFromOrientation.put("NA", "up");
        movementsFromOrientation.put("ND", "right");
        movementsFromOrientation.put("NG", "left");
        movementsFromOrientation.put("OA", "left");
        movementsFromOrientation.put("OD", "up");
        movementsFromOrientation.put("OG", "down");
        movementsFromOrientation.put("EA", "right");
        movementsFromOrientation.put("ED", "down");
        movementsFromOrientation.put("EG", "up");
    }

    void oneTurn(ArrayList<Hero> heroes, Game game){
        for (Hero hero: heroes) {
            if (!hero.getMovement().isEmpty()) {
                Point oldCoordinate = new Point();
                oldCoordinate.setLocation(hero.getCoordinates());
                oneMovement(hero, game);

                if (!oldCoordinate.equals(hero.getCoordinates())) {
                    Box currentBox = game.getTreasureMap().getBoxAtCoordinate(hero.getCoordinates());
                    if (currentBox instanceof Treasure) {
                        collectTreasure(hero, (Treasure) currentBox);
                        if(((Treasure) currentBox).getNbTreasures() == 0){
                            currentBox = new Plain();
                        }
                    }
                }
            }
        }
    }

    void oneMovement(Hero hero, Game game){
       String movementWithOrientation = twoCharToString(hero.getOrientation(), hero.getMovement().poll());
        String nextMovement = movementsFromOrientation.get(movementWithOrientation);
       switch (movementsFromOrientation.get(movementWithOrientation)) {
           case "up":
               moveUp(hero, game);
               break;
           case "down":
               moveDown(hero, game);
               break;
           case "left":
               moveLeft(hero, game);
               break;
           case "right":
               moveRight(hero, game);
               break;
       }
    }

    void moveDown(Hero hero, Game game){
        Point heroCoordinate = hero.getCoordinates();
        Point newHeroCoordinate = new Point(heroCoordinate.x+1, heroCoordinate.y);

        if(!(newHeroCoordinate.x+1 > game.getTreasureMap().getHeight())) {
            if(isBoxValid(newHeroCoordinate, game)) {
                heroCoordinate.setLocation(heroCoordinate.x+1, heroCoordinate.y);
            }
        }
    }
    void moveUp(Hero hero, Game game){
        Point heroCoordinate = hero.getCoordinates();
        Point newHeroCoordinate = new Point(heroCoordinate.x-1, heroCoordinate.y);

        if(!(newHeroCoordinate.x < 0)) {
            if(isBoxValid(newHeroCoordinate, game)) {
                heroCoordinate.setLocation(heroCoordinate.x-1, heroCoordinate.y);
            }
        }
    }
    void moveRight(Hero hero, Game game){
        Point heroCoordinate = hero.getCoordinates();
        Point newHeroCoordinate = new Point(heroCoordinate.x, heroCoordinate.y + 1);

        if(!(newHeroCoordinate.y > game.getTreasureMap().getWidth())) {
            if(isBoxValid(newHeroCoordinate, game)) {
                heroCoordinate.setLocation(heroCoordinate.x, heroCoordinate.y + 1);
            }
        }
    }
    void moveLeft(Hero hero, Game game){
        Point heroCoordinate = hero.getCoordinates();
        Point newHeroCoordinate = new Point(heroCoordinate.x, heroCoordinate.y - 1);

        if(!(newHeroCoordinate.y < 0)) {
            if(isBoxValid(newHeroCoordinate, game)) {
                heroCoordinate.setLocation(heroCoordinate.x, heroCoordinate.y - 1);
            }
        }
    }

    String twoCharToString(Character orientation, Character movement){
        return String.valueOf(orientation) + movement;
    }

    boolean isBoxPassable(Point point, TreasureMap treasureMap){
        return treasureMap.getBoxes()[point.x][point.y].isPassable();
    }

    boolean isBoxValid(Point point, Game game){
        if(isBoxInMap(point, game.getTreasureMap())){
            return isBoxPassable(point, game.getTreasureMap()) && !game.isOneHeroOnBox(point);
        }
        return false;
    }

    boolean isBoxInMap(Point point, TreasureMap treasureMap) {
        return point.x > 0 && point.y > 0 && point.x < treasureMap.getHeight() && point.y < treasureMap.getWidth();
    }

    void collectTreasure(Hero hero, Treasure treasureBox){
        if(treasureBox.getNbTreasures()>0){
            hero.setNbTreasures(hero.getNbTreasures()+1);
            treasureBox.setNbTreasures(treasureBox.getNbTreasures()-1);
        }
    }
}
