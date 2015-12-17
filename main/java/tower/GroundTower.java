package main.java.tower;

import main.java.Position;

/**
 * Class:       GroundTower
 * <p/>
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-11-30
 */
public class GroundTower extends Tower {
    private static final int speed = 300;
    private static final int damage = 10;
    private static final int range = 150;

    /**
     * Constructor of a tower only able to shoot at ground units.
     *
     * @param position the position of the tower.
     * @param id the id of the tower.
     */
    public GroundTower(Position position, int id){
        super(range, speed, damage, false, true, position);
        super.id = id;
        loadImage(this.getClass().getResource("../../resources/GroundTower.png"));
    }
}
