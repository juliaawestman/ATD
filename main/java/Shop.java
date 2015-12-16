package main.java;

import main.java.unit.AirUnit;
import main.java.unit.GroundUnit;
import main.java.unit.TeleporterUnit;

import java.net.URL;

/**
 * Class: Game
 *
 * Author: Isak Hjelt
 *
 * cs-user: dv14iht
 *
 * Date: 2015-12-15
 */
public class Shop {

    private User shopUser;
    private Game currentGame;

    public Shop(User user, Game game) {
        this.shopUser = user;
        this.currentGame = game;
    }

    /**
     * A method for buying units.
     *
     * @param unitTypeId the id of the unit to buy.
     */
    public void buyUnit(int unitTypeId) {
        synchronized (this) {
            switch (unitTypeId) {
                case 1:
                    this.currentGame.addUnit(new AirUnit(new Position(0, 0), currentGame.getNextObjectId()));
                    shopUser.decreaseCredits(AirUnit.getPrice());
                    break;
                case 2:
                    this.currentGame.addUnit(new GroundUnit(new Position(0, 0), currentGame.getNextObjectId()));
                    shopUser.decreaseCredits(GroundUnit.getPrice());
                    break;
                case 3:
                    this.currentGame.addUnit(new TeleporterUnit(new Position(0, 0), currentGame.getNextObjectId()));
                    shopUser.decreaseCredits(TeleporterUnit.getPrice());
                    break;
                default:
                    throw new IllegalStateException("There is no unit with the id of " + unitTypeId);
            }
        }
    }


    /**
     *
     * @param unitTypeId the id of the unit.
     *
     * @return returns true if the user has enough money to buy a unit and false if not.
     */
    public boolean canBuyUnit(int unitTypeId){
        switch (unitTypeId){
            case 1:
                if(this.shopUser.getCredits() >= AirUnit.getPrice()){
                    return true;
                }
                break;
            case 2:
                if(this.shopUser.getCredits() >= GroundUnit.getPrice()){
                    return true;
                }
                break;
            case 3:
                if(this.shopUser.getCredits() >= TeleporterUnit.getPrice()){
                    return true;
                }
                break;
            default: throw new IllegalStateException("There is no unit with the id of " + unitTypeId);
        }
        return false;
    }
    /**
     *
     * @param unitTypeId the id of the unit.
     *
     * @return returns a URL for the specified unit type.
     */
    public URL getUnitImg(int unitTypeId){
        switch (unitTypeId){
            case 1:
                AirUnit.getImg();
                break;
            case 2:
                GroundUnit.getImg();
                break;
            case 3:
                TeleporterUnit.getImg();
                break;
            default: throw new IllegalStateException("There is no unit with the id of " + unitTypeId);
        }
        return null;
    }
}
