package src.tests.java;

import org.junit.Test;
import src.main.java.tileMap;

public class tileMapTest {
    tileMap map;

    @Test
    public void shouldFailReadBecauseMapFileIncorrect() throws Exception {
        map = new tileMap();
        map.readMap("../testMap.xml");
    }

}