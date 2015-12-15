package main.java;

import main.java.GUI.CLayout;
import main.java.GUI.MapInformation;
import main.java.tile.Tile;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class:       Controller
 * <p/>
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        12/9/15
 */
public class Controller implements MapInformation {
    private MapFactory factory;

    public Controller (MapFactory factory) {
        this.factory = factory;
    }

    @Override
    public ArrayList<String> getLevelNames() {
        return factory.getMapNames();
    }

    @Override
    public HashMap<Position, Tile> getMap(String s) {
        return factory.loadMap(s).getCompleteMap();
    }

    public static void main(String[] args) {
        MapFactory f = null;
        try {
            f = new MapFactory("main/resources/levels.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        Controller c = new Controller(f);

        new CLayout(c);
    }
}
