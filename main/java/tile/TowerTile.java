package main.java.tile;/*
 * main.java.tile.TowerTile
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import main.java.Position;

import java.net.MalformedURLException;

/**
 * main.java.tile.TowerTile is a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface. 
 *
 */
public class TowerTile extends Tile {

    /**
     *  
     * @param p
     */
    public TowerTile(Position p) throws MalformedURLException {
	    super(p, "main/resources/towerTile.png");
    }
}
