package main.java;

import main.java.unit.AirUnit;
import main.java.unit.GroundUnit;
import main.java.unit.TeleporterUnit;

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
    private int nextId;

    public Shop(User user, Game game) {
        this.shopUser = user;
        this.currentGame = game;
        this.nextId = 0;
    }

    /**
     * A method for buying units.
     *
     * @param unitId the id of the unit to buy.
     */
    public void buyUnit(int unitId){
        switch (unitId){
            case 1: this.currentGame.addUnit(new AirUnit(new Position(0,0),nextId));
                break;
            case 2: this.currentGame.addUnit(new GroundUnit(new Position(0,0),nextId));
                break;
            case 3: this.currentGame.addUnit(new TeleporterUnit(new Position(0,0),nextId));
                break;
            default: throw new IllegalStateException("There is no unit with the id of " + nextId);
        }
        nextId++;
    }

    /**
     *
     * @param unitId the id of the unit.
     *
     * @return returns true if the user has enough money to buy a unit and false if not.
     */
    public boolean canBuyUnit(int unitId){
        switch (unitId){
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
            default: throw new IllegalStateException("There is no unit with the id of " + nextId);
        }
        return false;
    }
}
