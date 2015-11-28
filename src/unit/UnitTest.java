package src.unit;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import src.Position;
import src.unit.AirUnit;
import src.unit.AirUnit;
import src.unit.Unit;
import src.unit.Unit;
import src.unit.Unit.Direction;
/**
 *
 * @author Isak Hjelt
 */
public class UnitTest {
    Unit instance;

    @Before
    public void setUp() {
        Position pos = new Position(11,22);
        this.instance = new AirUnit(pos, Direction.SOUTH);
        
    }

    /**
     * Test of move method, of class Unit.
     */
    @Test
    public void testMove() {
        Position tempPos = new Position(11,23);
        System.out.println("move");
        
        instance.move();
        instance.move();
        
        boolean expResult = true;
        boolean result = instance.getPosition().equals(tempPos);
             
        assertEquals(expResult, result);
    }

    /**
     * Test of isFlying method, of class Unit.
     */
    @Test
    public void testIsFlying() {
        System.out.println("isFlying");
        Unit instance = null;
        boolean expResult = false;
        boolean result = instance.isFlying();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Unit.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Unit instance = null;
        Position expResult = null;
        Position result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentPosition method, of class Unit.
     */
    @Test
    public void testSetCurrentPosition() {
        System.out.println("setCurrentPosition");
        Position pos = null;
        Unit instance = null;
        instance.setCurrentPosition(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirection method, of class Unit.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        Unit.Direction direction = null;
        Unit instance = null;
        instance.setDirection(direction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeDamage method, of class Unit.
     */
    @Test
    public void testTakeDamage() {
        System.out.println("takeDamage");
        int dmg = 0;
        Unit instance = null;
        instance.takeDamage(dmg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Unit.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        Unit instance = null;
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class UnitImpl extends Unit {

        public UnitImpl() {
            super(null, null);
        }
    }
    
}
