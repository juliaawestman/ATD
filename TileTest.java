

import java.awt.image.BufferedImage;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class TileTest {

   /**
    * Test that the method getImg in the class Default 
    */
    @Test
    public void readInImg(){
	BufferedImage img = null;
	Default defaultTile = new Default();
	img = defaultTile.getImg();
	assertNotNull(img);	
    }

}
