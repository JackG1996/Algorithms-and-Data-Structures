import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 12/01/16 21:15:42
 *
 *  @author  Jack Gallagher
 */

@RunWith(JUnit4.class)
public class BSTTest
{
	
	@Test 
	public void testprintKeysInOrder()
	{
		
		BST<Integer, Integer> BST = new BST<Integer, Integer>();  
        BST = new BST<Integer, Integer>();
        
        BST.put(7, 7);   //        _7_
        BST.put(8, 8);   //      /     \
        BST.put(3, 3);   //    _3_      8
        BST.put(1, 1);   //  /     \
        BST.put(2, 2);   // 1       6
        BST.put(6, 6);   //  \     /
        BST.put(4, 4);   //   2   4
        
		
        assertEquals("Checking order of constructed tree","(((()1(()2()))3((()4())6()))7(()8()))", BST.printKeysInOrder());
        
        BST = new BST<Integer, Integer>();
        assertEquals("Checking if the method returns null","()", BST.printKeysInOrder());
	}
	
	@Test
	public void testContains()
	{
		BST<Integer, Integer> BST = new BST<Integer, Integer>();  
        BST = new BST<Integer, Integer>();
        
        BST.put(7, 7);   //        _7_
        BST.put(8, 8);   //      /     \
        BST.put(3, 3);   //    _3_      8
        BST.put(1, 1);   //  /     \
        BST.put(2, 2);   // 1       6
        BST.put(6, 6);   //  \     /
        BST.put(4, 4);   //   2   4
        
		assertTrue("Checking if the BST contains the key 6", BST.contains(6));
		assertFalse("Cheking if the BST contains the key 5", BST.contains(5));
		
		
	}
	@Test
    public void testGet(){      
        BST<Integer, Integer> BST = new BST<Integer, Integer>();
         
        assertNull("Checking the get function with an empty tree", BST.get(5));
         
        BST.put(7, 7);
        assertEquals("Checks if able to correctly get the root node when there is the only one node.", "7", String.valueOf(BST.get(7)));

        BST.put(8, 8);
        assertEquals("Check if able to get root node with only one right child node.", "7", String.valueOf(BST.get(7)));
        assertEquals("Check if able to get a leaf node on the right of root that is the only leaf node", "8", String.valueOf(BST.get(8)));
         
        BST = new BST<Integer, Integer>();
        BST.put(7, 7);   
        BST.put(3, 3);
        assertEquals("Check if able to get root node with only one left child node.", "7",String.valueOf(BST.get(7)));
        assertEquals("Check if able to get a leaf node on the left of root that is the only leaf node", "3",String.valueOf(BST.get(3)));
         
        
        BST = new BST<Integer, Integer>();
        BST.put(7, 7);   
        BST.put(8, 8);   
        BST.put(3, 3);   
        assertEquals("Check if able to get a leaf node (on the right side) that is the only node on the right side.", "8", String.valueOf(BST.get(8)));
        assertEquals("Check if able to get a leaf node (on the left side) that is the only node on the left side.", "3", String.valueOf(BST.get(3)));
        assertEquals("Check if able to get root node with two childs and that is all.", "7", String.valueOf(BST.get(7)));
         
        
        BST = new BST<Integer, Integer>();
        BST.put(7, 7);   //        _7_
        BST.put(8, 8);   //      /     \
        BST.put(3, 3);   //    _3_      8
        BST.put(1, 1);   //  /     \
        BST.put(2, 2);   // 1       6
        BST.put(6, 6);   //  \     /
        BST.put(4, 4);   //   2   4
        BST.put(5, 5);   //       \
        				//         5
         
        assertEquals("Check if able to get a leaf node (on the left side).", "2", String.valueOf(BST.get(2)));
        assertEquals("Check if able to get a leaf node (on the right side).", "8", String.valueOf(BST.get(8)));
        assertEquals("Check if able to get a node with a right child node.", "1", String.valueOf(BST.get(1)));
        assertEquals("Check if able to get a node with a left child node.", "6",String.valueOf(BST.get(6)));
        assertEquals("Check if able to get a node with two child nodes.", "3",String.valueOf(BST.get(3)));
        assertEquals("Check if able to get root node.", "7", String.valueOf(BST.get(7)));
        assertNull("Check if able to show an error if there is no node to check", BST.get(100));

    }
	
