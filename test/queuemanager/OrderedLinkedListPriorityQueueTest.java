
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
public class OrderedLinkedListPriorityQueueTest {
    
    public OrderedLinkedListPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Object item = null;
        int priority = 0;
        OrderedLinkedListPriorityQueue instance = new OrderedLinkedListPriorityQueue();
        instance.add(item, priority);
        
    }

    /**
     * Test of head method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        OrderedLinkedListPriorityQueue instance = new OrderedLinkedListPriorityQueue();
        Object expResult = null;
        Object result = instance.head();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of remove method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        OrderedLinkedListPriorityQueue instance = new OrderedLinkedListPriorityQueue();
        instance.remove();
        
    }

    /**
     * Test of isEmpty method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        OrderedLinkedListPriorityQueue instance = new OrderedLinkedListPriorityQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        OrderedLinkedListPriorityQueue instance = new OrderedLinkedListPriorityQueue();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
