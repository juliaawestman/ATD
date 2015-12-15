/**
 * Class: Game
 *
 * Author: Isak Hjelt
 *
 * cs-user: dv14iht
 *
 * Date: 2015-11-30
 */
package main.java;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javafx.geometry.Pos;
import main.java.tile.Tile;
import main.java.tile.TowerTile;
import main.java.tower.AirTower;
import main.java.tower.GroundTower;
import main.java.tower.Tower;
import main.java.unit.Unit;
import main.java.tile.TileAction;

public class Game {

    private static final int tileSize = 54;
    private int timeOfGame = 0;
    private static final int incomeFreq = 100;
    private static final int nrOfTowers = 5;
    private int nextId = 0;
    private User user;
    private Map map;
    private List<Unit> units;
    private List<Tower> towers;
    private CurrentGraphicState graphicState;
    private int unitsReachedGoal=0;
    private Shop gameShop;

    public Game(Map mapName) {

        this.map = mapName;
        this.units = new LinkedList();
        this.towers = new LinkedList();
        this.graphicState = new CurrentGraphicState();
        this.user = new User(this.map.getStartingGold(), 50);
        this.gameShop = new Shop(this.user, this);
        makeTowers();
    }

    public void update() {
        /*Update the units*/
        updateUnits();
        /*Update the Towers*/
        updateTowers();
        graphicState.gameTick(timeOfGame);
        timeOfGame++;
        /*Give the user more money if it should get more money this tick*/
        if(this.timeOfGame % this.incomeFreq == 0){
            this.user.increaseCredits(user.getIncome());
        }
    }

    private void updateUnits() {
        ListIterator itrUnits = units.listIterator();
        Unit currentUnit;
        TileAction currentTile;
        GraphicEvent tempEvent;
        Position tempTilePos;

        while (itrUnits.hasNext()) {
            currentUnit = (Unit) itrUnits.next();
            /*Remove the unit if it has reached goal*/
            if(currentUnit.hasReachedGoal()){
                tempEvent = currentUnit.generateGraphicEvent();
                this.graphicState.removeGraphicEvent(tempEvent);
                itrUnits.remove();
                this.unitsReachedGoal++;
            }
            /*Remove the unit if it's dead*/
            else if (!currentUnit.isAlive()) {
                tempEvent = currentUnit.generateGraphicEvent();
                this.graphicState.removeGraphicEvent(tempEvent);
                itrUnits.remove();
            }
            else if(currentUnit.move()){
                tempEvent = currentUnit.generateGraphicEvent();
                this.graphicState.addGraphicEvent(tempEvent);
                if (currentUnit.isInMiddleOfTile()){
                    tempTilePos = unitPosConverter(currentUnit.getPosition());
                    currentTile = (TileAction) map.getTileAt(tempTilePos);
                    currentTile.landOn(currentUnit);
                }
            }

        }
    }

    private void updateTowers() {
        ListIterator itrTowers = towers.listIterator();
        ListIterator itrUnits = units.listIterator();
        Tower currentTower;
        Unit currentUnit;

        while (itrTowers.hasNext()) {
            currentTower = (Tower) itrTowers.next();
            GraphicEvent e = null;
            /*Does the tower have a target?*/
            if (currentTower.hasValidTarget()) {
                /*Call the attack mathod*/
                e = currentTower.attack(timeOfGame);

            } else {
                /*Try to find a target for the tower*/
                while (itrUnits.hasNext()) {
                    currentUnit = (Unit) itrUnits.next();
                    if(currentUnit.isAlive() && currentTower.withinRange(currentUnit)){
                        currentTower.setTarget(currentUnit);
                        e = currentTower.attack(timeOfGame);
                        break;
                    }
                }
            }

            if (e != null) {
                graphicState.addGraphicEvent(e);
            }
        }
    }
    public boolean isWon(){
        return this.unitsReachedGoal == this.map.getWinScore();
    }

    public void addUnit(Unit unit){
        TileAction currentTile;
        Position tempTilePos;

        /*Set the next position of the unit to the position of the start tile*/
        Position posToSet = tilePosConverter(map.getStartTile().getPosition());
        unit.setCurrentPosition(posToSet);
        unit.setNextTilePos(posToSet);
        /*Call landon for the first tile the unit spawns on*/
        tempTilePos = unitPosConverter(unit.getPosition());
        currentTile = (TileAction) map.getTileAt(tempTilePos);
        currentTile.landOn(unit);

        this.units.add(unit);
    }

    public Shop getShop(){
        return this.gameShop;
    }

    private void makeTowers(){
        int nrOfTowerTiles = map.getTowerTiles().size();
        Iterator it = map.getTowerTiles().iterator();
        LinkedList <TowerTile>towerTileList = new LinkedList();
        int random;
        Tower tower;
        Position tempTilePos;

        if(nrOfTowerTiles == 0){
            throw new IllegalStateException("There are no towerTiles!");
        }
        /*place towers in a list*/
        while(it.hasNext()){
            towerTileList.add((TowerTile) it.next());
        }

        for(int i=0; i < this.nrOfTowers; i++){
            random = (int)(Math.random() * (nrOfTowerTiles));
            /*Add a tower and set the position of the tower to a random towerTiles position*/

            tempTilePos = towerTileList.get(random).getPosition();
            tower = new GroundTower(tilePosConverter(tempTilePos),getNextObjectId());
            this.towers.add(tower);

            /*Generate a graphic event when the tower is added to the game*/
            GraphicEvent tempEvent = tower.generateGraphicEvent();
            this.graphicState.addGraphicEvent(tempEvent);
        }
    }

    public CurrentGraphicState getGraphicState(){
        return this.graphicState;
    }

    /**
     * Translate a tileCoordinate to a graphic coordinate (the middle coordinate of the tile).
     *
     * @param tilePos the position of the tile to get the middle position of.
     * @return the graphic coordinate.
     */
    private Position tilePosConverter(Position tilePos){
        int tileX = tilePos.getX();
        int tileY = tilePos.getY();

        int middlePosX = (((tileX) * tileSize-1) + (tileSize / 2));
        int middlePosY = (((tileY) * tileSize-1) + (tileSize / 2));

        return new Position(middlePosX,middlePosY);
    }

    /**
     *
     * @param unitPos the position of the unit.
     * @return the coordinate of the tile the unit is on.
     */
    private Position unitPosConverter(Position unitPos){
        int posX = unitPos.getX();
        int posY = unitPos.getY();

        int tilePosX = (posX / tileSize);
        int tilePosY = (posY / tileSize);

        return new Position(tilePosX,tilePosY);
    }

    /**
     * Get the next id to give to a object in the game.
     *
     * @return
     */
    public int getNextObjectId(){
        int ret = this.nextId;
        this.nextId++;
        return ret;
    }
}