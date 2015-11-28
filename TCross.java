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
public class TCross extends PathTile {
    
    private static String PATH ="TCross.jpg"; 
    
    private BufferedImage img = null;
    
    /**
     * Default is the constructor that will read in the image when 
     * the program will create a object of the class Default
     */
    public TCross() {
	readInImg();
    }
    
    /**
     * ReadInImg is a method that will read in a image that 
     * will be used in the user interface
     */
    public void readInImg(){
	try {
	   // URL url = new URL(IMG_URL);
	    File file = new File(PATH);
	    img = ImageIO.read(file);
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * getImage is method that will get the image
     * @return a BufferedImage
     */
    public BufferedImage getImg(){
	return img;
    }

}
