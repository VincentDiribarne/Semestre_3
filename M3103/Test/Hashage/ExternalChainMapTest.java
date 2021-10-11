package Hashage;

import org.junit.Before;
import java.security.KeyException;

public class ExternalChainMapTest extends OpenAdressMapTest {
    
	@Before
    @Override
    public void setUp() {
        this.map = TestedMapFactory.createExtChainMap(10);
    }
    
	@org.junit.Test
    @Override
    public void testPutMapComplete() throws KeyException {
        for(int i = 0; i < 10; i++){
            this.map.put("k" + i, "val");
        }
        this.map.put("k10", "val");
    }
}
