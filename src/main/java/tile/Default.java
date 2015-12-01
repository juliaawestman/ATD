package src.main.java.tile;/*
 * src.main.java.tile.tile.Default
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

import src.main.java.Position;

/**
 * src.main.java.tile.tile.Default a class that extends the src.main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.   
 */
public class Default extends PathTile {

    /**
     * src.main.java.tile.tile.Default is the constructor that will read in the image when
     * the program will create a object of the class src.main.java.tile.tile.Default
     */
    protected Default(Position p, String imgPath) {
  	super(p, imgPath);
      }
    
}
