
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
    
    private OrderedLinkedListPriorityQueue<String> instance;
    
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
        instance = new OrderedLinkedListPriorityQueue<>();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of add method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        instance.add("item1", 10);
        assertEquals("item1", instance.head());
        instance.add("item2", 20);
        assertEquals("item2", instance.head());
    }

    /**
     * Test of head method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        instance.add("item1", 2);
        instance.add("item2", 6);
        instance.add("item3", 4);
        Object expResult = "item2";
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        instance.add("itemremaining", 1);
        instance.add("itemtoberemoved", 10);
        assertEquals("itemtoberemoved", instance.head());
        instance.remove();
        assertEquals("itemremaining", instance.head());
    }

    /**
     * Test of isEmpty method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testIsEmpty() throws Exception {
        System.out.println("isEmpty");
        instance.add("item", 1);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class OrderedLinkedListPriorityQueue.
     */
    @Test
    public void testToString() throws Exception{
        System.out.println("toString");
        instance.add("item1", 1);
        instance.add("item2", 2);
        instance.add("item3", 3);
        String expResult = "[(item3, 3), (item2, 2), (item1, 1)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
