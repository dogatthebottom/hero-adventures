package level.field.background;

import org.junit.Test;

import static org.junit.Assert.*;

public class BackgroundTypesTest {

    @Test
    public void testGetBackgroundType() {
        BackgroundTypes bt=BackgroundTypes.SPACE;
        assertEquals(" ",bt.getBackgroundType());
    }

    @Test
    public void testGet() {
        assertEquals(BackgroundTypes.FOREST,BackgroundTypes.get("#"));
    }

    @Test
    public void testGetReturnsNull(){
        assertNull(BackgroundTypes.get("ffff"));
    }

    @Test
    public void testGetReturnsNotNull(){
        assertNotNull(BackgroundTypes.get("#"));
        assertNotNull(BackgroundTypes.get(" "));
    }
}