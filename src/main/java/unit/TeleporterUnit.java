package src.main.java.unit;

/*
 * Class: TeleporterUnit
 *
 * Author: Isak Hjelt
 *
 * cs-user: dv14iht
 *
 * Date: 2015-11-26
 */
import src.main.java.*;

public class TeleporterUnit extends Unit {

    public TeleporterUnit(Position pos, Direction d) {
        super(pos, d);
        super.health = 20;
        super.price = 50;
        super.speed = 50;
        super.name = "GroundUnit";
        super.pos = pos;
        super.flying = false;
    }
}
