/*
 * TowerTile
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * TowerTile is a class that extends the PathTile class. The class
 * have a own image that will be used in the user interface. 
 *
 */
public class TowerTile extends Tile{
 
     private static String PATH; 
     private BufferedImage img = null;
     private Position pos;
     
    /**
     *  
     * @param p
     * @param imgPath
     */
    protected TowerTile(Position p, String imgPath) {
	super(p, imgPath);
	PATH =imgPath;
	pos = p;
    }
}
