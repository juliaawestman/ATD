package main.java.tile;/*
 * main.java.tile.tile.Turn
 * 
 * Date 29/11- 2015
 * @author id12jwn
 */

import javafx.geometry.Pos;
import main.java.Position;
import main.java.unit.Unit;

/**
 * main.java.tile.tile.Turn is a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.
 */
public class Turn extends PathTile implements TileAction {

    private Position nextPos;
    /**
     * main.java.tile.tile.Turn is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */

    public Turn(Position p){
        super(p, "");;
    }

    @Override
    public void landOn(Unit unit) {
        unit.setNextPos(nextPos);

    }

    @Override
    public void sendToPos(Position posToSend) {
        nextPos = posToSend;
        setNextPos(posToSend);
    }

}
