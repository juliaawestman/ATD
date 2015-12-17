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
import main.java.tile.Teleporter;
import main.java.tile.Tile;

public class TeleporterUnit extends Unit {

    private static int price = 50;
    private static URL imgUrl = Unit.class.getResource("../../resources/teleporterUnit.png");
    private boolean hasTeleStart;
    private int telePlacedTime;
    private Teleporter teleportStart = null;
    private Teleporter teleportEnd = null;

    public TeleporterUnit(Position pos, int id) {
        super(pos, id);
        super.health = 20;
        super.price = this.price;
        super.speed = 50;
        super.name = "teleporterUnit";
        super.pos = pos;
        super.flying = false;
        super.imagePath = imgUrl;
        super.teleporter = true;
        super.isClickableUnit = true;
    }

    /**
     * Has the unit placed a teleportation start?
     */
    private boolean hasTeleStart(){
        return hasTeleStart;
    }
    public void setHasTeleStart(boolean hasTeleStart, int telePlacedTime){
        this.hasTeleStart = hasTeleStart;
        this.telePlacedTime = telePlacedTime;
    }

    /**
     * Returns a teleport tile to place in the map.
     * @return
     */
    @Override
    public Tile click(){
        /*Make a teleportStart*/
        if(this.teleportStart == null){
            try {
                this.teleportStart = new Teleporter(PositionConverter.unitPosConverter(this.getPosition()));
                return this.teleportStart;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else if(this.teleportEnd == null){
            try {
                this.teleportEnd = new Teleporter(PositionConverter.unitPosConverter(this.getPosition()));
                this.teleportStart.setEndTelePos(this.teleportEnd.getPosition());
                return this.teleportEnd;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getPrice() {
        return price;
    }
    public static URL getImg(){
        return imgUrl;
    }


}
