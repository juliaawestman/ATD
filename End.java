/*
 * End
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * End is a class that extends the PathTile class. The class
 * have a own image that will be used in the user interface. 
 *
 */
public class End extends PathTile implements TileAction{


    //TODO: change img
    private static String PATH; 
    private Position pos;
    private BufferedImage img = null;

    /**
     * End is the constructor that will read in the image when 
     * the program will create a object of the class Default
     */
    protected End(Position p, String imgPath) {
   	super(p, imgPath);
   	pos = p;
   	PATH = imgPath;
       }

    @Override
    public void landOn(Unit unit) {
	// TODO Auto-generated method stub
	
    }
}
