
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
public class UnsortedArrayPriorityQueueTest {
    
    private UnsortedArrayPriorityQueue<String> instance;
    
    public UnsortedArrayPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new UnsortedArrayPriorityQueue<>(8);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of head method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        instance.add("highest item", 5);
        instance.add("middle item", 1);
        instance.add("lowest item", 10);
        Object expResult = "highest item";
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        instance.add("middle item", 5);
        instance.add("lowest item", 1);
        instance.add("highest item", 10);
        assertEquals("middle item", instance.head());
        instance.remove();
        assertEquals("highest item", instance.head());
    }

    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        instance.add("item1", 2);
        instance.add("item2", 4);
        assertEquals("item1", instance.head());
        instance.remove();
        assertEquals("item2", instance.head());
    }

    /**
     * Test of isEmpty method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() throws QueueOverflowException {
        System.out.println("isEmpty");
        instance.add("item", 1);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testToString() throws QueueOverflowException{
        System.out.println("toString");
        instance.add("item1", 10);
        instance.add("item2", 5);
        instance.add("item3", 1);
        String expResult = "[(item1, 10), (item2, 5), (item3, 1)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
