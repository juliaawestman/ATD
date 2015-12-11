package main.java.tile;/*
 * main.java.tile.tile.TCross
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

import java.net.MalformedURLException;

/**
 * main.java.tile.tile.TCross a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.   
 */
public class TCross extends PathTile implements TileAction {

    private Position nextPos;
    private Position defaultNextPos= null;

    /**
     * main.java.tile.tile.TCross is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */
    public TCross(Position p) throws MalformedURLException {
        super(p, "");
    }

    public void setPosistions(Position posToSet){
        if(defaultNextPos==null){
            defaultNextPos = posToSet;
        } else {
            nextPos = posToSet;
        }
    }

    @Override
    public void sendToPos(Position posToSend) {
        setPosistions(posToSend);
        setNextPos(defaultNextPos);
    }

    /**
     *
     */
    @Override
    public void landOn(Unit unit) {
        Position tempPos = getNextPos();
        if (!tempPos.equals(defaultNextPos)) {
            defaultNextPos = tempPos;
        } else {
            nextPos = tempPos;
        }
        setNextPos(tempPos);
        unit.setNextTilePos(tempPos);
    }
}
