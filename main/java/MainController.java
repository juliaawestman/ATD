package main.java;

import main.java.GUI.CLayout;
import main.java.GUI.MapInformation;
import main.java.tile.Tile;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

/**
 * Class:       MainController
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        12/15/15
 */

public class MainController implements MapInformation{
    private Renderer renderer;
    private CLayout gui;
    private Game game;
    private MapFactory factory;
    private Timer timer;

    public MainController(){
        createFactory();
        gui = new CLayout(this);
        int dimension = gui.getTileSize()*12;
        renderer = new Renderer(dimension, dimension);
        game = null;
        timer = new Timer();
    }

    /**
     * Starts the game with an specified update interval
     * @param interval the update interval in milliseconds
     */
    public void startWithUpdateInterval(long interval){
        timer.schedule(null, interval, interval);
    }

    /**
     * Starts the game with an update interval of 1/10 of a second
     */
    public void start(){
        startWithUpdateInterval(100);
    }

    /**
     * Creates a factory containing all the maps.
     */
    private void createFactory() {
        try {
            factory = new MapFactory("main/resources/levels.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            //TODO exception handling
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> getLevelNames() {
        return factory.getMapNames();
    }

    @Override
    public HashMap<Position, Tile> getMap(String s) {
        Map map = factory.loadMap(s);
        game = new Game(map);
        start();
        return map.getCompleteMap();
    }
}
