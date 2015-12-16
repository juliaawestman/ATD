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

    private static int price = 30;
    private static URL imgUrl = Unit.class.getResource("../../resources/airUnit.png");

    public AirUnit(Position pos, int id) {
        super(pos, id);
        super.health = 20;
        super.price = this.price;
        super.speed = 45;
        super.name = "AirUnuit";
        super.pos = pos;
        super.flying = true;
        super.imagePath = imgUrl;

    }

    public static int getPrice() {
        return price;
    }

    public static URL getImg(){
            return imgUrl;
    }
}
