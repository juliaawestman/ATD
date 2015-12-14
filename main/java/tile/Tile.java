package main.java.tile;
/*
 * main.java.tile.tile
 * 
 * Date 1/12- 2015
 * @author id12jwn
 */
import main.java.Position;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * main.java.tile.tile is a class is a abctact class...
 */
public abstract class Tile {

    private URL path;
    //private String path;
    private BufferedImage img = null;
    private Position pos;

    /**
     * tile is the constructor that will set the values...
     * @param p
     * @param imgPath
     */
    protected Tile(Position p, String imgPath) throws MalformedURLException {
	    pos = p;
	    path = (new File(imgPath)).toURI().toURL();
        readInImg();
    }

    //next tile

    /**
     * readInImg will read in the img that is given of the path
     */
    public void readInImg(){
	/*try {
	    File file = new File(path);
	    img = ImageIO.read(file);

	} catch (IOException e) {
	    e.printStackTrace();
	}*/
    }

    /*added by Erik M*/
    public URL getImageURL(){
        return path;
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
