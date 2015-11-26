/**
 * Class:       Tower
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-11-26
 */

package src;

public abstract class Tower {

    private int range;
    private int speed;
    private int damage;
    private boolean ground;
    private boolean air;
    private Unit target;
    private Position pos;
    private int timeOfLastAttack;

    public boolean withinRange(Unit newTarget){
        return false;
    }
}
