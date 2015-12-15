package main.java;

import main.java.GUI.CLayout;
import main.java.GUI.MapInformation;
import main.java.tile.Tile;
import main.java.unit.GroundUnit;
import org.xml.sax.SAXException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class:       MainController
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        12/15/15
 */

public class MainController extends TimerTask implements MapInformation {
    private Renderer renderer;
    private CLayout gui;
    private Game game;
    private MapFactory factory;
    private Timer timer;
    private Shop shop;

    public MainController(){
        createFactory();
        gui = new CLayout(this);
        int dimension = gui.getTileSize()*12;
        renderer = new Renderer(dimension, dimension);
        game = null;
        timer = new Timer();
    }

    @Override
    public void run() {
        game.update();
        renderer.drawImage(game.getGraphicState().getCurrentGraphicState());
        BufferedImage img = renderer.getImage();
        gui.setBoardImage(img);
    }

    /**
     * Starts the game with an specified update interval
     * @param interval the update interval in milliseconds
     */
    public void startWithUpdateInterval(long interval){
        timer.schedule(this, interval, interval);
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
        shop = game.getShop();
        game.addUnit(new GroundUnit(new Position(27, 27), 1));
        start();
        return map.getCompleteMap();
    }

    public static void main(String[] args) {
        MainController c = new MainController();
        //c.start();
    }
}
