package models;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class SmartBandTest {
    private SmartBand validSmartBand;
    private SmartBand invalidSmartBand;



    @After
    public void tearDown() {
        validSmartBand=invalidSmartBand=null;
    }

    @Before
    public void setUp() {
        Manufacturer manufacturer = new Manufacturer("Samsung", 333);
        Manufacturer invalidManufacturer = new Manufacturer("ABCDEFGHIJKLMNOPQRSTU", 0);
        validSmartBand = new SmartBand("Galaxy Tab S7", 799.99, manufacturer, "123456", "Snapdragon 865", "qqq", true);
        invalidSmartBand = new SmartBand("Galaxy Tab S7 version 1 c.09462b", 19.0, invalidManufacturer, "12345678910", "Snapdragon 8655678920", "qqq", false);

    }


    @Test
    public void testValidisHeartRateMonitor() {
        assertEquals(true, validSmartBand.isHeartRateMonitor());

    }

    @Test
    public void testInvalidisHeartRateMonitor() {
        assertEquals(false, invalidSmartBand.isHeartRateMonitor());
    }

    @Test
    public void testToString() {
        String expected = "Operating System: Android, Insurance Premium: €7.99";
        assertTrue( validSmartBand.toString().contains(expected));
        expected = "Operating System: Windows, Insurance Premium: €0.2";
        assertTrue( invalidSmartBand.toString().contains(expected));

    }

}

