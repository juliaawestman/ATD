package main.java.tile;/*
 * main.java.tile.tile.Straight
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

import java.awt.image.BufferedImage;

/**
 * main.java.tile.tile.Straight is a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface. 
 *
 */
public class Straight extends PathTile implements TileAction {
    /**
     * main.java.tile.tile.RightTurn is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
    */
    private Position nextPos;
    protected Straight(Position p) {
        super(p, "");
    }

    public void setNextPos(Position posToSet){
        nextPos = posToSet;
    }

    @Override
    public void sendToPos(Position posToSend) {
        setNextPos(posToSend);
    }

    @Override
    public void landOn(Unit unit) {

        unit.setNextPos(nextPos);
    }

}
