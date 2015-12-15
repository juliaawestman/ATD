package main.java.GUI;

import main.java.Position;
import main.java.tile.Tile;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Joakim on 2015-12-09.
 */
public interface MapInformation {

    public ArrayList<String> getLevelNames();

    public HashMap<Position, Tile> getMap(String s);
}
