package main.java.tile;/*
 * main.java.tile.tile.TCross
 * 
 * Date 27/11- 2015
 * @author id12jwn
 */

import main.java.Position;
import main.java.unit.Unit;

import java.net.MalformedURLException;

/**
 * main.java.tile.tile.TCross a class that extends the main.java.tile.tile.PathTile class. The class
 * have a own image that will be used in the user interface.   
 */
public class TCross extends PathTile implements TileAction {

    private Position nextPos;
    private Position defaultNextPos= null;
    private String TCrossImg;

    /**
     * main.java.tile.tile.TCross is the constructor that will read in the image when
     * the program will create a object of the class main.java.tile.tile.Default
     */
    public TCross(Position p) throws MalformedURLException {
        super(p, "main/resources/TCross.png");
    }

    public void setPosistions(Position posToSet){
        if(defaultNextPos==null){
            defaultNextPos = posToSet;
        } else {
            nextPos = posToSet;
        }
    }

    private String getTCrossImg(){
        Position nextPos = getNextPos();
        Position pos = getPosition();
        if(nextPos.getY() > pos.getY()){
            TCrossImg = "main/resources/TCross.png";
        } else if (nextPos.getY() < pos.getY()){
            TCrossImg = "main/resources/TCrossDown.png";
        } else if(nextPos.getX()> pos.getX()){
            TCrossImg = "main/resources/TCrossRight.png";
        } else {
            TCrossImg = "main/resources/TCrossLeft.png";
        }
       return TCrossImg;
    }


    //
    public void changeDirection(){

        if (defaultNextPos.equals(getNextPos())) {
            setNextPos(nextPos);
        } else {
            setNextPos(defaultNextPos);
        }

        String temp;
        temp = getTCrossImg();
        changeImgURL(temp);
    }

    @Override
    public void sendToPos(Position posToSend) {
        setPosistions(posToSend);
        setNextPos(defaultNextPos);
    }

    /**
     *
     */
    @Override
    public void landOn(Unit unit) {
        Position tempPos = getNextPos();
        unit.setNextTilePos(tempPos);
    }
}
