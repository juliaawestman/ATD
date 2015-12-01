/*
 * Default
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

/**
 * Default a class that extends the PathTile class. The class
 * have a own image that will be used in the user interface.   
 */
public class Default extends PathTile {

    private static String PATH; 
    private Position pos;
    /**
     * Default is the constructor that will read in the image when 
     * the program will create a object of the class Default
     */
    protected Default(Position p, String imgPath) {
  	super(p, imgPath);
  	PATH = imgPath;
  	pos =p;
      }
    
}
