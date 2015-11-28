package src;

import org.junit.Test;
import src.unit.*;

import static org.junit.Assert.*;

public class TowerTest {
    TestUnit u;
    TestTower t;


    /* ********** TESTS FOR: withingRange(Unit) ********** */
    @Test
    public void shouldReturnTrueForSamePos() throws Exception {
        unitAndTower(new Position(10, 10), new Position(10, 10));
        assertTrue(t.withinRange(u));
    }

    @Test
    public void shouldReturnTrueForWithinRangeNorth() throws Exception {
        unitAndTower(new Position(10, 0), new Position(10, 10));
        assertTrue(t.withinRange(u));
    }

    @Test
    public void shouldReturnTrueForWithinRangeDiagonally() throws Exception {
        unitAndTower(new Position(15, 15), new Position(10, 10));
        assertTrue(t.withinRange(u));
    }

    @Test
    public void shouldReturnFalseForOutOfRangeToNorth() throws Exception {
        unitAndTower(new Position(10, 0), new Position(10, 11));
        assertFalse(t.withinRange(u));
    }

    @Test
    public void shouldReturnFalseForOutOfRangeDiagonally() throws Exception {
        unitAndTower(new Position(2, 2), new Position(10, 10));
        assertFalse(t.withinRange(u));
    }

    @Test
    public void shouldReturnFalseForOutOfRangeToSouth() throws Exception {
        unitAndTower(new Position(20, 21), new Position(10, 10));
        assertFalse(t.withinRange(u));
    }
    /* ****************************************** */

    /* ********** TESTS FOR: attack() ********** */
    @Test
    public void shouldReturnTrueForLivingTargetWithinRange() throws Exception {

    }

    /* ***************************************** */


    /* ********** Helping methods ********** */
    private void unitAndTower(Position unitPos, Position towerPos) {
        u = new TestUnit(unitPos);
        t = new TestTower(towerPos);
    }



    /* ********** Classes for testing ********** */
    protected static class TestUnit extends Unit {
        public TestUnit(Position pos){
            super(pos, Direction.NORTH);
        }
    }

    protected static class TestTower extends Tower {
        public TestTower(Position pos){
            super(10, 10, 10, true, true, pos);
        }
    }
}