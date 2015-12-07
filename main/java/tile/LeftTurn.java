package main.java.tile;/*
 * main.java.tile.tile.LeftTurn
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import javafx.geometry.Pos;
import main.java.Position;
import main.java.unit.Unit;

/**
 * main.java.tile.tile.LeftTurn is a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.
 */
public class LeftTurn extends PathTile implements TileAction {

    private Position nextPos;
    /**
     * main.java.tile.tile.LeftTurn is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */
    protected LeftTurn(Position p, Position nextPosition) {
        super(p, imgPath, nextPosition);
        nextPos = nextPosition;
    }

    @Override
    public void landOn(Unit unit) {
        unit.setNextPos(nextPos);

    }

}
