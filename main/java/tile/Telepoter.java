package main.java.tile;/*
 * Teleporter
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

import java.awt.image.BufferedImage;

/**
 * main.java.tile.tile.
 * Telepoter is a class that extends the 
 * main.java.tile.tile.PathTile class. The class have a own
 * image that will be used in the user interface. 
 *
 */
public class Telepoter extends PathTile implements TileAction {

    // TODO: change img
    private static String PATH; 
    
    private Position pos;
    private BufferedImage img = null;
    
    /**
     * main.java.tile.tile. Teleporter is the constructor that
     * will read in the image when the program will create a object
     * of the class main.java.tile.tile.Default
     */
    protected Telepoter(Position p, String imgPath) {
	super(p, imgPath);
	pos = p;
	PATH = imgPath;
    }

    @Override
    public void landOn(Unit unit){
	
    } 	

}
