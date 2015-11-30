package src.unit;

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
import src.Position;

public abstract class Unit {

    protected static final int MAXSPEED = 50;
    protected String name;
    protected Position pos;
    protected BufferedImage img;
    protected int health;
    protected int price;
    protected int speed;
    protected int income;
    protected Boolean flying;
    private int timeLived = 0; 

    public enum Direction {

        NORTH, EAST, SOUTH, WEST
    }
    Direction direction;

    /**
     * Initializes a new {@code Unit} which is being put on specified position.
     *
     * @param pos the position
     * @param d the direction wich the unit will be facing
     *
     */
    public Unit(Position pos, Direction d) {
        this.pos = pos;
        this.direction = d;

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

    public void move() {
        /*Move more frequently depending on the speed*/
        if (((timeLived) % ((MAXSPEED + 1) - speed)) == 0) {
            Position newPos = null;
            switch (this.direction) {
                case NORTH:
                    newPos = this.pos.getPosToNorth();
                    break;
                case EAST:
                    newPos = this.pos.getPosToEast();
                    break;
                case SOUTH:
                    newPos = this.pos.getPosToSouth();
                    break;
                case WEST:
                    newPos = this.pos.getPosToWest();
                    break;
            }
            if (newPos == null) {
                throw new NullPointerException("The unit is not facing "
                        + "any direction");
            }
            setCurrentPosition(newPos);
        }
        timeLived++;
    }

    public boolean isFlying() {
        return flying;
    }

    public Position getPosition() {
        return this.pos;
    }

    protected void setCurrentPosition(Position pos) {
        this.pos = pos;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void takeDamage(int dmg) {
        this.health -= dmg;
    }

    public boolean isAlive() {
        return (this.health > 0);
    }
}
