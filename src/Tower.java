/**
 * Class:       Tower
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-11-26
 */

package src;

import src.unit.Unit;

public abstract class Tower {

    private int range;
    private int speed;
    private int damage;
    private boolean ground;
    private boolean air;
    private Unit target;
    private Position pos;
    private int timeOfLastAttack;

    /**
     * Constructor of a Tower class
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
        //TODO remove or uncomment (waiting for fix in src.unit.Unit)
        //TODO add tests for this part
        /* Commented away since unit has no method isFlying*/
        /*if(newTarget.isFlying() && !air){
            return false;
        } else if (!newTarget.isFlying && !ground){
            return false;
        }*/

        return pos.getDistance(newTarget.getPosition()) <= range;
    }

    /**
     * Sets a new target for this tower to shoot at
     *
     * @param newTarget the new target
     */
    public void setTarget(Unit newTarget){
        target = newTarget;
    }

    public boolean attack() {
        return false;
    }
}
