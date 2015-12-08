package main.java.GUI;

import main.java.Map;
import main.java.tile.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Joakim on 2015-12-07.
 */
public class Board {
    public int worldWidth = 12;
    public int worldHeight = 12;
    public int blockSize = 54;

    public Block[][] block;

    public Board() {
        define();
    }

    public void define() {
        block = new Block[worldHeight][worldWidth];

        for (int y=0;y<block.length;y++) {
            for (int x = 0; x < block[0].length; x++) {
                block[y][x] = new Block((GameGUI.myWidth / 2) - ((worldWidth * blockSize) / 2) + (x * blockSize), (y * blockSize), blockSize, blockSize, 0);
            }
        }
    }

    public void draw(Graphics g) {
        for (int y=0;y<block.length;y++) {
            for(int x=0;x<block[0].length;x++) {
                block[y][x].draw(g);
            }

            }

    }


}