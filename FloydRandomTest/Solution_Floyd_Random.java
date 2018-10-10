import java.util.*;

public class Solution_Floyd_Random
{
   RandomInterface r;

    public Solution_Floyd_Random(RandomInterface r) 
    {
        this.r = r;
    }
    
    /**
     * @param m - sample size
     * @param n - pool size
     * @return m randomly generated numbers from 0..n-1
     */
    
   int[] getRandomNum(int m, int n)
    {
        int[] arr = new int[m];
        for ( int j = 0; j < m; j = j+1 )
            arr[j] = r.nextInt(n);
          
        return arr;
    }

    /**
     * @param m - sample size
     * @param n - pool size
     * @return m unique randomly generated numbers from 0...n-1
     */
    
    int[] getCombinations(int m, int n)
    {
        int[] rs = new int[m];

        for(int k = 0; k < Math.min(m,n);k++){
            do
            {
                rs[k] = r.nextInt(n);
            }
            while(k > 0 && Arrays.binarySearch(rs, 0,k-1,rs[k]) >=0);
        }

        return rs;
    }

    // Algorithm F1. Floyd's Algorithm - Recursive
    /**
     * @param m - sample size
     * @param n - pool size
     * @return m unique randomly generated numbers from 0...n-1 (recursive solution)
     */
    
    int[] randomSample(int m, int n)
    {
        	int [] sample = new int [5];
        	
        	if(m == 0)
        	{
        		int [] empty = new int[5];
        		return empty;
        	}
        	else
        	{
        		sample = randomSample(m-1,n-1);
        		int t = getRandomNum(1,n)[0];
        		
        		for(int i = 0; i < sample.length; i++)
        		{
        			if(sample[i] == 0)
        			{
        				sample[i] = t;
        				i = sample.length;
        			}
        		}
        		
        		return sample;   
        	}  
    }

    // Iterative Solution to Random Sample, Algorithm F2.
    /**
     * @param m - sample size
     * @param n - pool size
     * @return m unique randomly generated numbers from 0...n-1
     */
    
   int[] recRandomSample(int m, int n)
    {
    	ArrayList<Integer> set = new ArrayList <Integer>();
        
    	for(int j = n-m+1; j <= n; j++)
    	{
    		int t = getRandomNum(1,j)[0];
    			
    		if(!set.contains(t))
    		{
    			set.add(t);
    		}
    		else
    		{
    			set.add(t);
    		
    		}
    	}

    	int [] retSet = new int [set.size()];
    	
    	for (int i = 0; i < set.size(); i++)
    	{
    		retSet[i] = set.get(i).intValue();
    	}
    	
    	return retSet;
	
    }

    // Solution to Random Permutation, Algorithm P.
    
    int[] floydPermutations(int m, int n)
    {
    	ArrayList<Integer> set = new ArrayList <Integer>();
    	for(int j = n-m+1; j <= n; j++)
    	{
    		int t = getRandomNum(1,j)[0];
    		
    		if(!set.contains(t))
    		{
    			set.add(0,t);
    			System.out.println("1"+ set);
    		}
    		else
    		{	
    			int index = set.indexOf(t);
    			set.add(index+1,j-1);
    			System.out.println("2" + set);
    		}
    		
    	}
    	
    	int [] retSet = new int [set.size()];
    
    	for (int i = 0; i < set.size(); i++)
    	{
    		retSet[i] = set.get(i).intValue();
    		//System.out.println(retSet[i]);
    	}
    	
    	return retSet;
    }

}
