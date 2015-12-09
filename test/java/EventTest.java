package test.java;

import main.java.GraphicEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isak Hjelt, dv14iht
 */
public class EventTest {

    /**
     * Test of getId method, of class GraphicEvent.
     */
    @Test
    public void testGetId() {
        GraphicEvent instance = new GraphicEvent(333, null);
        
        assertEquals(instance.getId(), 333);
    }

    /**
     * Test of getImage method, of class GraphicEvent.
     */
    @Test
    public void testGetImage() {
    }
    
}
