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
     * Test that the method getImg in the class 
    */
    @Test
    public void readInTowerImg(){
 	BufferedImage img = null;
 	TowerTile towerTile = new TowerTile();
 	img = towerTile.getImg();
 	assertNotNull(img);	
     }
    
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
 	TCross tCrossTile = new TCross();
 	img = tCrossTile.getImg();
 	assertNotNull(img);	
     }
     
     /**
      * Test that the method getImg in the class Start
      */
      @Test
      public void readInStartImg(){
  	BufferedImage img = null;
  	Start startTile = new Start();
  	img = startTile.getImg();
  	assertNotNull(img);	
      }
      
      /**
       * Test that the method getImg in the class End
       */
       @Test
       public void readInEndImg(){
   	BufferedImage img = null;
   	End endTile = new End();
   	img = endTile.getImg();
   	assertNotNull(img);	
       }
       
       /**
        * Test that the method getImg in the class RightTurn
        */
        @Test
        public void readInRightTurnImg(){
    	BufferedImage img = null;
    	RightTurn rightTurnTile = new RightTurn();
    	img = rightTurnTile.getImg();
    	assertNotNull(img);	
        }
        
        /**
         * Test that the method getImg in the class LeftTurn
        */
        @Test
        public void readInLeftTurnImg(){
     	BufferedImage img = null;
     	LeftTurn leftTurnTile = new LeftTurn();
     	img = leftTurnTile.getImg();
     	assertNotNull(img);	
         }
        
        /**
         * Test that the method getImg in the class Teleporter
        */
        @Test
        public void readInTelepoterImg(){
     	BufferedImage img = null;
     	Telepoter telepoterTile = new Telepoter();
     	img = telepoterTile.getImg();
     	assertNotNull(img);	
         }
        
        /**
         * Test that the method getImg in the class Straight
        */
        @Test
        public void readInStraightImg(){
     	BufferedImage img = null;
     	Straight straightTile = new Straight();
     	img = straightTile.getImg();
     	assertNotNull(img);	
         }
        

}
