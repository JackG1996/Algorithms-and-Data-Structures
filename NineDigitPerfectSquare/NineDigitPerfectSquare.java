
import java.util.Arrays;

/**
 * CS2010 (Hilary Term) - Assignment 1
 *
 * Nine Digit Perfect Square
 *
 * A natural number, p, is a perfect square if for some natural number k, k^2=p.
 * For example, 16 is a perfect square, as 4^2=16. The number 20 is not a
 * perfect square as there is no natural number k such that k^2=20.
 *
 * Problem: Develop an algorithm that will find all nine-digit perfect squares
 * that use all nine digits exactly once. For example, 139,854,276 is a solution
 * (the first) as 11,826^2=139,854,276.
 *
 * 1) Fill in the implementation of the methods described in this file.
 *
 * 2) Test your implementation by developing suitable test suite in the
 * NineDigitPerfectSquareTest JUnit test case.
 *
 * @author:
 *
 */

public class NineDigitPerfectSquare 
{
    /**
     * A method to return an array containing all squares between low and high
     *
     * @param low: lowest perfect square
     * @param high: largest perfect square
     *
     * @return an array containing all the perfect squares between low and high
     */
	
	public int [] perfectSquaresBetween(int low, int high)
	{
		int odd,s;
		int arraySize = 0;

		odd = 1;
		s = 1;

		while( s <= high )
		{
			odd = odd + 2;
			s = s + odd;

			if(s >= low && s <= high)
			{
				arraySize++;
				
			}
		}

		int [] squares = new int[arraySize];
		s = 1;
		odd = 1;
		int i = 0;
	
			while( s < low )
			{
				odd = odd + 2;
				s = s + odd;
			}	
			while(s >= low && s <= high)
			{
					squares[i] = s; 
					odd = odd + 2;
					s = s + odd;
					i++;
			}
		return squares;
	}

    public int countNineDigitPerfectSquares()
    {
        return getNineDigitPerfectSquares().length;
    }

    /**
     * A method to determine if the number specified in parameter "number"
     * contains all 9 digits exactly once.
     *
     * @param number
     *            : A number to be tested
     * @return whether the number contains all 9 digits exactly once
     */
    
    public boolean containsAllDigitsOnce(int number) 
    {
    	String theNum = Integer.toString(number);
    	String numbers = "123456789";
    	
    	
    	for(int i = 0; i < theNum.length(); i++)
    	{ 
    		if(theNum.contains("0"))
    		{
    			return false;
    		}	
    	}
    		
    	for(int i = 0; i < numbers.length(); i++)
    	{
    		int count = 0;
    		
    		for(int j = 0; j < theNum.length(); j++)
    		{
    			if(numbers.charAt(i) == theNum.charAt(j))
    			{
    				count++;
    			}

    			if(count > 1 )
    			{
    				return false;
    			}
    		}	
    	}
    	
    	return true;
    }
    
    /*
     * 1. Convert the number to a String using Integer.toString(number);
     * 2. Create a "constant" String variable of numbers from 1 to 9;
     * 3. Create a loop, and using the .CONTAINS("0") implemented function to check if number has a 0 in it;
     * 4. If it doesn't have a zero then create a nested for loop;
     * 5. Loop one will take the first number from the "constant" String i.e. 1;
     * 6. Loop two will take go through all of the numbers from the converted int figure to String 
     * 	  i.e. compare all numbers from argument to constant String to check if any are duplicated;
     * 7. A separate variable count will be incremented if the numbers equal however if count is equal to two return false; 
     */


    /**
     * A method to return an array containing all the squares discovered
     *
     * @return an array containing all of the perfect squares which
     * contain all digits 1..9 exactly once.
     */
    public int[] getNineDigitPerfectSquares() 
    {
    	int low = 139854276;
    	int high = 923187456;

    	int [] tempSquares = new int[perfectSquaresBetween(low,high).length];
    	int arraySize = 0;

    	tempSquares = perfectSquaresBetween(low,high);
    	
    	for(int i = 0; i < tempSquares.length; i++)
    	{ 
    		int testNum = tempSquares[i];
    		
    		if(containsAllDigitsOnce(testNum) == true)
    		{
    			arraySize++;
    		} 
    	}	
    	
    	int [] perfSquares = new int [arraySize];
    	int j = 0;
    	
    	for(int i = 0; i < tempSquares.length; i++)
    	{ 
    		int testNum = tempSquares[i];
    		
    		if(containsAllDigitsOnce(testNum) == true)
    		{
    			perfSquares[j] = testNum;
    			j++;
    		} 
    	}	
    	
    	return perfSquares;
    }
}