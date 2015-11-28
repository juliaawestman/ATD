/*
 * TileTest
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

import java.awt.image.BufferedImage;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 * TileTest is a TestClass that will test that the different
 * TileClasses is working as it should. 
 */
public class TileTest {

   /**
    * Test that the method getImg in the class Default 
    */
    @Test
    public void readInDefualtImg(){
	BufferedImage img = null;
	Default defaultTile = new Default();
	img = defaultTile.getImg();
	assertNotNull(img);	
    }
    
    /**
     * Test that the method getImg in the class TCross
     */
     @Test
     public void readInTCrossImg(){
 	BufferedImage img = null;
 	TCross TCrossTile = new TCross();
 	img = TCrossTile.getImg();
 	assertNotNull(img);	
     }

}
