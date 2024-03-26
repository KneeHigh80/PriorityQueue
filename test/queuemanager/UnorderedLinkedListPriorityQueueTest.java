
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
public class UnorderedLinkedListPriorityQueueTest {
    
    private UnorderedLinkedListPriorityQueue<String> instance;
    
    public UnorderedLinkedListPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new UnorderedLinkedListPriorityQueue<>();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class UnorderedLinkedListPriorityQueue.
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
     * Test of head method, of class UnorderedLinkedListPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        instance.add("item1", 5);
        instance.add("item2", 10);
        instance.add("item3", 15);
        Object expResult = "item3";
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class UnorderedLinkedListPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        instance.add("item1", 5);
        instance.add("item2", 10);
        instance.add("item3", 15);
        assertEquals("item3", instance.head());
        instance.remove();
        assertEquals("item2", instance.head());
    }

    /**
     * Test of isEmpty method, of class UnorderedLinkedListPriorityQueue.
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
     * Test of toString method, of class UnorderedLinkedListPriorityQueue.
     */
    @Test
    public void testToString() throws Exception{
        System.out.println("toString");
        instance.add("item1", 1);
        instance.add("item2", 2);
        instance.add("item3", 3);
        String expResult = "[(item1, 1), (item2, 2), (item3, 3)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
