package src.main.java.tile;/*
 * src.main.java.tile.tile.Straight
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import src.main.java.Position;
import src.main.java.unit.Unit;

import java.awt.image.BufferedImage;

/**
 * src.main.java.tile.tile.Straight is a class that extends the src.main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface. 
 *
 */
public class Straight extends PathTile implements TileAction {


    private static String PATH; 
    private Position pos;
    private BufferedImage img = null;
    
    /**
     * src.main.java.tile.tile.RightTurn is the constructor that will read in the image when
     * the program will create a object of the class src.main.java.tile.tile.Default
    */
    protected Straight(Position p, String imgPath) {
   	super(p, imgPath);
   	pos = p;
   	PATH = imgPath;
   	
    }

    @Override
    public void landOn(Unit unit) {
	// TODO Auto-generated method stub
	
    }

}
