package src.main.java.tile;/*
 * src.main.java.tile.tile.TCross
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

import src.main.java.Position;
import src.main.java.unit.Unit;

import java.awt.image.BufferedImage;

/**
 * src.main.java.tile.tile.TCross a class that extends the src.main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.   
 */
public class TCross extends PathTile implements TileAction {
    
    private static String PATH; 
    private Position pos;
    private BufferedImage img = null;
    
    /**
     * src.main.java.tile.tile.TCross is the constructor that will read in the image when
     * the program will create a object of the class src.main.java.tile.tile.Default
     */
    protected TCross(Position p, String imgPath) {
	super(p, imgPath);
	
	PATH = imgPath;
	pos = p;
    }
    /**
     * 
     */
    @Override
    public void landOn(Unit unit) {
	
    }

}
