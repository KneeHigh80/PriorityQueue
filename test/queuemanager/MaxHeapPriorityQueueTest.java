/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
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
        Object item = null;
        int priority = 0;
        MaxHeapPriorityQueue instance = null;
        instance.add(item, priority);
        
    }

    /**
     * Test of head method, of class MaxHeapPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        MaxHeapPriorityQueue instance = null;
        Object expResult = null;
        Object result = instance.head();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of remove method, of class MaxHeapPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        MaxHeapPriorityQueue instance = null;
        instance.remove();
        
    }

    /**
     * Test of isEmpty method, of class MaxHeapPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MaxHeapPriorityQueue instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
    }
    
}
