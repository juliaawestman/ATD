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
import java.awt.image.BufferedImage;
import main.java.Map;
import main.java.Position;
import main.java.tile.TileAction;

public abstract class Unit {

    protected static final int MAXSPEED = 50;
    protected String name;
    protected Position pos;
    private Position nextPos;
    protected BufferedImage img;
    protected int health;
    protected int price;
    protected int speed;
    protected int income;
    protected Boolean flying;
    private int timeLived = 0; 
    private boolean hasReachedGoal = false;

    /**
     * Initializes a new {@code Unit} which is being put on specified position.
     *
     * @param pos the position
     *
     */
    public Unit(Position pos) {
        this.pos = pos;
        this.nextPos = pos;
        this.health = 10;
        this.price = 10;
        this.speed = 10;
        this.name = "UnNamed";
        this.flying = false;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setFlying(boolean flying){
        this.flying = flying;
    }
    /**
     * Moves to the nextPos
     * 
     * @return returns true if unit moved this timetick false if not.
     */
    public boolean move(){
        boolean ret = false;
        /*Move more frequently depending on the speed*/
        if (((timeLived) % ((MAXSPEED + 1) - speed)) == 0) {
            TileAction currentTile;
            this.pos = this.nextPos;
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
        this.pos = pos;
    }

    public void setNextPos(Position nextPos) {
        this.nextPos = nextPos;
    }

    public void takeDamage(int dmg) {
        this.health -= dmg;
    }

    public boolean isAlive() {
        return (this.health > 0);
    }
    
    public void setHasReachedGoal(boolean b){
        this.hasReachedGoal = b;
    }
    
    public boolean hasReachedGoal(){
        return this.hasReachedGoal;
    }
}
