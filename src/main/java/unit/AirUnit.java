package src.main.java.unit;


/*
 * Class: AirUnit

 * Author: Isak Hjelt

 * cs-user: dv14iht

 * Date: 2015-11-26
 */
import src.main.java.*;

public class AirUnit extends src.main.java.unit.Unit {

    public AirUnit(Position pos, Direction d) {
        super(pos, d);
        super.health = 20;
        super.price = 30;
        super.speed = 45;
        super.name = "AirUnuit";
        super.pos = pos;
        super.flying = true;
    }
}
