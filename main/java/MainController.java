package main.java;

import main.java.GUI.CLayout;
import main.java.GUI.MapInformation;
import main.java.GUI.UserInformation;
import main.java.tile.Tile;
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

/*  TODO image resizing
 *  TODO Fix so that all towers show up in the image
 *  TODO Fix so that all towers shoot
 *  TODO Test the map Joy a lot: it generates a lot of exceptions
 */

public class MainController extends TimerTask implements MapInformation, UserInformation {
    private Renderer renderer;
    private CLayout gui;
    private Game game;
    private MapFactory factory;
    private Timer timer;
    private Shop shop;
    private CurrentGraphicState graphicState;

    public MainController(){
        createFactory();
        gui = new CLayout(this, this);
        int dimension = gui.getTileSize()*12;
        renderer = new Renderer(dimension, dimension);
        game = null;
        timer = new Timer();
    }

    @Override
    public void run() {
        game.update();
        renderer.drawImage(graphicState.getCurrentGraphicState());
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
        startWithUpdateInterval(5);
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
        graphicState = game.getGraphicState();

        shop.buyUnit(2);
        //shop.buyUnit(1);
        start();
        return map.getCompleteMap();
    }

    public static void main(String[] args) {
        MainController c = new MainController();
    }

    @Override
    public void buyUnit(int i) {
        shop.buyUnit(i);
    }

    @Override
    public boolean canBuyUnit(int i) {
        return shop.canBuyUnit(i);
    }

    @Override
    public String getUnitName(int i) {
        return null;
    }


    @Override
    public void updateUsername(String s) {

    }

    @Override
    public boolean gameOver() {
        return false;
    }

    @Override
    public void hasClicked(int x, int y) {

    }
}
