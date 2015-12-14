package main.java.unit;


/*
 * Class: AirUnit

 * Author: Isak Hjelt

 * cs-user: dv14iht

 * Date: 2015-11-26
 */
import java.net.MalformedURLException;
import java.net.URL;
import main.java.*;

public class AirUnit extends main.java.unit.Unit {
    
    public AirUnit(Position pos, int id) {
        super(pos, id);
        super.health = 20;
        super.price = 30;
        super.speed = 45;
        super.name = "AirUnuit";
        super.pos = pos;
        super.flying = true;
        super.imagePath = this.getClass().getResource("airUnit");
    }
}
