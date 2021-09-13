package Guitar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SearchTI {

	private static Inventory inventory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { 
		inventory = new Inventory();
	    FindGuitarTester.initializeInventory(inventory);
	}

	@Test
	public void testSpecificGuitar() {
	    Guitar whatCustomerWant = new Guitar("", 0, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
	    List matchingGuitars = (List) inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertEquals(2, matchingGuitars.size());    
	}
	
	@Test
	public void testElectricGuitar() {
	    Guitar whatCustomerWant = new Guitar("", 0, null, "", Type.ELECTRIC, null, null);
	    List matchingGuitars = (List) inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertEquals(5, matchingGuitars.size());    
	}
	
	@Test
	public void testAcousticGuitar() {
	    Guitar whatCustomerWant = new Guitar("", 0, null, null, Type.ACOUSTIC, null, null);
	    List matchingGuitars = (List) inventory.search(whatCustomerWant);
	    
	    Assert.assertNotNull(matchingGuitars);
	    Assert.assertEquals(6, matchingGuitars.size());    
	}
	
	@Test
	public void testNoMachingGuitar() {
		Guitar whatCustomerWant = new Guitar("", 0, Builder.COLLINGS, null, Type.ACOUSTIC, null, Wood.BRAZILIAN_ROSEWOOD);
		List matchingGuitars = (List) inventory.search(whatCustomerWant);

		Assert.assertNotNull(matchingGuitars);
		Assert.assertTrue(matchingGuitars.isEmpty());
	}

}
