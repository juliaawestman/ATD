package main.java.tile;/*
 * main.java.tile.tile.PathWay
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

import java.net.MalformedURLException;

/**
 * main.java.tile.tile.PathWay is a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.
 */
public class PathWay extends PathTile {

    private Position nextPos;
    //hej
    /**
     * main.java.tile.tile.PathWay is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */

    public PathWay(Position p) throws MalformedURLException {
        super(p, "main/resources/pathTile.png");
    }

    @Override
    public void landOn(Unit unit) {
        unit.setNextTilePos(nextPos);

    }

    @Override
    public void sendToPos(Position posToSend) {
        nextPos = posToSend;
        setNextPos(posToSend);
    }

}
