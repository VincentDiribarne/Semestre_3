package Hashage;

import static org.junit.Assert.*;

import java.security.KeyException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Hashage.exceptions.CompleteTableException;
import Hashage.exceptions.NullKeyException;

/**
 *
 * @author rvenant
 */
public class OpenAdressMapTest {
    protected Map<String, String> map;
    
    public OpenAdressMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.map = TestedMapFactory.createOpenAdressMap(10);
    }
    
    @After
    public void tearDown() {
        this.map = null;
    }
    
    @Test
    public void testPutGet() throws KeyException {
        this.map.put("k1", "v1");
        this.map.put("k2", "v2");
        this.map.put("k3", "v3");
        
        this.map.put("k1", "v4");
        
        this.map.put("kNull", null);
        
        assertEquals("v2", this.map.get("k2"));
        assertEquals("v3", this.map.get("k3"));
        
        assertEquals("v4", this.map.get("k1"));
        
        assertEquals(null, this.map.get("kNull"));
        
        assertEquals(null, this.map.get("kunknown"));
    }
    
    @Test(expected=NullKeyException.class)
    public void testPutKeyNull() throws KeyException {
    	this.map.put(null, "v4");
    }
    
    @Test(expected=CompleteTableException.class)
    public void testPutMapComplete() throws KeyException {
        for(int i = 0; i < 10; i++){
            this.map.put("k" + i, "val");
        }
        this.map.put("k10", "val");
    }
    
    @Test
    public void testSize() throws KeyException {
        assertEquals(0, this.map.size());
        for(int i = 0; i < 5; i++){
            this.map.put("k" + i, "val");
        }
        this.map.put("k3", "val2");
        this.map.put("k4", "val2");
        
        assertEquals(5, this.map.size());
    }
    
    @Test
    public void testContains() throws KeyException {
        this.map.put("k1", "v1");
        this.map.put("k2", "v2");
        assertTrue(this.map.contains("k1"));
        assertTrue(this.map.contains("k2"));
        assertFalse(this.map.contains("k3"));
    }
    
    @Test
    public void testRemove() throws KeyException {
        this.map.put("k1", "v1");
        this.map.put("k2", "v2");
        String vk1 = this.map.remove("k1");
        assertEquals("v1", vk1);
        String vk3 = this.map.remove("k3");
        assertEquals(null, vk3);
        this.map.put("k4", "v4");
        assertEquals(2, this.map.size());
        assertTrue(this.map.contains("k2"));
        assertTrue(this.map.contains("k4"));
    }
    
    @Test(expected=NullKeyException.class)
    public void testRemoveKeyNull() throws KeyException {
    	this.map.remove(null);
    }
    
    @Test
    public void testIterator() throws KeyException {
        Iterator<MapEntry<String, String>> it = this.map.iterator();
        assertFalse(it.hasNext());
        this.map.put("k1", "v1");
        this.map.put("k2", "v2");
        it = this.map.iterator();
        int nbElems = 0;
        while (it.hasNext()){
            MapEntry<String, String> e = it.next();
            if(e.getKey().equals("k1")){
                assertEquals("v1", e.getValue());
            }else if(e.getKey().equals("k2")){
                assertEquals("v2", e.getValue());
            }else{
                assertFalse("Bad iteration", true);
            }
            nbElems++;
        }
        assertEquals(2, nbElems);
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testIteratorException() throws KeyException {
        this.map.put("k1", "v1");
        this.map.put("k2", "v2");
        final Iterator<MapEntry<String, String>> it = this.map.iterator();
        while (it.hasNext()){
            it.next();
        }
        it.next();
    }
    
    @Test
    public void testIteratorRemove() throws KeyException {
        this.map.put("k1", "v1");
        this.map.put("k2", "v2");
        this.map.put("k3", "v3");
        this.map.put("k4", "v4");
        this.map.put("k5", "v5");
        final Iterator<MapEntry<String, String>> it = this.map.iterator();
        while (it.hasNext()){
            MapEntry<String, String> e = it.next();
            if (e.getKey().equals("k2") || e.getKey().equals("k4")){
                it.remove();
            }
        }
        assertEquals(3, this.map.size());
    }
    
    @Test(expected=IllegalStateException.class)
    public void testIteratorRemoveException1() throws KeyException {
        this.map.put("k1", "v1");
        this.map.put("k2", "v2");
        final Iterator<MapEntry<String, String>> it = this.map.iterator();
        it.remove();
    }
    
    @Test(expected=IllegalStateException.class)
    public void testIteratorRemoveException2() throws KeyException {
        this.map.put("k1", "v1");
        this.map.put("k2", "v2");
        final Iterator<MapEntry<String, String>> it = this.map.iterator();
        it.next();
        it.remove();
        it.remove();
    }
    
}
