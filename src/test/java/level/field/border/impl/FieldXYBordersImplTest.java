package level.field.border.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldXYBordersImplTest {

    @Test
    public void testDrawBorders() {
        FieldXYBordersImpl fieldXYBordersImpl =new FieldXYBordersImpl();
        fieldXYBordersImpl.setEastBorder(true);
        assertEquals("Borders_XY=={N:false E:true S:false W:false}", fieldXYBordersImpl.drawBorders());
    }
}