package main.java.unit;

/*
 * Class: TeleporterUnit
 *
 * Author: Isak Hjelt
 *
 * cs-user: dv14iht
 *
 * Date: 2015-11-26
 */
import main.java.*;

public class TeleporterUnit extends Unit {

    public TeleporterUnit(Position pos,Map m) {
        super(pos, m);
        super.health = 20;
        super.price = 50;
        super.speed = 50;
        super.name = "GroundUnit";
        super.pos = pos;
        super.flying = false;
    }
}
