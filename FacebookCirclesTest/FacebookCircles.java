/**
 * Class FacebookCircles: calculates the statistics about the friendship circles in facebook data.
 *
 * @author : Jack Gallagher
 *
 * @version 01/12/15 02:03:28
 */
public class FacebookCircles 
{
	QuickUnionUF quUF;
  private int numberOfFacebookUsers;

/**
   * Constructor
   * @param numberOfFacebookUsers : the number of users in the sample data.
   * Each user will be represented with an integer id from 0 to numberOfFacebookUsers-1.
   */
  public FacebookCircles(int numberOfFacebookUsers) 
  {
	this.numberOfFacebookUsers = numberOfFacebookUsers;
	 quUF = new QuickUnionUF(numberOfFacebookUsers);
	  
  }

  /**
   * creates a friendship connection between two users, represented by their corresponding integer ids.
   * @param user1 : int id of first user
   * @param user2 : int id of second  user
   */
  public void friends( int user1, int user2 ) 
  {
	  quUF.union(user1,user2);
  }
  
  /**
   * @return the number of friend circles in the data already loaded.
   */
  public int numberOfCircles() 
  {
    int numberOfCircles = 0;
    for(int i = 0; i < quUF.size.length; i++)
    {
    	if(quUF.userID[i] == i)
    		{
    			numberOfCircles++;
    		}
    }
    return numberOfCircles;
  }

  /**
   * @return the size of the largest circle in the data already loaded.
   */
  public int sizeOfLargestCircle() 
  {
	  int largest = quUF.size[0];
	
		for(int i = 0; i < numberOfFacebookUsers; i++)
		{
			if(quUF.size[i] >= largest)
			{
				largest = quUF.size[i];
			}
		}
  		  return largest;
  }

  /**
   * @return the size of the median circle in the data already loaded.
   */
  public int sizeOfAverageCircle() 
  {
		int average = 0;
		average = quUF.size.length/numberOfCircles();
		return average;
  }

  /**
   * @return the size of the smallest circle in the data already loaded.
   */
  public int sizeOfSmallestCircle() 
  {
			int smallest = numberOfFacebookUsers;
			for(int i = 0; i < numberOfFacebookUsers; i++)
			{
				if(quUF.userID[i] == i && smallest > quUF.size[i])
				{
					smallest = quUF.size[i];
				}
			}
			return smallest;
		}
  }

