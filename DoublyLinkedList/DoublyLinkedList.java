import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Jack Gallagher 15335963
 *  @version 19/10/2016 23:45
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */



class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
	
	static int listLength; 
	
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
      listLength = 0;
   
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic runtime cost: Theta (1)
     *
     * Justification:
     *  There are no for or while loop iterations in this method, therefore there is only one iteration through the method.
     */
    public boolean isEmpty()
    {
    	if(head == null)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic runtime cost: Theta (n)
     *
     * Justification:
     *  Every one iteration of the while loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n)
     * 
     */
    public void insertBefore( int pos, T data ) 
    {
      DLLNode newNode = new DLLNode(data,null,null);
      DLLNode currNode = head;
      int nodePos = 0;
      int length = 0;
      
      while(currNode != null)       
      {
          currNode=currNode.next;
          length++;
      }
      
      if(isEmpty())
      {
      	  head = newNode;
    	  tail = newNode;  
    	  length++;  
      }
 
      else if(pos<=0)
      {
    	 head.prev = newNode;
    	 newNode.next = head;
    	 head = newNode;
    	 length++;  
      }
      else if(pos >= length)
      {
    	  tail.next = newNode;
    	  newNode.prev = tail;
    	  tail = newNode;
    	  length++;
      }
      
      else
      {
    	  currNode = head;
    	
    	  while(nodePos != pos)
    	  {
    	     currNode = currNode.next;
    		 nodePos++;
    	  }
    	  
    	  DLLNode prevToNew = currNode.prev;
    	  prevToNew.next = newNode;
    	  newNode.prev = prevToNew;
    	  newNode.next = currNode;
    	  currNode.prev = newNode;
    	  length++;
      }
         listLength = length;
    }
    

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic runtime cost: Theta (n)
     *
     * Justification:
     *  Every one iteration of the while loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n)
     *
     */
    public T get(int pos) 
    {
    	DLLNode currNode = head;
    	int nodeCounter = 0;
    	
      if(pos >= 0 && pos < listLength)
      {
    	  while( nodeCounter != pos)
    	  {
    		   currNode = currNode.next;
        	  nodeCounter++;	 
    	  }
    	 
    	  return currNode.data; 	
    }
      return null;
      
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic runtime cost: Theta (n)
     *
     * Justification:
     *  Every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n)
     *  
     */
    public boolean deleteAt(int pos) 
    {
    	DLLNode currNode = head;
    	int nodePos = 0;

    	if(pos >= 0 && pos < listLength)
    	{
    		if(pos == 0 && listLength == 1)
    		{
    			head = null;
    			tail = null;
    			listLength--;
    			return true;
    		}

    		else if(pos == 0)
    		{
    			head = currNode.next;
    			head.prev = null;
    			listLength--;
    			return true;
    		}

    		else{
    			while(nodePos != pos)
    			{
    				currNode = currNode.next;
    				nodePos++;

    			}
    			if(currNode == tail)
    			{
    				tail = tail.prev;
    				tail.next = null;
    				listLength--;
    				return true;
    			}
    			else
    			{
    				currNode.prev.next = currNode.next;
    				currNode.next.prev = currNode.prev;
    				listLength--;
    				return true;		
    			}
    		}
    	}

    	else
    	{
    		return false;
    	}
    }



    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic runtime cost: Theta (n)
     *
     * Justification:
     *  Every one iteration of the while loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n)
     */
    public void reverse()
    {
    		DLLNode currNode; 
    		DLLNode temp = head; 
    		
        	head = tail;
        	tail = temp;
        	currNode = head;
        	
        	while(currNode != null) 
        	{
        		temp = currNode.next;
        		currNode.next = currNode.prev;
        		currNode.prev = temp;
        	    currNode = currNode.next; 	
        	}
    }


    /*----------------------- STACK */
    /**
     * This method should behave like the usual push method of a Stack ADT.
     * If only the push and pop methods are called the data structure should behave like a stack.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic runtime cost: Theta (1)
     *
     * Justification:
     *   There are no for or while loop iterations in this method, therefore there is only one iteration through the method.
     */
    public void push(T item) 
    {
    		insertBefore(0,item);
    		listLength++;
    }

    /**
     * This method should behave like the usual pop method of a Stack ADT.
     * If only the push and pop methods are called the data structure should behave like a stack.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic runtime cost: Theta (1)
     *
     * Justification:
     *   There are no for or while loop iterations in this method, therefore there is only one iteration through the method.
     */
    public T pop() 
    {	
    	DLLNode t = head;
    	if(isEmpty() == true)
    	{
    		return null;
    	}
    	else
    	{
    		if(head.next == null)
    		{
    			head = tail = null;
    			
    		}
    		else
    		{
    			head = head.next;
    			head.prev = null;
    		}
    		listLength--;
    		return t.data;
    		
    	}
    }
    /*----------------------- QUEUE */
 
    /**
     * This method should behave like the usual enqueue method of a Queue ADT.
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic runtime cost: Theta (1)
     *
     * Justification:
     *   There are no for or while loop iterations in this method, therefore there is only one iteration through the method.
     */
    public void enqueue(T item) 
    {
    	DLLNode newNode = new DLLNode(item,null,null);
    	if (isEmpty() == true) 
    	{
    		  head = tail = newNode;
    		  listLength++;
    	}
    	else
    	{
    		tail.next = newNode;
    		newNode.prev = tail;
    		tail = newNode;
    		listLength++;
    	}
    }

     /**
     * This method should behave like the usual dequeue method of a Queue ADT.
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @return the earliest item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic runtime cost: Theta (1)
     *
     * Justification:
     *   There are no for or while loop iterations in this method, therefore there is only one iteration through the method.
     */
    public T dequeue() 
    {
    	DLLNode t = head;
    	if(isEmpty() == true)
    	{
    		return null;
    	}
    	else
    	{
    		if(head.next == null)
    		{
    			head = tail = null;
    			
    		}
    		else
    		{
    			head = head.next;
    			head.prev = null;
    		}
    		listLength--;
    		return t.data;
    	}
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic runtime cost: Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }  
}