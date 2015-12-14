package main.java.tile;/*
 * main.java.tile.tile.Default
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

import main.java.Position;

import java.net.MalformedURLException;

/**
 * main.java.tile.tile.Default a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.
 */
public class Default extends PathTile {

    /**
     * main.java.tile.tile.Default is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */
    public Default(Position p) throws MalformedURLException {
        super(p, "main/resources/defaultTile.png");
    }

    @Override
    public void sendToPos(Position posToSend) {
        setNextPos(posToSend);
    }
}
