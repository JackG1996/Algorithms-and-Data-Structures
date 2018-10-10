import java.util.ArrayList;

import java.util.Scanner;

public class ChapmanPuzzle {

	public static void main(String [] args)
	{
		int size = 16;
		int grid [][] = new int [4][4];
		String mover = "BB";
		ArrayList <Integer> gridList = new ArrayList<Integer>(size);
		int [] gridArray = new int [size];

		gridList = createGrid(gridList, size, grid);
		
		printGrid(size,grid,mover);
		movePiece(size,grid,gridList,mover);
		gridArray = convertArray(size, grid, gridArray);
		even_perm(gridArray);
	}

	public static ArrayList<Integer> createGrid(ArrayList<Integer> gridList, int size, int grid[][])
	{
		for(int i = 1; i <= size; i++) 
		{
			int add = (int)(Math.random()* 16);
			while (gridList.contains(add)) 
			{ //while we have already used the number
				add = (int) (Math.random() * 16);
			}
			gridList.add(add);
		}
		
		for(int k = 0; k < size; k++)
		{
			int x =k%4;
			int y = k/4;
			grid[y][x] = gridList.get(k) ;
		}

		return gridList;
	}


	public static int [][] printGrid(int size,int grid[][], String mover) 
	{
		for(int p = 0; p < grid.length; p++)
		{
			for(int q = 0; q < grid[p].length; q++)
			{
				int num = grid[p][q];

				if(num == 00)
				{
					System.out.print("|" + mover + "");	
				}

				if(num < 10 && num != 00)
				{
					System.out.print("|" + "0" + num + "");	
				}
				else if(num != 0)
				{
					System.out.print("|" + num + "");
				}
			}

			System.out.println("|");
		}
		System.out.println("******************");
		return grid;
	}

	public static void movePiece(int size, int grid[][], ArrayList<Integer> gridList, String mover)
	{
		System.out.println("You may move the blank BB: up, down, left or right.What move do you wish to take?\n"
				+ "(up ‘w’ , down ‘s’ , left ‘a’ , right ‘d’).To quit press ‘q’.");

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();


		for(int i = 0; i < grid.length; i++)
		{	
			for(int j = 0; j < grid[i].length; j++)
			{

				switch(input)
				{

				case "q":

					System.out.println("You have quit the Chapman Puzzle");
					System.exit(0);
					break;

				case "w":

					if(grid[i][j] == 00 && i != 0)
					{
						int temp = grid[i][j];
						grid[i][j] = grid[i-1][j];
						grid[i-1][j] = temp;

						printGrid(size,grid,mover);
						movePiece(size, grid, gridList, mover);
					}

					if(grid[i][j] == 00 && i == 0 )
					{
						System.out.println("You cannot make that move or try that move again, please try again");
						movePiece(size, grid, gridList, mover);
					}
					break;

				case "s":

					if(grid[i][j] == 00 && i != 3)
					{
						int temp = grid[i][j];
						grid[i][j] = grid[i+1][j];
						grid[i+1][j] = temp;
						
						printGrid(size,grid,mover);
						movePiece(size, grid, gridList, mover);
					}

					if(grid[i][j] == 00 && i == 3 )
					{
						System.out.println("You cannot make that move or try that move again, please try again");
						movePiece(size, grid, gridList, mover);
					}
					break;

				case "a":

					if(grid[i][j] == 00 && j != 0)
					{
						int temp = grid[i][j];
						grid[i][j] = grid[i][j-1];
						grid[i][j-1] = temp;
						
						printGrid(size,grid,mover);
						movePiece(size, grid, gridList, mover);
					}

					if(grid[i][j] == 00 && j == 0)
					{
						System.out.println("You cannot make that move or try that move again, please try again");
						movePiece(size, grid, gridList, mover);
					}
					break;

				case "d":

					if(grid[i][j] == 00 && j != 3)
					{
						int temp = grid[i][j];
						grid[i][j] = grid[i][j+1];
						grid[i][j+1] = temp;
						
						printGrid(size,grid,mover);
						movePiece(size, grid, gridList, mover);
					}

					if(grid[i][j] == 00 && j == 3)
					{
						System.out.println("You cannot make that move or try that move again, please try again");
						movePiece(size, grid, gridList, mover);
					}
					break;
				}
			}
		}
	}

	public static int [] convertArray(int size, int grid [][], int [] gridArray)
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				gridArray[j] = grid[i][j];
			}
		}

		return gridArray;	
	}

	public static int inversions(int [] p,int low, int high)
	{ 
		// inversions in p[low..high-1]
		int result = 0;
		for (int i = low; i < high; i = i+1)
		{
			for (int j = i+1; j < high; j = j+1)
			{
				if ( p[i] > p[j] )
				{
					result = result+1;
				}
			}
		}
		return result;
	} // inversions

	public static boolean even_perm(int [] p)
	{
		int n = inversions(p, 0, p.length);
		return n%2 == 0;
	} // even

}
