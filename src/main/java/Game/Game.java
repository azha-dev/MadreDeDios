package Game;

import Command.Command;
import Command.CommandCreator;
import Hero.Hero;
import Log.SimpleLog;
import TreasureMap.Boxes.Box;
import TreasureMap.Boxes.Mountain;
import TreasureMap.Boxes.Plain;
import TreasureMap.Boxes.Treasure;
import TreasureMap.TreasureMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

public class Game {
    TreasureMap treasureMap;
    ArrayList<Hero> heroes;

    public Game() {
        heroes = new ArrayList<Hero>();
    }

    public void initGame(ArrayList<String> commandsLine){
        CommandCreator commandCreator = new CommandCreator();
        ArrayList<Command> commands = commandCreator.arrayLisStringToArrayListCommand(commandsLine);

        for (Command command: commands) {
            command.execCommand(this);
        }
    }

    public void startGame(){
        GameActions gameActions = new GameActions();
        printGame();
        while (atLeastOneHeroHasMoves(heroes)){
            gameActions.oneTurn(heroes, this);
            printGame();
        }
    }

    public void initGameMap(int width, int height){
        if(this.treasureMap == null) {
            this.treasureMap = new TreasureMap(width, height);
        } else {
            SimpleLog.logMessage("Map already been initialized, this one : C - " + width + " - " + height + " was ignored");
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

    public Optional<Hero> getHeroOnCoordinate(Point coordinates){
        for (Hero hero: heroes) {
            if(hero.getCoordinates().equals(coordinates)) {
                return Optional.of(hero);
            }
        }
        return Optional.empty();
    }

    public boolean isOneHeroOnBox(Point coordinates){
        for (Hero hero: heroes) {
            if (hero.getCoordinates().equals(coordinates)) {
                return true;
            }
        }
        return false;
    }

    public boolean atLeastOneHeroHasMoves(ArrayList<Hero> heroes){
        for (Hero hero: heroes) {
            if(!hero.getMovement().isEmpty()){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> gameToOutputArrayList(){
        ArrayList<String> outputData = new ArrayList<>();

        outputData.add("C - " + treasureMap.getWidth() + " - " + this.treasureMap.getHeight());

        addBoxesInfosToOutput(outputData);

        addHeroesInfosToOutput(outputData);

        return outputData;
    }

    private void addHeroesInfosToOutput(ArrayList<String> outputData) {
        for (Hero hero: heroes) {
            outputData.add(hero.printOutputFormat());
        }
    }

    private void addBoxesInfosToOutput(ArrayList<String> outputData) {
        for (int i = 0; i < treasureMap.getHeight(); i++) {
            for (int j = 0; j < treasureMap.getWidth(); j++) {
                Box box = treasureMap.getBoxes()[i][j];
                if(!(box instanceof Plain)){
                    outputData.add(getOutputDataFromBox(box, i, j));
                }
            }
        }
    }

    private String getOutputDataFromBox(Box box, int x, int y) {
        if(box instanceof Mountain){
            return "M - " + y + " - " + x;
        } else if (box instanceof Treasure){
            return "T - " + y + " - " + x + " - " + ((Treasure) box).getNbTreasures();
        }
        return "";
    }

    public TreasureMap getTreasureMap() {
        return treasureMap;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public void setTreasureMap(TreasureMap treasureMap) {
        this.treasureMap = treasureMap;
    }

    public void printGame(){
        Box[][] treasureMapBoxes = treasureMap.getBoxes();
        for (int i = 0; i < treasureMap.getHeight(); i++) {
            for (int j = 0; j < treasureMap.getWidth(); j++) {
                Optional<Hero> hero = getHeroOnCoordinate(new Point(i,j));
                if(hero.isPresent()){
                    SimpleLog.logMessage(hero.get().printHero()+ "      ");
                } else {
                    SimpleLog.logMessage(treasureMapBoxes[i][j].printBox()+ "     ");
                }
            }
            SimpleLog.logMessage("\n");
        }
        SimpleLog.logMessage("\n\n");
    }
}
