package main.java.tile;/*
 * main.java.tile.tile.Start
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

import java.net.MalformedURLException;

/**
 * main.java.tile.tile.Start is a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.
 */
public class Start extends PathTile implements TileAction {

    private Position nextPos;
    /**
     * main.java.tile.tile.Start is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */
    public Start(Position p) throws MalformedURLException {
        super(p, "main/resources/pathTile.png");
    }

    @Override
    public void landOn(Unit unit) {
        unit.setNextPos(nextPos);

    }
    @Override
    public void sendToPos(Position posToSend) {
        nextPos = posToSend;
        setNextPos(posToSend);
    }

}
