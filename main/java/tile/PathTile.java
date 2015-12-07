package main.java.tile;

import main.java.Position;

public abstract class PathTile extends Tile {

    private Position nextPos;
    protected PathTile(Position p, String imgPath) {
	super(p, imgPath);

    }

    protected void setNextPos(Position posToSet){
        nextPos = posToSet;
    }

    public abstract void sendToPos(Position posToSend);

}
