package movements;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovementTypesTest {

    @Test
    public void testGet() {
        assertEquals(MovementTypes.EAST, MovementTypes.get("E"));
    }

    @Test
    public void testGetReturnsNull() {
        assertNull(MovementTypes.get("H"));
    }

    @Test
    public void testGetReturnsNotNull() {
        assertNotNull(MovementTypes.get("E"));
        assertNotNull(MovementTypes.get("N"));
        assertNotNull(MovementTypes.get("S"));
        assertNotNull(MovementTypes.get("O"));
    }

    @Test
    public void testGetMovement() {
        MovementTypes mt = MovementTypes.NORTH;
        assertEquals("N", mt.getMovement());
    }

}