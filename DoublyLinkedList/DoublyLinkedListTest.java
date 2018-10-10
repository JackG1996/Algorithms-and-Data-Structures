import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @ Jack Gallagher 15335963
 *  @version 03/11/16 23:58
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
    }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    @Test
    public void testGet()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.isEmpty();
        
        assertEquals( "Check for node from an empty doubly linked list", null, testDLL.get(0));
         
        testDLL.insertBefore(0,1);
        assertSame( "Check for node with one item", 1, testDLL.get(0));
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertNull( "Check if test gets node in position 0 of length 3", testDLL.get(3) );
        assertEquals( "Check if test gets node in position 2 of length 3", Integer.valueOf(3), testDLL.get(2) );
        assertEquals( "Check if test gets node in position 1 of length 3", Integer.valueOf(2), testDLL.get(1) );
         
        testDLL.insertBefore(-4, 8);
        assertEquals( "Check for node while node is not on doubly linked list", null, testDLL.get(-4) );
         
        testDLL.insertBefore(360, 7);
        assertEquals( "Check for node while node is not on doubly linked list", null, testDLL.get(360) );
         
        
      }
    
    @Test
    public void testEmpty()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        assertTrue("If the doubly linked list is empty return true", testDLL.isEmpty());
        testDLL.insertBefore(0,1);
        assertFalse("If the doubly linked list is not empty return false", testDLL.isEmpty());
    }
   
    @Test
    public void testDeleteAt()
    { 
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
    	assertTrue( "Testing when deleting one node of one element list, at position 0", testDLL.deleteAt(0));
    	
    	testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
    	testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
    	assertTrue( "Testing when deleting tail of doubly linked list", testDLL.deleteAt(2));
    	
    	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        assertTrue( "Testing when deleting one node of five element list, at position 3", testDLL.deleteAt(3));
    
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
    	assertTrue("If the node in the doubly linked list is successfully deleted ",testDLL.deleteAt(0)); 
    	assertTrue("If the node in the doubly linked list is successfully deleted ",testDLL.deleteAt(1));	
    	assertFalse("If the node is not in the doubly linked list return false",testDLL.deleteAt(-1));
    	assertFalse("If the node is not in the doubly linked list return false ",testDLL.deleteAt(5));
    	assertTrue("If the list length is equal to one and position is equal to zero",testDLL.deleteAt(0));  	
    	
    }
    
    @Test
    public void testPush()
    {
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
         testDLL.push(1);
         assertEquals( "Pushing one node onto empty linked list", "1", testDLL.toString());
    	
         testDLL = new DoublyLinkedList<Integer>();
         testDLL.push(1);
         testDLL.push(2);
         testDLL.push(3);
         assertEquals( "Pushing new nodes onto the doubly linked list", "3,2,1", testDLL.toString());
    }
    
    @Test
    public void testPop()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertNull("If doubly linked list is empty return null", testDLL.pop());
    	
    	testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(6);
    	assertEquals("Pop one element off of doubly linked list", Integer.valueOf(6), testDLL.pop());  
    	
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);
    	assertEquals("Pop the head off of doubly linked list", Integer.valueOf(3), testDLL.pop());  
    }
    
    @Test
    public void testEnqueue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(5);
    	assertEquals("Enqueueing a node of value 1 and 2 to an empty linked list", "5", testDLL.toString());

    	
    	testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(1);
    	testDLL.enqueue(2);
    	assertEquals("Enqueueing a node of value 1 and 2 to an empty linked list", "1,2", testDLL.toString());
    		
    }
    
    @Test
    public void testDequeue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.dequeue();
    	assertNull("If doubly linked list is empty return null", testDLL.dequeue());
    	
    	testDLL = new DoublyLinkedList<Integer>();
     	testDLL.enqueue(1);
    	assertEquals("Remove head from queue", Integer.valueOf(1), testDLL.dequeue());
    	
    	testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(1);
    	testDLL.enqueue(2);
    	testDLL.dequeue();
    	Integer expectedValue = 2;
    	assertEquals("Remove head from queue", expectedValue, testDLL.dequeue());
    }
    
    @Test
    public void testReverse()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0,1);
    	testDLL.insertBefore(1,2);
    	testDLL.insertBefore(2,3);
    	testDLL.insertBefore(3,4);
    	testDLL.insertBefore(4,5);
    	testDLL.reverse();   
    	
    	assertEquals("Check if the list has been reversed","5,4,3,2,1" , testDLL.toString());
    }
}