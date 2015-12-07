package main.java.tile;

import main.java.Position;

public class PathTile extends Tile {

    private Position nextTile;
    protected PathTile(Position p, String imgPath, Position nextPos) {
	super(p, imgPath);

        nextTile = nextPos;
    }


    // korsningen behöver egen varibael en tile som alternativ så den kan  byta till next tile
}
