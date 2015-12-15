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
import java.net.MalformedURLException;
import java.net.URL;
import main.java.*;

public class TeleporterUnit extends Unit {

    private static int price = 50;

    public TeleporterUnit(Position pos, int id) {
        super(pos, id);
        super.health = 20;
        super.price = this.price;
        super.speed = 50;
        super.name = "GroundUnit";
        super.pos = pos;
        super.flying = false;
        super.imagePath = this.getClass().getResource("teleporterUnit.png");
    }
    public static int getPrice() {
        return price;
    }
}
