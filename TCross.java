/*
 * TCross
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * TCross a class that extends the PathTile class. The class
 * have a own image that will be used in the user interface.   
 */
public class TCross extends PathTile implements TileAction {
    
    private static String PATH; 
    private Position pos;
    private BufferedImage img = null;
    
    /**
     * TCross is the constructor that will read in the image when 
     * the program will create a object of the class Default
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
