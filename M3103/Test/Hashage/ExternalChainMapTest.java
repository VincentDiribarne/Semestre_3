package Hashage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author rvenant
 */
public class ExternalChainMapTest extends OpenAdressMapTest {
    
	@Before
    @Override
    public void setUp() {
        this.map = TestedMapFactory.createExtChainMap(10);
    }
    
	@org.junit.Test
    @Override
    public void testPutMapComplete(){
        for(int i = 0; i < 10; i++){
            this.map.put("k" + i, "val");
        }
        this.map.put("k10", "val");
    }
}
