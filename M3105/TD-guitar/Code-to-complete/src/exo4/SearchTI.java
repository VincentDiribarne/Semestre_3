package exo4;

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
	    GuitarSpec whatCustomerWant = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);
	    List matchingGuitars = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertEquals(2, matchingGuitars.size());    
	}
	
	@Test
	public void testElectricGuitar() {
		GuitarSpec whatCustomerWant = new GuitarSpec(null, "", Type.ELECTRIC, GuitarSpec.NO_PREF_NUM_STRINGS, null, null);
	    List matchingGuitars = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertEquals(5, matchingGuitars.size());    
	}
	
	@Test
	public void testAcousticGuitar() {
		GuitarSpec whatCustomerWant = new GuitarSpec( null, null, Type.ACOUSTIC, GuitarSpec.NO_PREF_NUM_STRINGS, null, null);
	    List matchingGuitars = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertEquals(6, matchingGuitars.size());    
	}
	
	@Test
	public void testNoMachingGuitar() {
		GuitarSpec whatCustomerWant = new GuitarSpec(Builder.COLLINGS, null, Type.ACOUSTIC, 12, null, Wood.BRAZILIAN_ROSEWOOD);
	    List matchingGuitars = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertTrue(matchingGuitars.isEmpty());    
	}
	
	@Test
	public void testMachingGuitarWith12strings() {
		GuitarSpec whatCustomerWant = new GuitarSpec(null, null, null, 12, null, null);
	    List matchingGuitars = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertEquals(2, matchingGuitars.size());      
	}
	
	@Test
	public void testMachingGuitarWith6strings() {
		GuitarSpec whatCustomerWant = new GuitarSpec(null, null, null, 6, null, null);
	    List matchingGuitars = inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertEquals(9, matchingGuitars.size());      
	}

}
