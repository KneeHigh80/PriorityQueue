
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lukas
 */
public class MaxHeapPriorityQueueTest {
    
    private MaxHeapPriorityQueue<String> instance;
    
    public MaxHeapPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new MaxHeapPriorityQueue(8);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class MaxHeapPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        instance.add("item1", 1);
        assertEquals("item1", instance.head());
        instance.add("item2", 2);
        assertEquals("item2", instance.head());
        
        
        
    }

    /**
     * Test of head method, of class MaxHeapPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        System.out.println("add");
        instance.add("item1", 1);
        instance.add("item2", 2);
        assertEquals("item2", instance.head());
        instance.add("item3", 3);
        Object expResult = "item3";
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class MaxHeapPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        instance.add("item1", 10);
        instance.add("item2", 20);
        instance.add("item3", 30);
        assertEquals("item3", instance.head());        
        instance.remove();
        assertEquals("item2", instance.head());
    }

    /**
     * Test of isEmpty method, of class MaxHeapPriorityQueue.
     */
    @Test
    public void testIsEmpty() throws Exception {
        System.out.println("isEmpty");
        instance.add("item1", 1);        
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class MaxHeapPriorityQueue.
     */
    @Test
    public void testToString() throws Exception{
        System.out.println("toString");
        instance.add("item1", 1);
        instance.add("item2", 2);
        instance.add("item3", 3);
        String expResult = "[(item3, 3), (item1, 1), (item2, 2)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
