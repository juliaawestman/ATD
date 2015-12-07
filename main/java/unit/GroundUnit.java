package main.java.unit;


/*
 * Class: GroundUnit

 * Author: Isak Hjelt

 * cs-user: dv14iht

 * Date: 2015-11-26
 */
import main.java.*;

public class GroundUnit extends main.java.unit.Unit {

    public GroundUnit(Position pos,Map m) {

        super(pos,m);
        super.health = 30;
        super.price = 30;
        super.speed = 30;
        super.name = "GroundUnit";
        super.pos = pos;
        super.flying = false;
    }

}