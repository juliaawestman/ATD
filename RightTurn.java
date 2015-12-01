/*
 * RightTurn
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * RightTurn is a class that extends the PathTile class. The class
 * have a own image that will be used in the user interface. 
 *
 */
public class RightTurn extends PathTile implements TileAction {

    private static String PATH ; 
    private Position pos;
    private BufferedImage img = null;

    /**
     * RightTurn is the constructor that will read in the image when 
     * the program will create a object of the class Default
     */
    protected RightTurn(Position p, String imgPath) {
	super(p, imgPath);
	pos = p;
	PATH = imgPath;
    }

    @Override
    public void landOn(Unit unit) {

    }

}
