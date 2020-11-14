package level.field.position.impl;

import level.field.position.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionXYTest {

    @Test
    public void testPrintPosition() throws Exception {
        Position position = new PositionXYImpl(1, 0);
        assertEquals("XY_Coordinates=={1:0}", position.printPosition());
    }

    @Test(expected = Exception.class)
    public void testExceptionThrown_whenXYPositionIsConstructingWithXLessThanZero() throws Exception {
        Position position = new PositionXYImpl(-2, 1);
        position.printPosition();
    }

    @Test(expected = Exception.class)
    public void testExceptionThrown_whenXYPositionIsConstructingWithYLessThanZero() throws Exception {
        Position position = new PositionXYImpl(4, -1);
        position.printPosition();
    }

    @Test(expected = Exception.class)
    public void testExceptionThrown_whenXYPositionIsConstructingWithBothCoordinatesLessThanZero() throws Exception {
        Position position = new PositionXYImpl(-14, -11);
        position.printPosition();
    }
}