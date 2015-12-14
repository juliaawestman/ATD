package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class:       Renderer
 * <p/>
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        12/14/15
 */
public class Renderer extends SwingWorker{
    BufferedImage stuff;
    Graphics2D g;

    public Renderer(int height, int width){
        stuff = new BufferedImage(height, width, Image.SCALE_DEFAULT);
        g = stuff.createGraphics();
    }

    public static void main(String[] args) {

    }

    @Override
    protected Object doInBackground() throws Exception {
        return null;
    }
}
