package test.java;

import main.java.Event;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isak Hjelt, dv14iht
 */
public class EventTest {

    /**
     * Test of getId method, of class Event.
     */
    @Test
    public void testGetId() {
        Event instance = new Event(333, null);
        
        assertEquals(instance.getId(), 333);
    }

    /**
     * Test of getImage method, of class Event.
     */
    @Test
    public void testGetImage() {
    }
    
}
