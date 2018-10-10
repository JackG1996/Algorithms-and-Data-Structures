import java.util.ArrayList;
import java.util.List;

/**
 * CS2010 (Hilary Term) - Assignment 3
 * 
 * Self Divisible Numbers
 * 
 * Self divisible numbers are those, that satisfy the following property:
 * 		a) All the 9 digits in the number are different, i.e. each of the 9 digits 1..9 is used once.
 * 		b) The number denoted by the first k-digits is divisible by k (i.e. the first k-digits are a multiple of k)
 *  
 *  	Consider the number 723654981; 
 *  	We have:   1|7,  2|72, 3|723, 4|7236, 5|72365, 6|723654  [read  a|b  as “a divides b” or “b is a multiple of a” ] 
 *  	but 7 does not divide  7236549. So this number does not satisfy property b).
 *  
 * Create a Java program that generates all 9-digit numbers.
 * 
 * 1) Implement all methods described bellow - like in HT assignment 1, calculate the values in the constructor
 * 2) Implement tests, which sufficiently cover your code
 *  
 * @author: Jack Gallagher
 * 
 */

public class SelfDivisibleNumbers {

	public SelfDivisibleNumbers() 
	{
		List<Integer> number = getSelfDivisibleNumbers(); 
		int numberOfDivisibleNums = getNumberOfSelfDivisibleNumbers();	
	}

	/**
	 * Method to produce a number corresponding to first k digits of the digits array
	 * @param digits
	 * @param k number of digits to construct the result from
	 * @return number
	 */
	public int getFirstKDigitNumber(int[] digits, int k) 
	{
		int count = 0;
		for(int i = 0; i < k; i++)
		{
			count *= 10;
			count += digits[i];
		}

		return count;
	}

	/**
	 * Method to check if the specified number is divisible by the divisor
	 * @param number
	 * @param divisor
	 * @return true if number is divisible by the divisor
	 */
	public boolean isDivisible(int number, int divisor) 
	{
		return number % divisor == 0;
	}

	/**
	 * Method to return a list containing all self divisible numbers found
	 * @return 9-digit self divisible numbers
	 */
	public List<Integer> getSelfDivisibleNumbers() 
	{
		List <Integer> rtnList = new ArrayList <Integer>();
		int[] strArray = {1,2};
		int start = getFirstKDigitNumber(strArray,2);

		for(int i = start; i < 99; i++)
		{
			if(isDivisible(i,2) && !isDivisible(i,10))
			{
				rtnList.add(i);
			}
		}
		/*
		 * ^^^^ This code gets all the even double digit numbers that don't contain zero;
		 */

		for(int j = 3; j < 10; j++)
		{
			int listLength = rtnList.size();
			for(int k = 0; k < listLength; k++)
			{
				boolean [] presentDigits = new boolean[10];
				int num = rtnList.get(k);

				while(num != 0)
				{
					int digit = num%10;
					presentDigits[digit] = true; // initial run establishes true positions in both 1 and 2 as the first number in array (i.e position 0) is 12;
					num = num/10;
				}

				for(int z = 1; z < 10; z++)
				{
					if(presentDigits[z] == false) // loop through finding where false in boolean array (i.e position 3 on initial run);
					{
						int currNum = rtnList.get(k);
						currNum *= 10; // 120.....140 // Multiply first number in array by 10 (i.e 12 * 10 = 120);
						currNum += z; // 3.......3 // Add the number z to the number (i.e 120 + 3 = 123);

						if(isDivisible(currNum, j)) // check if 123 is divisible by starting loop number j which is 3! 
							//as we have now three digits in our number 123 this process continues for all numbers up to 9;
						{
							rtnList.add(currNum);
						}
					}	
				}
			}

			int x = 0;

			while (x < listLength)
			{  	
				rtnList.remove(0);
				x++;	
			} 

			// resets array once surpassing inital length in order to speed up run time and such
		}
		return rtnList;
	}

	/**
	 * Method to return the number of self divisible numbers found
	 * @return number of 9-digit self divisible numbers
	 */
	public int getNumberOfSelfDivisibleNumbers() 
	{
		List <Integer> numOfDiv = getSelfDivisibleNumbers();
		int rtnNum = numOfDiv.size();
		return rtnNum;
	}
}
