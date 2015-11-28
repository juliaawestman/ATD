package src.unit;


/*
 * Class: GroundUnit

 * Author: Isak Hjelt

 * cs-user: dv14iht

 * Date: 2015-11-26
 */
import src.Position;

public class GroundUnit extends Unit {

    public GroundUnit(Position pos, Direction d) {

        super(pos, d);
        super.health = 30;
        super.price = 30;
        super.speed = 30;
        super.name = "GroundUnit";
        super.pos = pos;
        super.flying = false;
    }

}
