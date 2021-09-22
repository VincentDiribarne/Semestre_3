import Guitar.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

public class SearchTi_Exo5 {

    private static Inventory inventory;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        inventory = new Inventory();
        FindGuitarTester.initializeInventory(inventory);
    }

    @Test
    public void testSpecificGuitar() {
        GuitarSpec whatCustomerWant = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(1, matchingInstruments.size());
    }

    @Test
    public void testSpecificMandolin() {
        MandolinSpec whatCustomerWant = new MandolinSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Style.A, Wood.ALDER, Wood.ALDER);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(1, matchingInstruments.size());
    }

    @Test
    public void testElectricGuitar() {
        GuitarSpec whatCustomerWant = new GuitarSpec(null, "", Type.ELECTRIC, GuitarSpec.NO_PREF_NUM_STRINGS, null, null);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(3, matchingInstruments.size());
    }

    @Test
    public void testElectricMandolin() {
        MandolinSpec whatCustomerWant = new MandolinSpec(null, "", Type.ELECTRIC, null, null, null);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(2, matchingInstruments.size());
    }

    @Test
    public void testAcousticGuitar() {
        GuitarSpec whatCustomerWant = new GuitarSpec( null, null, Type.ACOUSTIC, GuitarSpec.NO_PREF_NUM_STRINGS, null, null);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(5, matchingInstruments.size());
    }

    @Test
    public void testAcousticMandolin() {
        MandolinSpec whatCustomerWant = new MandolinSpec( null, null, Type.ACOUSTIC, null, null, null);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(1, matchingInstruments.size());
    }

    @Test
    public void testNoMachingGuitar() {
        GuitarSpec whatCustomerWant = new GuitarSpec(Builder.COLLINGS, null, Type.ACOUSTIC, 12, null, Wood.BRAZILIAN_ROSEWOOD);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertTrue(matchingInstruments.isEmpty());
    }

    @Test
    public void testNoMachingMandolin() {
        MandolinSpec whatCustomerWant = new MandolinSpec(Builder.COLLINGS, null, Type.ACOUSTIC, Style.F, null, Wood.BRAZILIAN_ROSEWOOD);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertTrue(matchingInstruments.isEmpty());
    }

    @Test
    public void testMachingGuitarWith12strings() {
        GuitarSpec whatCustomerWant = new GuitarSpec(null, null, null, 12, null, null);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(2, matchingInstruments.size());
    }

    @Test
    public void testMachingGuitarWith6strings() {
        GuitarSpec whatCustomerWant = new GuitarSpec(null, null, null, 6, null, null);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(6, matchingInstruments.size());
    }

    @Test
    public void testAstyleMandolin() {
        MandolinSpec whatCustomerWant = new MandolinSpec( null, null, null, Style.A, null, null);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(2, matchingInstruments.size());
    }

    @Test
    public void testFstyleMandolin() {
        MandolinSpec whatCustomerWant = new MandolinSpec( null, null, null, Style.F, null, null);
        List matchingInstruments = inventory.search(whatCustomerWant);

        Assert.assertNotNull(matchingInstruments);
        Assert.assertEquals(1, matchingInstruments.size());
    }

}
