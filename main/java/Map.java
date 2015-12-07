package main.java;

import main.java.tile.PathTile;
import main.java.tile.Tile;
import main.java.tile.TowerTile;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Class:       Map
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        12/2/15
 */
public class Map {
    private HashMap<Position, Tile> pathTiles;
    private HashMap<Position, Tile> towerTiles;
    private String name;
    private int waves;
    private int winScore;

    protected Map(){
        pathTiles = new HashMap<Position, Tile>();
        towerTiles = new HashMap<Position, Tile>();
    }

    /**
     * Adds a tile to the map.
     * @param t TODO
     */
    protected void addTile(Tile t){
        if (PathTile.class.isAssignableFrom(t.getClass())) {
            pathTiles.put(t.getPosition(), t);
        } else if (TowerTile.class.isAssignableFrom(t.getClass())){
            towerTiles.put(t.getPosition(), t);
        }
    }

    /**
     * Returns the tile at a specified position if there is any.
     *
     * @param p the Position which to check.
     * @return the Tile of the position
     */
    public Tile getTileAt(Position p){
        Tile tile = pathTiles.get(p);

        if (tile == null){
            tile = towerTiles.get(p);
        }

        return tile;
    }

    public void printMap(){
        String line = "";
        for (int row = 1; row <= 10; row++){
            for (int col = 1; col <= 10; col++){
                if(getTileAt(new Position(row, col)) != null){
                    line = line + "*";
                }else {
                    line = line + "0";
                }
            }
            System.out.println(line);
        }
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

    /**
     * Sets the name of the map.
     *
     * @param name the name of the map
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the number of waves the level will continue for.
     *
     * @param waves the number of waves the level will be
     */
    protected void setWaves(int waves) {
        this.waves = waves;
    }

    /**
     * Sets the score needed to be achieved for completing the level.
     *
     * @param winScore the score needed to win
     */
    protected void setWinScore(int winScore) {
        this.winScore = winScore;
    }
}
