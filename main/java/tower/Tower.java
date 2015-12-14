/**
 * Class:       tower
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-11-26
 */

package main.java.tower;

import main.java.GraphicEvent;
import main.java.Position;
import main.java.unit.Unit;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class Tower {

    private BufferedImage image;
    private int range;
    private int speed;
    private int damage;
    private boolean ground;
    private boolean air;
    private Unit target;
    private Position pos;
    private int timeOfLastAttack;

    /**
     * Constructor of a tower class
     *
     * @param range the range of the tower
     * @param speed the firing frequency of the tower
     * @param damage the damage dealt to a unit hit by the tower
     * @param air if the tower can shoot at flying units
     * @param ground if the tower can shoot at ground units
     * @param pos the position of the tower
     */
    protected Tower(int range, int speed, int damage, boolean air,
                    boolean ground, Position pos){
        this.range = range;
        this.speed = speed;
        this.damage = damage;
        this.air = air;
        this.ground = ground;
        this.pos = pos;

        timeOfLastAttack = 0;
        target = null;

    }

    /**
     * Determines if a unit is within range of the tower. A unit is considered
     * to be out of range if it is flying and the tower can only shoot at ground
     * units.
     *
     * @param newTarget the unit to check if within range.
     * @return true if the unit is within range, else false.
     */
    public boolean withinRange(Unit newTarget){
        if(newTarget.isFlying() && !air){
            return false;
        } else if (!newTarget.isFlying() && !ground){
            return false;
        }

        return (pos.getDistance(newTarget.getPosition()) <= range);
    }

    /**
     * Sets a new target for this tower to shoot at
     *
     * @param newTarget the new target
     */
    public void setTarget(Unit newTarget){
        target = newTarget;
    }

    /**
     * Will deal the towers damage to the towers current target.
     */
    public void attack(int time) {
        if(time - timeOfLastAttack >= speed){
            target.takeDamage(damage);
            timeOfLastAttack = time;
        }
    }

    protected void loadImage(URL imagePath){

    }

    /**
     * Will check if the towers current target is valid. If the target is dead
     * or out of range the target is invalid since the tower cannot shoot at it.
     *
     * @return true if current target is valid, else false.
     */
    public boolean hasValidTarget(){
        return target.isAlive() && withinRange(target);
    }

    /**
     * Returns the position of the tower.
     *
     * @return the position of the tower.
     */
    public Position getPosition() {
        return pos;
    }

    /*public GraphicEvent generateGraphicEvent() {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(String.valueOf(this.imagePath)));
        } catch (IOException ex) {
            System.err.println(ex.getCause().toString());
        }

        return (new GraphicEvent(this.id, this.pos, img));
    }*/
}
