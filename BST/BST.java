/*  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 12/01/16 21:15:42
 *
 *  @author Jack Gallagher
 *
 *	My large comment sections are just for future study references btw therfore not all completed
 *************************************************/

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     *  Search BST for given key.
     *  Does there exist a key-value pair with given key?
     *
     *  @param key the search key
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation: The function can only visit each node once therefore the worst case running time would be Theta(N)
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    
    
   public int height() 
    {
     	if(isEmpty() == true)
    	{
    		return -1;
    	}
     	
        return height(root);
    }
    
    private int height(Node theNode)
    {
    	  if(theNode==null)
		   { 
			   return -1; 
		   }
    			int heightLeft = height(theNode.left);
    			int heightRight = height(theNode.right);
    			return 1 + Math.max(heightLeft, heightRight);
    }
    /*
     * -- If the BST is empty the code returns -1.
     * -- else it calls upon the private height method. 
     * -- if node is null return -1, this will ultimately terminate our recursive calls below.
     * -- else recursively call upon the height method moving theNode left(to calculate height of left subtree) and right(to calculate height of right subtree) storing results in separate integers.
     * -- Once calculated compare both, and whoever is greater add 1 to the number to account for the root of the BST.
     */
    /**
     * Median key.
     * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
     * is the element at position (N+1)/2 (where "/" here is integer division)
     *
     * @return the median key, or null if the tree is empty.
     * 
     *      //TODO fill in the correct implementation. The running time should be Theta(h), where h is the height of the tree.
     */
    public Key median() 
    {
    	 if (isEmpty()) 
    		 {
    		 	return null;
    		 }
         int medianPosition = (size()+1)/2; // median algorithm
         return medianPrivate(root, medianPosition);
     }
  
  private Key medianPrivate(Node theNode, int medianPosition)
  {	
    		int position = rank(theNode.key,root); // pass root into rank method
    		
    		if(position < medianPosition) // if the position is less than the medianPosition move right
    		{
    			return medianPrivate(theNode.right,medianPosition);
    		}
    		
    		else if(position > medianPosition) // if the position is greater than the medianPosition move left
    		{
    			return medianPrivate(theNode.left,medianPosition);
    		}
    		return theNode.key;
    }
  
  private int rank(Key key, Node theNode)
  {
	//  if (theNode == null) return 0; not needed came up as red on web-cat
	  int cmp = key.compareTo(theNode.key);
	  if (cmp < 0) // if key is less than.. move the node position pointer to the left
	  {
		 return rank(key, theNode.left);
	  }
	  
	  else if (cmp > 0) // if key is greater than.. move the node position pointer to the right
	  {
		  return 1 + size(theNode.left) + rank(key, theNode.right); 
		   // 1 for the current node, 
		  //  it knows it is to go right therefore to calculate the correct rank we must establish the size of those on the left
		 // return the rank for recursion
	  }
	  
	  else 
	  {
		return size(theNode.left)+1; // if equal return node on left
	  }
  }
	  /*-- CALCULATING MEDIAN
	   *                    S
	   *                   / \
	   *                  E   X
	   * 				/  \
	   *               A    R
	   *               \    /
	   *                C  H
	   *                   \
	   *                    M
	   *-- Firstly establish the median position using the algorithm (size()+1)/2. Example size of BST is 7 then + 1 therefore median would be 4.
	   *
	   *-- Now send the medianPosition(4) and the root of BST as arguments into the medianPrivate method.
	   *
	   *-- Once there then call the rank method passing both the root and theNode (which is the root atm).
	   *
	   *-- then compare the root key to the node key and establish if it is greater than, less than or equal to.
	   *
	   *-- theNode.key is equal to the root therefore return size of theNode.left + 1, which would be in this case = 7.  
	   *              
	   *-- Return 7 to int position and compare to int medianPosition ( 7 > 3 ) therefore move to the left now we are pointing at E in the BST.
	   *.
	   *-- Once again back into the rank method and compare theNode which is now E to the root.
	   *
	   *-- They are not equal and is in fact less than, therefore move the root pointer to the left (E).
	   *
	   *-- Back again, comparing both which are now equal, return the size of theNode.left (E) to -> (A) + 1 = 3.
	   *
	   *-- Return 3 to int position and compare to int medianPosition ( 3 > 4 ) therefore move to the right now we are pointing at R in the BST.
	   *
	   *-- Do same method method once again until int position is equal to median position and return the correct key. 
	   * 
	   * -- However this time R is greater than E therefore we must...
	   * ---------------------- 1 + size(theNode.left) + rank(key, theNode.right);
  	   * -------------------------- 1   +   1 (A)               = 2
  	   * 
  	   * -- Now the two nodes are equal and we return 2(from what we calculated above) + 2 (which is the size of the H node) + 1 = 5.
  	   * 
  	   * -- Return 5 to int position and compare to int medianPosition ( 5 > 4 ) therefore move to the left now we are pointing at H in the BST.
  	   * 
  	   * -- Continue one as above remembering to maintain 2 in the size of theNode.left as we move to the right.
  	   * 
  	   * -- Calculate size of theNode.left( 2 (from before) + 1(size of H) + 1) = 4 
  	   * 
  	   * -- Return 4 to the MedianPrivate method this time it is equal therefore return the theNode.key which is H ultimately obtaining our Median!
	   */
  

    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
     */
    public String printKeysInOrder() 
    {
      if (isEmpty()) 
    	  {
    	  	return "()"; 
    	  }
      
      else 
      {
    	 return printKeysInOrderPrivate(root);
      }

    }
      

    private String printKeysInOrderPrivate(Node theNode)
    {
    	String result = "";
  
      if (theNode == null) 
	  {
	  	return "()";
	  }
      else 
      {
    	  
    	  result += "(" + printKeysInOrderPrivate(theNode.left) + theNode.key + printKeysInOrderPrivate(theNode.right) + ")";
            return result;
            
            /* from given example of B
             * 						/ \
             * 					   A   C
             * 							\
             * 							 D
             * 
             *  Create a result string.
             *  if node is equal to nothing return "()" braces.
             *  else add to the result string recursively like so....
             *  result = "("
             *  -- Move to the node on the left A
             *  result = "(("
             *  -- Move to the node on the left again
             *  -- its null, thus return ()
             *  result  = "((()"
             *  -- now print the letter A as nothing was returned to the function therefore it can continue
             *	-- result = "((()A"
             *  -- Now checks the the to the right of node A and returns nothing
             *  -- result = "((()A()
             *  -- function adds the ")" brace to result and the printKeysInOrderPrivate(theNode.left) recursive call ends
             *  -- result = ((()A()) 
             *  -- The original recursive call continues and adds B to the result  
             *  -- result = "((()A())B
             *  -- Code continues likewise with some minor differences.
             */
      }   
    }
    
    /**
     * Pretty Printing the tree. Each node is on one line -- see assignment for details.
     *
     * @return a multi-line string with the pretty ascii picture of the tree.
     */
      
    public String prettyPrintKeys() 
    {
        if (isEmpty() == true)
        {
            return "-null\n";
        }
        	return prettyPrintKeys(root,"");
    }
    
 private String prettyPrintKeys(Node theNode, String prefix)
	{
 		String output = "";
 		if(theNode == null)
 		{
 			output += prefix + "-null\n";
 		}
 		else
 		{
 			output += prefix + "-" + theNode.key + "\n";
 			output +=   prettyPrintKeys(theNode.left, prefix + " |");
 			output +=   prettyPrintKeys(theNode.right, prefix + "  ");
 		}
 		return output;
	}

    /**
     * Deletes a key from a tree (if the key is in the tree).
     * Note that this method works symmetrically from the Hibbard deletion:
     * If the node to be deleted has two child nodes, then it needs to be
     * replaced with its predecessor (not its successor) node.
     *
     * @param key the key to delete
     */
  public void delete(Key key) 
    {
    	root = delete(root,key);
    }
    
    private Node delete(Node theNode, Key key)
    {
    	if(theNode == null)
		{
			return null;
		}
		
		int cmp = key.compareTo(theNode.key);
		
		   if(cmp < 0) 
		   	   {
			   	theNode.left  = delete(theNode.left,  key);
			   }
		   
           else if (cmp > 0)
        	   {
        	   	theNode.right = delete(theNode.right, key);
        	   }
		   
           else { 
        	   		if(theNode.right == null)
        	   		{
        	   			return theNode.left;
        	   		}
        	   		if(theNode.left == null)
        	   		{
        	   			return theNode.right;
        	   		}
        	   
        	   		Node t = theNode;
        	   		theNode = max(t.left);
        	   		theNode.left = deleteMax(t.left);
        	   		theNode.right = t.right;
	    	
	    }
		    theNode.N = size(theNode.left) + size(theNode.right) + 1;
            return theNode;			
}
    
    private Node max(Node leftNodeOfOriginal) 
    {
        if (leftNodeOfOriginal.right == null)
        	{
        		return leftNodeOfOriginal; 
        	}
        else 
        	{
        		return max(leftNodeOfOriginal.right); 
        	}
    } 

	public Node deleteMax(Node theNode)
	{
		return theNode = deleteMaxPriv(theNode);
	}

	private Node deleteMaxPriv(Node theNode)
	{
		if(theNode.right == null )
		{
			return theNode.left;
		}
		
			theNode.right = deleteMaxPriv(theNode.right);
			theNode.N = size(theNode.left)+size(theNode.right)+1;
			return theNode;
	}
}