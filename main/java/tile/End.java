package main.java.tile;/*
 * main.java.tile.tile.End
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

import java.net.MalformedURLException;

/**
 * main.java.tile.tile.End is a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.
 */
public class End extends PathTile {


    /**
     * Todo
     * main.java.tile.tile.End is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */
    public End(Position p) throws MalformedURLException {
        super(p, "main/resources/pathTile.png");
    }

    @Override
    public void sendToPos(Position posToSend) {}

    @Override
    public void landOn(Unit unit) {
        unit.setHasReachedGoal(true);
    }
}
