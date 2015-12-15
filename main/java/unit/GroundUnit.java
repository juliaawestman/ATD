package main.java.unit;

/*
 * Class: GroundUnit

 * Author: Isak Hjelt

 * cs-user: dv14iht

 * Date: 2015-11-26
 */
import java.net.MalformedURLException;
import java.net.URL;
import main.java.*;

public class GroundUnit extends main.java.unit.Unit {

    private static int price = 30;

    public GroundUnit(Position pos, int id) {

        super(pos, id);
        super.health = 100;
        super.price = price;
        super.speed = 35;
        super.name = "GroundUnit";
        super.pos = pos;
        super.flying = false;
        super.imagePath = this.getClass().getResource("../../resources/groundUnit.png");
    }

    public static int getPrice() {
        return price;
    }

}
