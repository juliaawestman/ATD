package src.test.java;

import org.junit.Test;
import src.main.java.TileMap;

public class tileMapTest {
    TileMap map;

    @Test
    public void shouldFailReadBecauseMapFileIncorrect() throws Exception {
        map = new TileMap();
        map.readMap("./src/test/resources/testMap.xml");

    }

}