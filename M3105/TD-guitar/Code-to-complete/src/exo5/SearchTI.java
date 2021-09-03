package exo5;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;


public class SearchTI {

	private static Inventory inventory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { 
		inventory = new Inventory();
	    FindGuitarTester.initializeInventory(inventory);
	}

	@Test
	public void testSpecificGuitar() {
	    GuitarSpec whatCustomerWant = new GuitarSpec(Builder.FENDER, "Stratocastor", 6, Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(1, matchingInstruments.size());    
	}
	
	@Test
	public void testSpecificMandolin() {
		MandolinSpec whatCustomerWant = new MandolinSpec(Builder.FENDER, "Stratocastor", Style.A, Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(1, matchingInstruments.size());    
	}
	
	@Test
	public void testElectricGuitar() {
		GuitarSpec whatCustomerWant = new GuitarSpec(null, "", GuitarSpec.NO_PREF_NUM_STRINGS, Type.ELECTRIC, null, null);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(3, matchingInstruments.size());    
	}
	
	@Test
	public void testElectricMandolin() {
		MandolinSpec whatCustomerWant = new MandolinSpec(null, "", null, Type.ELECTRIC, null, null);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(2, matchingInstruments.size());    
	}
	
	@Test
	public void testAcousticGuitar() {
		GuitarSpec whatCustomerWant = new GuitarSpec( null, null, GuitarSpec.NO_PREF_NUM_STRINGS, Type.ACOUSTIC, null, null);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(5, matchingInstruments.size());    
	}
	
	@Test
	public void testAcousticMandolin() {
		MandolinSpec whatCustomerWant = new MandolinSpec( null, null, null, Type.ACOUSTIC, null, null);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(1, matchingInstruments.size());    
	}
	
	@Test
	public void testNoMachingGuitar() {
		GuitarSpec whatCustomerWant = new GuitarSpec(Builder.COLLINGS, null, 12, Type.ACOUSTIC, null, Wood.BRAZILIAN_ROSEWOOD);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertTrue(matchingInstruments.isEmpty());    
	}
	
	@Test
	public void testNoMachingMandolin() {
		MandolinSpec whatCustomerWant = new MandolinSpec(Builder.COLLINGS, null, Style.F, Type.ACOUSTIC, null, Wood.BRAZILIAN_ROSEWOOD);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertTrue(matchingInstruments.isEmpty());    
	}
	
	@Test
	public void testMachingGuitarWith12strings() {
		GuitarSpec whatCustomerWant = new GuitarSpec(null, null, 12, null, null, null);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(2, matchingInstruments.size());      
	}
	
	@Test
	public void testMachingGuitarWith6strings() {
		GuitarSpec whatCustomerWant = new GuitarSpec(null, null, 6, null, null, null);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(6, matchingInstruments.size());      
	}
	
	@Test
	public void testAstyleMandolin() {
		MandolinSpec whatCustomerWant = new MandolinSpec( null, null, Style.A, null, null, null);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(2, matchingInstruments.size());    
	}
	
	@Test
	public void testFstyleMandolin() {
		MandolinSpec whatCustomerWant = new MandolinSpec( null, null, Style.F, null, null, null);
	    List matchingInstruments = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingInstruments);
	    Assert.assertEquals(1, matchingInstruments.size());    
	}

}
