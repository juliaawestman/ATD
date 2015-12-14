package main.java.tower;

import main.java.Position;

/**
 * Class:       AirTower
 * <p/>
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-11-30
 */
public class AirTower extends Tower {
    private static final int speed = 10;
    private static final int damage = 5;
    private static final int range = 10;

    /**
     * Constructor of a tower only able to shoot at flying units.
     *
     * @param position the position of the tower.
     */
    public AirTower(Position position){
        super(range, speed, damage, true, false, position);
        loadImage("/main/java/resources/AirTower.png");
    }
}
