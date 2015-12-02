package main.java.tile;/*
 * main.java.tile.tile.TCross
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

/**
 * main.java.tile.tile.TCross a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.   
 */
public class TCross extends PathTile implements TileAction {
    
    
    /**
     * main.java.tile.tile.TCross is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */
    protected TCross(Position p, String imgPath) {
	super(p, imgPath);
    }
    /**
     * 
     */
    @Override
    public void landOn(Unit unit) {
	
    }

}
