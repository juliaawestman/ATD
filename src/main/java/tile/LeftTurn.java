package src.main.java.tile;/*
 * src.main.java.tile.tile.LeftTurn
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import src.main.java.Position;
import src.main.java.unit.Unit;

import java.awt.image.BufferedImage;

/**
 * src.main.java.tile.tile.LeftTurn is a class that extends the src.main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface. 
 *
 */
public class LeftTurn extends PathTile implements TileAction {

    // TODO: change img
    private static String PATH = "src/main/resources/default.jpg";
    private Position pos;
    private BufferedImage img = null;
    
    /**
     * src.main.java.tile.tile.LeftTurn is the constructor that will read in the image when
     * the program will create a object of the class src.main.java.tile.tile.Default
     */
    protected LeftTurn(Position p, String imgPath) {
	super(p, imgPath);
	pos = p;
	PATH = imgPath;
    }

    @Override
    public void landOn(Unit unit) {
	// TODO Auto-generated method stub
	
    }
     
}
