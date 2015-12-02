package main.java;

import main.java.tile.Tile;

import java.awt.*;
import java.util.HashMap;

/**
 * Class:       Map
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        12/2/15
 */
public class Map {
    private HashMap<Position, Tile> tiles;
    private String name;
    private int waves;
    private int winScore;

    protected Map(){
        tiles = new HashMap<Position, Tile>();
    }

    /**
     * Adds a tile to the map.
     * @param t TODO
     */
    protected void addTile(Tile t){
        tiles.put(t.getPosition(), t);
    }

    /**
     * Returns the tile at a specified position if there is any.
     *
     * @param p the Position which to check.
     * @return the Tile of the position
     */
    public Tile getTileAt(Position p){
        return tiles.get(p);
    }

    /**
     * Returns the name of the map.
     *
     * @return the name of the map
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of waves that will be sent.
     *
     * @return the number of waves that will be sent.
     */
    public int getWaves() {
        return waves;
    }

    /**
     * Returns the score needed to win the level.
     *
     * @return the score needed to win the level.
     */
    public int getWinScore() {
        return winScore;
    }
}
