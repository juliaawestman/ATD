package main.java.tile;/*
 * main.java.tile.tile.RightTurn
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

/**
 * main.java.tile.tile.RightTurn is a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.
 */
public class RightTurn extends PathTile implements TileAction {

    /**
     * main.java.tile.tile.RightTurn is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */
    protected RightTurn(Position p, String imgPath, Position nextPos) {

        super(p, imgPath, nextPos);
    }

    @Override
    public void landOn(Unit unit) {
    }

}
