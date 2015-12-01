
/*
 * Tile
 * 
 * Date 1/12- 2015
 * @author id12jwn
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Tile is a class is a abctact class...
 */
public abstract class Tile {
    
    private String path;   
    private BufferedImage img = null;
    private Position pos;
    
    /**
     * Tile is the constructor that will set the values...
     * @param p
     * @param imgPath
     */
    protected Tile(Position p, String imgPath) {
	pos = p;
	path = imgPath;
	
    }
    
    /**
     * readInImg will read in the img that is given of the path
     */
    public void readInImg(){
	try {
	    File file = new File(path);
	    img = ImageIO.read(file);

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * getImage is a getter that will get the image of 
     * the tile
     * @return image 
     */
    public BufferedImage getImg(){
	return img;
    }
    
    /**
     * getPostion is a getter that will get the position of the tile
     * @return
     */
    public Position getPosition() {
	return pos;
    }
    
}
