package main.java.GUI;

import main.java.Map;
import main.java.Position;
import main.java.tile.PathTile;
import main.java.tile.Start;
import main.java.tile.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Class: Board
 * GUI class for drawing the game board for the selected level, which in turn consists of several blocks
 *
 * Created by Joakim on 2015-12-07.
 */
public class Board {
    public int worldWidth = 12;
    public int worldHeight = 12;
    public static int blockSize = 54;
    public Block[][] block;
    private CLayout c;
    private String map;
    private String tile;
    HashMap<Position, Tile> HM;

    public Board(CLayout c, String map) {
        this.c = c;
        this.map = map;
        define();
    }

    public void define() {
        block = new Block[worldHeight][worldWidth];
        HM = c.mapinfo.getMap(map);

        for (int y=0;y<block.length;y++) {
            for (int x = 0; x < block[0].length; x++) {
                block[y][x] = new Block((GameGUI.myWidth / 2) - ((worldWidth * blockSize) / 2) + (x * blockSize), (y * blockSize), blockSize, blockSize, 0);
            }
        }
    }

    public void physic() {

    }

    /**
     * Draws the blocks the game board consists of, it checks which tile is suppose to be in which position and draws it
     * there as a block
     *
     * @param g
     */
    public void draw(Graphics g) {

        //Map map = new Map();

        Tile t;
        for (int y=0;y<block.length;y++) {
            for(int x=0;x<block[0].length;x++) {

                if(HM.get(new Position(x+1, y+1)) != null) {
                    tile = HM.get(new Position(x+1, y+1)).toString();
                    t = HM.get(new Position(x+1, y+1));
                } else {
                    tile = "";
                    t=null;
                }

                //if(c.mapinfo.getMap())
                //System.out.println(c.mapinfo.getMap(map).get(new Position(x+1, y+1)));
                //main/resources/towerTile.png

                if(tile.contains("Path")) {
                    block[y][x].draw(g,"main/resources/pathTile.png");
                } else if(tile.contains("Tower")) {
                    block[y][x].draw(g,"main/resources/towerTile.png");
                } else if(tile.contains("Cross")) {
                    block[y][x].draw(g, "main/resources/TCross.jpg");
                }else if(t != null){ //added by Erik M
                    if(PathTile.class.isAssignableFrom(t.getClass())) {
                        block[y][x].draw(g, t.getImageURL());
                    }
                } else {
                    block[y][x].draw(g,"main/resources/defaultTile.png");
                }
            }
            }
    }

}