package main.java.tile;

import main.java.Position;

import java.net.MalformedURLException;

public abstract class PathTile extends Tile {

    private Position nextPos;

    protected PathTile(Position p, String imgPath) throws MalformedURLException {
        super(p, imgPath);

    }

    protected void setNextPos(Position posToSet){
        nextPos = posToSet;
    }

    protected Position getNextPos(){
        return nextPos;
    }

    public abstract void sendToPos(Position posToSend);

}
