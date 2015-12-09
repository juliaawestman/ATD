package test.java;

import main.java.Map;
import main.java.Position;
import main.java.tile.Tile;
import org.xml.sax.SAXParseException;
import org.junit.Test;
import main.java.MapFactory;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertNotNull;

public class MapFactoryTest {

    @Test (expected = SAXParseException.class)
    public void shouldFailBecauseMapFileIncorrect() throws Exception {
        new MapFactory("test/resources/testMapFail.xml");
    }

    @Test (expected = FileNotFoundException.class)
    public void shouldFailBecauseNoFile() throws Exception {
        new MapFactory("test/resources/testMapNoExist.xml");
    }

    @Test
    public void shouldMakeMapWithOneTile() throws Exception {
        MapFactory factory = new MapFactory("test/resources/test.xml");
        Map myMap = factory.loadMap("MapWithOnlyOneTowerTile");
        myMap.printMap();
        Tile t = myMap.getTileAt(new Position(1, 1));
        assertNotNull(t);
    }

    @Test
    public void shouldMakeMapWithDifferentTileTypes() throws Exception {
        MapFactory factory = new MapFactory("test/resources/test.xml");
        Map myMap = factory.loadMap("MapWithDifferentTileTypes");
        myMap.printMap();
        Tile t = myMap.getTileAt(new Position(1, 2));
        assertNotNull(t);
    }

    @Test
    public void shouldAcceptDefaultMapZiggZagg() throws Exception {
        MapFactory factory = new MapFactory("main/resources/defaultMaps.xml");
        Map myMap = factory.loadMap("ZiggZagg");
        myMap.printMap();
    }

    @Test
    public void shouldAcceptDefaultMapSquare() throws Exception {
        MapFactory factory = new MapFactory("main/resources/defaultMaps.xml");
        Map myMap = factory.loadMap("Square");
        myMap.printMap();
    }

}