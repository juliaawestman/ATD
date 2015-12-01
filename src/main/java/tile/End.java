package src.main.java.tile;/*
 * src.main.java.tile.tile.End
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import src.main.java.Position;
import src.main.java.unit.Unit;

import java.awt.image.BufferedImage;

/**
 * src.main.java.tile.tile.End is a class that extends the src.main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface. 
 *
 */
public class End extends PathTile implements TileAction{

    /**
     * src.main.java.tile.tile.End is the constructor that will read in the image when
     * the program will create a object of the class src.main.java.tile.tile.Default
     */
    protected End(Position p, String imgPath) {
   	super(p, imgPath);
       }

    @Override
    public void landOn(Unit unit) {
	// TODO Auto-generated method stub
	
    }
}
