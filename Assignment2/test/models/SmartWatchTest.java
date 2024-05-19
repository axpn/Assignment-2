package models;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class SmartWatchTest {
    private SmartWatch validSmartWatch;
    private SmartWatch invalidSmartWatch;



    @After
    public void tearDown() {
        validSmartWatch=invalidSmartWatch=null;
    }

    @Before
    public void setUp() {
        Manufacturer manufacturer = new Manufacturer("Samsung", 333);
        Manufacturer invalidManufacturer = new Manufacturer("ABCDEFGHIJKLMNOPQRSTU", 0);
        validSmartWatch = new SmartWatch("Galaxy Tab S7", 799.99, manufacturer, "123456", "Snapdragon 865", "qqq", "LCD");
        invalidSmartWatch = new SmartWatch("Galaxy Tab S7 version 1 c.09462b", 19.0, invalidManufacturer, "12345678910", "Snapdragon 8655678920", "qqq", "LCD");

    }


    @Test
    public void testValidDisplayType() {
        assertEquals("LCD", validSmartWatch.getDisplayType());

    }

    @Test
    public void testInvalidDisplayType() {
        assertEquals("LCD", invalidSmartWatch.getDisplayType()); // Invalid OS should default to "Windows OS"
    }
    @Test
    public void testSetValidOperatingSystem() {
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("iPad");
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("Android");
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("Chrome");
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("Windows");
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("Amazon Fire");
        assertEquals("LCD Fire", validSmartWatch.getDisplayType());

    }

    @Test
    public void testSetInvalidOperatingSystem() {
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("iPad12 OS");
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("Android OS");
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("Chrome OS");
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("Windows OS");
        assertEquals("LCD", validSmartWatch.getDisplayType());
        validSmartWatch.setDisplayType("Amazon Fire OS");
        assertEquals("LCD", validSmartWatch.getDisplayType());
    }
    @Test
    public void testToString() {
        String expected = "DisplayType: LCD";
        assertTrue( validSmartWatch.toString().contains(expected));
        expected = "DisplayType: LCD";
        assertTrue( invalidSmartWatch.toString().contains(expected));

    }

}


