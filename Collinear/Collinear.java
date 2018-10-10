// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  
 *  @version 03/10/16 17:10:35
 */
class Collinear
{

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *
     * ----------------------------------------------------------
     *
     * Experimental Performance:
     * -------------------------
     *  Write the running time of the algorithm when run with the following input sizes
     *  
     *  Input Size N      Running Time (sec)
     *  ------------------------------------
     *  1000              0.291
     *  2000              2.175
     *  4000              17.346
     *
     *  Assuming that the running time of your algorithm is of the form aN^b,
     *  estimate 'b' and 'a' by fitting a line to the experimental points:
     *
     *  b = 2.949
     *  a = 4.1373706e^-10
     *
     *  What running time do you predict using your results for input size 5000?
     *  What is the actual running time you get with such an input?
     *  What is the error in percentage?
     *
     *  Error = ( (Actual time) - (Predicted time) ) * 100 / (Predicted time)
     *
     *  Input Size N      Predicted Running Time (sec)        Actual Running Time (sec)       Error (%)
     *  ------------------------------------------------------------------------------------------------
     *  5000              33.50                               34.55                            3.1343%
     * 
     *  Approximate Mathematical Performance:
     *  -------------------------
     *
     *  Using an appropriate cost model, give the performance of your algorithm.
     *  Explain your answer.
     *
     *  Performance: N^3
     *
     *  Explanation: A triple nested loop whereby each loop has a performance of N which is iterated 3 times giving N^3 performance.
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3)
    {

    	int count = 0;

    	for(int  i = 0; i < a1.length; i++)
    	{
    		for(int j = 0; j < a2.length; j++ )
    		{
    			for(int k = 0; k < a3.length; k++)
    			{

    				if(a1[i]*(2-3) + a2[j]*(3-1) + a3[k]*(1-2) == 0)
    				{
    					count++;
    					
    				}
    				
    			}
    		}

    	}
      return count;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     * Experimental Performance:
     * -------------------------
     *  Measure the running time of the algorithm when run with the following input sizes
     *  
     *  Input Size N      Running Time (sec)
     *  ------------------------------------
     *  1000              0.043
     *  2000              0.169
     *  4000              0.733
     *  5000              1.165
     *
     *
     *  Compare Implementations:
     *  ------------------------
     *  Show the sped up achieved by this method, using the times you got from your experiments.
     *
     *  Input Size N      Speedup = (time of countCollinear)/(time of countCollinearFast)
     *  ---------------------------------------------------------------------------------
     *  1000              6.68
     *  2000              12.7
     *  4000              23.66
     *  5000              1.217
     *
     *
     *  Approximate Mathematical Performance:
     *  -------------------------------------
     *
     *  Using an appropriate cost model, give the performance of your algorithm.
     *  Explain your answer.
     *
     *  Performance: N^2logN
     *
     *  Explanation: A double nested loop which has an order of growth of N^2 and a 
     *  			binary search method is called upon which has logN as its order of growth 
     *  			ultimately providing a linearithmic algorithm.
     *  			
     *
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
    	sort(a3);
    	int collinearCount = 0;
    	for(int  i = 0; i < a1.length; i++)
    	{
    		for(int j = 0; j < a2.length; j++ )
    		{
    			int temp = a1[i]*(2-3) + a2[j]*(3-1);
    			if(binarySearch(a3,temp) == true )
    			{
    				collinearCount++;
    				
    			}
    			
    		}
    	}
    	return collinearCount;
		
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     * Approximate Mathematical Performance:
     * -------------------------------------
     *  Using an appropriate cost model, give the performance of your algorithm.
     *  Explain your answer.
     *
     *  Performance: N^2
     *
     *  Explanation: The outer loop has a performance of N, however the performance of the inner loop is very much dependent upon the amount of 
     *  			inversions(swaps) required within the array in order to properly sort it.
     *
     */
    
    static void sort(int[] a)
    {
    	for( int i = 1; i < a.length; i++)
    	{
    		int key = a[i];
    		int j = i-1;

    		while(j>=0 && a[j]>key)
    		{
    			a[j+1] = a[j];
    			j--;
    		}
    		
    		a[j+1] = key;
   
    	}
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     * Approximate Mathematical Performance:
     * -------------------------------------
     *  Using an appropriate cost model, give the performance of your algorithm.
     *  Explain your answer.
     *
     *  Performance: logN
     *
     *  Explanation: Array length is divided depending on the middle position in the array and the value of x.
     *  			 Algorithms that repeatedly divides the input size by some number will need log n iterations to terminate.
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
    	
    	int low = 0;
    	int high = a.length-1;
    	
    	while(high>=low)
    	{
    		int middle = (high+low)/2;
    		if(a[middle] == x)
    		{
    			return true;
    		}
    		
    		if(a[middle] < x)
    		{
    			low = middle + 1;
    		}
    		
    		if(a[middle] > x)
    		{
    			high = middle - 1;
    		}
    		
    	}
    
      return false;
    }
}