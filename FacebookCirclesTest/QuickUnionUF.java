public class QuickUnionUF 
{
	public int[] userID;  // parent[i] = parent of i
	public int[] size;
	
	
	public QuickUnionUF(int n) 
	{
		userID = new int[n];
		size = new int[n];
		
		for (int i = 0; i < n; i++) 
		{
			userID[i] = i;
			size[i] = 1;
		}
	}
	
	public int find(int id) 
	{
		validate(id);
		while (id != userID[id])
		{
			id = userID[id];
		}
		return id;
	}

	// validate that p is a valid index
	private void validate(int p) 
	{
		int n = userID.length;
	}
	
	public void union(int p, int q) 
	{
		validate(p);
		validate(q);
		int user1Root = find(p);
		int user2Root = find(q);
		if(user1Root == user2Root)
		{
			return;	
		}
		if (size[user1Root] < size[user2Root]) 
		{ 
			userID[user1Root] = user2Root; 
		    size[user2Root] += size[user1Root]; 
		}
		else
		{
			userID[user2Root] = user1Root;
			size[user1Root] += size[user2Root];
		}
	}
}