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
    private static URL imgUrl = Unit.class.getResource("../../resources/teleporterUnit.png");

    public TeleporterUnit(Position pos, int id) {
        super(pos, id);
        super.health = 20;
        super.price = this.price;
        super.speed = 50;
        super.name = "teleporterUnit";
        super.pos = pos;
        super.flying = false;
        super.imagePath = imgUrl;
    }
    public static int getPrice() {
        return price;
    }
    public static URL getImg(){
        return imgUrl;
    }
}
