/**
 * Class: Game
 *
 * Author: Isak Hjelt
 *
 * cs-user: dv14iht
 *
 * Date: 2015-11-30
 */

package src.main.java;

import java.util.HashMap;

public class Game {
    private final int timeOfGame = 0;
    //----------------------------private User user;
    //----------------------------private TileMap map;
    private final int waveNr = 1;
    private final HashMap Units = new HashMap();
    private final HashMap TOwer = new HashMap();
    private final int nrOfWaves;
    private final int winCondition;
    //----------------------------private Shop gameShop;
    
    public Game(int nrOfWaves, int winCondition) {
        this.nrOfWaves = nrOfWaves;
        this.winCondition = winCondition;
    }
    public void update(){
        
    }
    public void readMap(String mapName){
        
    }
    
    
}
