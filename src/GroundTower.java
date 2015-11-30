package src;

/**
 * Class:       GroundTower
 * <p/>
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-11-30
 */
public class GroundTower extends Tower {
    private static final int speed = 10;
    private static final int damage = 5;
    private static final int range = 10;

    /**
     * Constructor of a tower only able to shoot at ground units.
     *
     * @param position the position of the tower.
     */
    public GroundTower(Position position){
        super(range, speed, damage, false, true, position);
    }
}
