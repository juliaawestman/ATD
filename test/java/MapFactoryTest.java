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
        MapFactory factory = new MapFactory("main/resources/test.xml");
        Map myMap = factory.makeMap("MapWithOnlyOneTowerTile");
        myMap.printMap();
        Tile t = myMap.getTileAt(new Position(1, 1));
        assertNotNull(t);
    }

    @Test
    public void shouldMakeMapWithDifferentTileTypes() throws Exception {
        MapFactory factory = new MapFactory("main/resources/test.xml");
        Map myMap = factory.makeMap("MapWithDifferentTileTypes");
        myMap.printMap();
        Tile t = myMap.getTileAt(new Position(1, 2));
        assertNotNull(t);
    }

}