package test.java;

import org.xml.sax.SAXParseException;
import org.junit.Test;
import main.java.TileMap;

import java.io.FileNotFoundException;

public class TileMapTest {
    TileMap map;

    @Test (expected = SAXParseException.class)
    public void shouldFailBecauseMapFileIncorrect() throws Exception {
        new TileMap("test/resources/testMapFail.xml");
    }

    @Test (expected = FileNotFoundException.class)
    public void shouldFailBecauseNoFile() throws Exception {
        new TileMap("test/resources/testMapNoExist.xml");
    }

}