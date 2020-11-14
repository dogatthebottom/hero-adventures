package level.field.impl;

import level.field.background.BackgroundTypes;
import level.field.border.impl.FieldXYBordersImpl;
import level.field.position.impl.PositionXYImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldXYImplTest {
    private PositionXYImpl position ;
    private FieldXYBordersImpl borders;
    private BackgroundTypes background;
    private FieldXYImpl testFieldXY;


    public FieldXYImplTest() throws Exception {
     this.position=new PositionXYImpl(1, 1);
     this.borders=new FieldXYBordersImpl();
     this.background=BackgroundTypes.FOREST;
     this.testFieldXY=new FieldXYImpl(this.position,this.borders,this.background);
    }

    @Test(expected = NullPointerException.class)
    public void testExceptionThrown_whenFieldXYIsConstructingAndPositionIsNull() {
        FieldXYImpl fieldXY = new FieldXYImpl(null, borders, background);
    }

    @Test(expected = NullPointerException.class)
    public void testExceptionThrown_whenFieldXYIsConstructingAndBordersIsNull() {
        FieldXYImpl fieldXY = new FieldXYImpl(position, null, background);
    }

    @Test(expected = NullPointerException.class)
    public void testExceptionThrown_whenFieldXYIsConstructingAndBackgroundTypesIsNull() {
        FieldXYImpl fieldXY = new FieldXYImpl(position, borders, null);
    }

    @Test
    public void testPrintFieldPosition() throws Exception {
        assertEquals("XY_Coordinates=={1:1}",testFieldXY.printFieldPosition());
    }

    @Test
    public void testFieldBackground() {
        assertEquals("#",testFieldXY.drawFieldBackground());
    }

    @Test
    public void testDrawFieldBorders() {
        assertEquals("Borders_XY=={N:false E:false S:false W:false}",testFieldXY.drawFieldBorders());
    }


}