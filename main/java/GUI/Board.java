package main.java.GUI;

import main.java.Map;
import main.java.Position;
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

    private CLayout c;
    private String map;
    private String tile;

    public Board(CLayout c, String map) {
        this.c = c;
        this.map = map;
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

    public void physic() {

    }

    public void draw(Graphics g) {

        //Map map = new Map();

        for (int y=0;y<block.length;y++) {
            for(int x=0;x<block[0].length;x++) {

                if(c.mapinfo.getMap(map).get(new Position(x+1, y+1)) != null) {
                    tile = c.mapinfo.getMap(map).get(new Position(x+1, y+1)).toString();
                } else {
                    tile = "";
                }

                //if(c.mapinfo.getMap())
                //System.out.println(c.mapinfo.getMap(map).get(new Position(x+1, y+1)));
                //main/resources/towerTile.png

                if(tile.contains("Path")) {
                    block[y][x].draw(g,"main/resources/pathTile.png");
                } else if(tile.contains("Tower")) {
                    block[y][x].draw(g,"main/resources/towerTile.png");
                } else if(tile.contains("Cross")) {
                    block[y][x].draw(g,"main/resources/TCross.jpg");
                } else {
                    block[y][x].draw(g,"main/resources/defaultTile.png");
                }
            }

            }

    }


}