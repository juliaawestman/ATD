package main.java.unit;

/**
 * Class: Unit
 *
 * Author: Isak Hjelt
 *
 * cs-user: dv14iht
 *
 * Date: 2015-11-26
 */
import main.java.GraphicEvent;
import main.java.Position;
import main.java.PositionConverter;
import main.java.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public abstract class Unit {
    /*Static variables*/

    protected static final int MAXSPEED = 50;
    private static final int tileSize = 54;
    protected String name;
    protected Position pos;
    protected int id;
    private Position nextTilePos;
    protected URL imagePath;
    protected int health;
    protected int price;
    protected int speed;
    protected boolean isClickableUnit = false;
    protected Boolean flying;
    protected Boolean teleporter=false;
    private int timeLived = 0;
    private boolean hasReachedGoal = false;

    /**
     * Initializes a new {@code Unit} which is being put on specified position.
     *
     * @param pos the position
     *
     */
    public Unit(Position pos, int id) {
        this.pos = pos;
        this.nextTilePos = pos;
        this.health = 10;
        this.price = 10;
        this.speed = 45;
        this.name = "UnNamed";
        this.flying = false;
        this.id = id;

    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    /**
     * Moves to the nextPos
     *
     * @return returns true if the unit moved.
     */
    public boolean move() {
        boolean ret = false;

        /*Move more frequently depending on the speed*/
        if (((timeLived) % ((MAXSPEED + 1) - speed)) == 0) {
            this.pos = getNextPos();
            ret = true;
        }
        timeLived++;
        return ret;
    }

    public boolean isFlying() {
        return flying;
    }

    public Position getPosition() {
        return this.pos;
    }

    public void setCurrentPosition(Position pos) {
        this.pos = PositionConverter.tilePosConverter(pos);
    }

    public void setNextTilePos(Position nextTilePos) {
        this.nextTilePos = nextTilePos;
    }

    public void takeDamage(int dmg) {
        this.health -= dmg;
    }

    public boolean isAlive() {
        return (this.health > 0);
    }

    public void setHasReachedGoal(boolean b) {
        this.hasReachedGoal = b;
        this.health = 0;
    }

    public boolean hasReachedGoal() {
        return this.hasReachedGoal;
    }


    /**
     *
     * @return the position one step closer to the middle of the next tile
     */
    private Position getNextPos() {
        int currentX = this.pos.getX();
        int currentY = this.pos.getY();
        int tileX = this.nextTilePos.getX();
        int tileY = this.nextTilePos.getY();
        int tileMiddlePosX = (((tileX) * tileSize-1) + (tileSize / 2));
        int tileMiddlePosY = (((tileY) * tileSize-1) + (tileSize / 2));

        if (currentX < tileMiddlePosX) {
            currentX++;
        } else if (currentX > tileMiddlePosX) {
            currentX--;
        }
        if (currentY < tileMiddlePosY) {
            currentY++;
        } else if (currentY > tileMiddlePosY) {
            currentY--;
        }
        return new Position(currentX, currentY);
    }

    /**
     *
     * @return true if the unit is on the position in the middle of the tile,
     * false if not.
     */
    public boolean isInMiddleOfTile() {
        int currentX = this.pos.getX();
        int currentY = this.pos.getY();
        int tileX = this.nextTilePos.getX();
        int tileY = this.nextTilePos.getY();
        int tileMiddlePosX = (((tileX) * tileSize-1) + (tileSize / 2));
        int tileMiddlePosY = (((tileY) * tileSize-1) + (tileSize / 2));

        return (currentX == tileMiddlePosX) && (currentY == tileMiddlePosY);
    }



    public GraphicEvent generateGraphicEvent() {
        BufferedImage img = null;

        try {
            img = ImageIO.read(this.imagePath);
        } catch (IOException ex) {
            System.err.println(ex.getCause().toString());
        }

        return (new GraphicEvent(this.id, this.pos, img));
    }
    public Tile click(){
        return null;
    }
    public boolean isClickable(){
        return this.isClickableUnit;
    }
}
