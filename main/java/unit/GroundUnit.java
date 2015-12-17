package main.java.unit;

/*
 * Class: GroundUnit

 * Author: Isak Hjelt

 * cs-user: dv14iht

 * Date: 2015-11-26
 */
import java.net.URL;
import main.java.*;

public class GroundUnit extends main.java.unit.Unit {

    private static int price = 30;
    private static URL imgUrl = Unit.class.getResource("../../resources/groundUnit.png");

    public GroundUnit(Position pos, int id) {

        super(pos, id);
        super.health = 150;
        super.price = price;
        super.speed = 47;
        super.name = "GroundUnit";
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
