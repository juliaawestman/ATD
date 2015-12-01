package src.test.java;

import org.junit.Test;
import src.main.java.tileMap;

public class tileMapTest {
    tileMap map;

    @Test
    public void shouldFailReadBecauseMapFileIncorrect() throws Exception {
        map = new tileMap();
        map.readMap("./src/test/resources/testMap.xml");

    }

}