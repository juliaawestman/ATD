package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Joakim on 2015-12-07.
 */
public class Block extends Rectangle {
    public int Id;

    public Block(int x, int y, int width, int height, int Id) {
        setBounds(x, y, width, height);
        this.Id = Id;
    }

    public void draw(Graphics g) {
        g.drawImage(new ImageIcon("main/resources/towerTile.png").getImage(), x, y, width, height, null);

    }
}
