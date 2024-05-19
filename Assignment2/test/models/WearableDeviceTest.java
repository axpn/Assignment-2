package models;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WearableDeviceTest {
    private WearableDevice validWearable,invalidWearable;

    @Before
    public void setUp() {
        Manufacturer manufacturer = new Manufacturer("Apple",20);
        Manufacturer invalidManufacturer = new Manufacturer("AAAAA",1);
        validWearable = new SmartWatch("Apple Watch Ultra 2",6499.0,manufacturer,"11","49mm","Titanium","Online");
        invalidWearable = new SmartWatch("Apple Watch Ultal",99.0,invalidManufacturer,"999","10mm","iron","xx");
    }

    @After
    public void tearDown() {
        validWearable = invalidWearable = null;
    }

    @Test
    public void getSize() {
        assertEquals("49mm",validWearable.getSize());
        assertEquals("199999mm",invalidWearable.getSize());
    }

    @Test
    public void setSize() {
        validWearable.setSize("49mm");
        assertEquals("49mm",validWearable.getSize());
        validWearable.setSize("19999mm");
        assertEquals("49mm",validWearable.getSize());
    }

    @Test
    public void getMaterial() {
        assertEquals("Titanium",validWearable.getMaterial());
        assertEquals("iron",validWearable.getMaterial());
    }

    @Test
    public void setMaterial() {
        validWearable.setMaterial("Titanium");
        assertEquals("Titanium",validWearable.getMaterial());
        validWearable.setMaterial("iron");
        assertEquals("Titanium",validWearable.getMaterial());
    }

    @Test
    public void testToString() {
        String expected = "Size: 49mm, Material: Titanium";
        assertTrue( validWearable.toString().contains(expected));
        expected = "Size: 19999mm, Material: Titanium";
        assertTrue( invalidWearable.toString().contains(expected));
    }
}