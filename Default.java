import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Default extends PathTile {
    
  
   // private static final String IMG_URL = "https://www.dropbox.com/s/t43fclbqlb19dwv/default.jpg?dl=0";
    private static String PATH ="/users/juliawestman/documents/ATD/default.jpg"; 
    
    private BufferedImage img = null;
    
    public Default() {
	readInImg();
    }
    
    public void readInImg(){
	try {
	    
	    System.out.println("inne i read");
	   // URL url = new URL(IMG_URL);
	    File file = new File(PATH);
	    img = ImageIO.read(file);
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    public BufferedImage getImg(){
	return img;
    }

}
