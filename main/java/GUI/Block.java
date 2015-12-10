package main.java.GUI;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Joakim on 2015-12-07.
 */
public class Block extends Rectangle {
    public int Id;

    public Block(int x, int y, int width, int height, int Id) {
        setBounds(x, y, width, height);
        this.Id = Id;
    }

    public void draw(Graphics g, String tilepath) {

        g.drawImage(new ImageIcon(tilepath).getImage(), x, y, width, height, null);

    }

    public void draw(Graphics g, URL tilepath) {

        g.drawImage(new ImageIcon(tilepath, "tile").getImage(), x, y, width, height, null);

    }
}