    @Test
    public void testPut()
    {
	   BST<Integer, Integer> BST = new BST<Integer, Integer>();

	   BST.put(7, null);
	   assertNull("Checks if is correctly unable to put in a null value", BST.get(7));
	   assertNull("Check if can properly not get a null value", BST.get(null));

	         
	   BST = new BST<Integer, Integer>();
	   BST.put(7, 7);   //        _7_
	   BST.put(8, 8);   //      /     \
	   BST.put(3, 3);   //    _3_      8
	   BST.put(1, 1);   //  /     \
	   BST.put(2, 2);   // 1       6
	   BST.put(6, 6);   //  \     /
	   BST.put(4, 4);   //   2   4
	   BST.put(5, 5);   //  /     \
	      
	   BST = new BST<Integer, Integer>();
	   BST.put(3, null);
	   assertNull("Putting a key with no value into a BST", BST.get(3));
	   

	    }
	  @Test
	     public void testDelete() 
	     {
	         BST<Integer, Integer> bst = new BST<Integer, Integer>();
	         bst.delete(1);
	         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
	         
	         bst.put(7, 7);   //        _7_
	         bst.put(8, 8);   //      /     \
	         bst.put(3, 3);   //    _3_      8
	         bst.put(1, 1);   //  /     \
	         bst.put(2, 2);   // 1       6
	         bst.put(6, 6);   //  \     /
	         bst.put(4, 4);   //   2   4
	         bst.put(5, 5);   //        \
	                          //         5
	         
	         assertEquals("Checking order of constructed tree",
	                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
	         
	         bst.delete(9);
	         assertEquals("Deleting non-existent key",
	                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
	 
	         bst.delete(8);
	         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
	 
	         bst.delete(6);
	         assertEquals("Deleting node with single child",
	                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
	 
	         bst.delete(3);
	         assertEquals("Deleting node with two children",
	                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	     }
	     
	    
	     @Test
	     public void testHeight()
	     {
	    	 BST<Integer, Integer> BST = new BST<Integer, Integer>();
	    	 
	    	 assertEquals("Height of the BST", -1, BST.height());

	    	 BST.put(7, 7);   //        _7_
	    	 BST.put(8, 8);   //      /     \
	    	 BST.put(3, 3);   //    _3_      8
	    	 BST.put(1, 1);   //  /     \
	    	 BST.put(2, 2);   // 1       6
	    	 BST.put(6, 6);   //  \     /
	    	 BST.put(4, 4);   //   2   4
	    	 BST.put(5, 5);   //        \
	    	 				  //         5

	    	
	    	 BST = new BST<Integer, Integer>();
	    	 BST.put(7, 7);   //         _7_
	    	 BST.put(5, 5);   //       /    
	    	 BST.put(4, 4);   //      5     
	    	 BST.put(1, 1);   //     /     
	    	 				  //    4     
	    	 				  //   /
	    	 				  //  1

	    	 assertEquals("Height of the BST with only left child nodes.",3, BST.height());

	    	 BST = new BST<Integer, Integer>();
	    	 BST.put(7, 7);   //         _7_
	    	 BST.put(8, 8);   //             \    
	    	 BST.put(10, 10); //              8     
	    	 BST.put(12, 12); //               \    
	    	 				  //                10  
	    	 				  //                 \
	    	 			      //                  12
	    	 
	    	assertEquals("Height of the BST with only right child nodes",3,BST.height());
	    	
	    	 BST = new BST<Integer, Integer>();
	         BST.put(7, 7);   //         _7_
	         BST.put(8, 8);   //             \    
	                          //              8  
	      
	         assertEquals("Height of a BST with one child node (right)", 1,BST.height());
	          
	         BST = new BST<Integer, Integer>();
	         BST.put(7, 7);   //         _7_
	         BST.put(5, 5);   //       / 
	                          //      5
	          
	         assertEquals("Height of a BST with one child node (left)", 1,BST.height());
	  
	     }
  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());

     //  -7
     //   |-3
     //   | |-1
     //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
     //   |   |    -null
     //   |    -null
     //    -8
     //     |-null
     //      -null

     String result = 
             "-7\n" +
                     " |-3\n" + 
                     " | |-1\n" +
                     " | | |-null\n" + 
                     " | |  -2\n" +
                     " | |   |-null\n" +
                     " | |    -null\n" +
                     " |  -6\n" +
                     " |   |-4\n" +
                     " |   | |-null\n" +
                     " |   |  -5\n" +
                     " |   |   |-null\n" +
                     " |   |    -null\n" +
                     " |    -null\n" +
                     "  -8\n" +
                     "   |-null\n" +
                     "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
 }
 
@Test
	public void testMedian()
{
        BST<Integer, Integer> BST = new BST<Integer, Integer>();
 	    assertNull("Median of a null BST", BST.median());
        BST.put(7, 7);           
 	    assertEquals("Median of a one element BST","7", String.valueOf(BST.median()));
 	    BST.put(3, 3);
 	    assertEquals("Median of a tree with one leaf node on he left","3", String.valueOf(BST.median()));
 	    
 	   BST = new BST<Integer, Integer>();
       BST.put(7, 7);          
       BST.put(8, 8);         
 	   assertEquals("Median of a tree with one leaf node on he right","7", String.valueOf(BST.median()));

 	   BST = new BST<Integer, Integer>();
 	 
        BST.put(7, 7);   //        _7_
        BST.put(8, 8);   //      /     \
        BST.put(3, 3);   //    _3_      8
        BST.put(1, 1);   //  /     \
        BST.put(2, 2);   // 1       6
        BST.put(6, 6);   //  \     /
        BST.put(4, 4);   //   2   4
        BST.put(5, 5);   //        \
                         //         5
	 	assertEquals("median of the BST ","4", String.valueOf(BST.median()));

 	}
}
  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
   