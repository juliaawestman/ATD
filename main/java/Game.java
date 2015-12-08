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

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.tower.Tower;
import main.java.unit.Unit;
import org.xml.sax.SAXException;
import main.java.tile.TileAction;

public class Game {

    private int timeOfGame = 0;
    private User user;
    private MapFactory mapFactory;
    private Map map;
    private final int waveNr = 1;
    private final List<Unit> units = new LinkedList();
    private final List<Tower> towers = new LinkedList();
    private int nrOfWaves = 0;
    private int winCondition = 0;
    //----------------------------private Shop gameShop;

    public Game(int nrOfWaves, int winCondition) {
        this.nrOfWaves = nrOfWaves;
        this.winCondition = winCondition;
        try {
            mapFactory = new MapFactory("somepaththatidontknow");
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update() {

        /*Update the units*/
        updateUnits();
        /*Update the Towers*/
        updateTowers();
        timeOfGame++;
    }

    private void updateUnits() {
        ListIterator itrUnits = units.listIterator();
        Unit currentUnit;
        TileAction currentTile;

        while (itrUnits.hasNext()) {
            currentUnit = (Unit) itrUnits.next();
            /*Remove the unit if it's dead*/
            if (!currentUnit.isAlive()) {
                itrUnits.remove();
            }
            if (currentUnit.move()){
                currentTile = (TileAction) map.getTileAt(currentUnit.getPosition());
                currentTile.landOn(currentUnit);
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
            /*Does the tower have a target?*/
            if (currentTower.hasValidTarget()) {
                /*Call the attack mathod*/
                currentTower.attack(timeOfGame);

            } else {
                /*Try to find a target for the tower*/
                while (itrUnits.hasNext()) {
                    currentUnit = (Unit) itrUnits.next();
                    /*Remove the unit if it's dead*/
                    if (!currentUnit.isAlive()) {
                        itrUnits.remove();
                    /*Try to find new target for the tower*/
                    }else if(currentTower.withinRange(currentUnit)){
                        currentTower.setTarget(currentUnit);
                        currentTower.attack(timeOfGame);
                        break;
                    }
                }
            }
        }
    }
    public void addUnit(Unit unit){
        this.units.add(unit);
    }
    public void addTower(Tower tower){
        this.towers.add(tower);
    }

    public void readMap(String mapName) {
        this.map = mapFactory.makeMap(mapName);
    }
}
