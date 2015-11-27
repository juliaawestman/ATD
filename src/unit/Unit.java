
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

    private static final int MAXSPEED = 50;
    private String name;
    private Position pos;
    private BufferedImage img;
    private int health;
    private int price;
    private int speed;
    private int income;
    private int timeLived = 0;
    private Boolean flying;

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
    }

    public void move() {
        /*Move more frequently depending on the speed*/
        if ((((timeLived) % (MAXSPEED + 1) - speed)) == 0) {
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

    public Position getPosition() {
        return pos;
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
