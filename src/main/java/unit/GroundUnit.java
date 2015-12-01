package src.main.java.unit;


/*
 * Class: GroundUnit

 * Author: Isak Hjelt

 * cs-user: dv14iht

 * Date: 2015-11-26
 */
import src.main.java.*;

public class GroundUnit extends src.main.java.unit.Unit {

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
