import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 03/10/16 17:10:35
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
      
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.
    
   @Test
    public void testSorting()
   {

	   int [] unsorted = { 2,5,4,7,8,1,10 };

	   int [] expectedResult = { 1,2,4,5,7,8,10 };
	   Collinear.sort(unsorted);
	   for(int i = 0; i < expectedResult.length; i++)
	   {
		   assertEquals(expectedResult[i],unsorted[i]);
	   }

   }

    @Test
   	public void testBinarySearch()
   	{
    	int [] list = { 1,2,3,4,5,6,7,8,9,10 };
    	
    	int trueNum = 6;
    	int falseNum = 11;
   
    	assertTrue("BinarySearch is true with sorted array",Collinear.binarySearch(list, trueNum));
    	assertFalse("BinarySearch is false with sorted array", Collinear.binarySearch(list, falseNum));
   	}
    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     *  You should read the lecture notes and/or book to understand how to correctly implement the main methods.
     *  You can use any of the provided classes to read from files, and time your code.
     *
     */
     public static void main(String[] args)
     {
    	   	In firstFile = new In("r05000-1.txt");
        	In secondFile = new In("r05000-2.txt");
        	In thirdFile = new In("r05000-3.txt");
        
        	int [] a1 = firstFile.readAllInts();
        	int [] a2 = secondFile.readAllInts();
        	int [] a3 = thirdFile.readAllInts();
        	
        	Stopwatch slowStopwatch = new Stopwatch();
        	System.out.println(Collinear.countCollinear(a1, a2, a3));
        	Double slowTime = slowStopwatch.elapsedTime();
        	System.out.println("The time taken to run countCollinear is " + slowTime);
        	
        	Stopwatch fastStopwatch = new Stopwatch();
        	System.out.println(Collinear.countCollinearFast(a1, a2, a3));
        	Double fastTime = fastStopwatch.elapsedTime();
        	System.out.println("The time taken to run countCollinearFast is " + fastTime);
        
      }

}
