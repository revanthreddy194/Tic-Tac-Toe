import java.util.Scanner;

public class GameStart 
{
	char mat[][] = new char[3][3];
	int flag = 0;
	private void showMat()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0; j<3;j++)
			{
				System.out.print(mat[i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	private void checkMatchOrNot(int i, int j,char ch) {
		//ONE: Top Left Field
		if(i==0 && j==0)
		{
			if((mat[i][j] == mat[i+1][j+1]) && (mat[i][j] == mat[i+2][j+2])
					|| (mat[i][j] == mat[i+1][j]) && (mat[i][j] == mat[i+2][j])
					||(mat[i][j] == mat[i][j+1]) && (mat[i][j] == mat[i][j+2]))
			{
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
		//TWO: Top 1st row 2nd column
		else if(i==0 && j==1)
		{
			if((mat[i][j] == mat[i+1][j]) && (mat[i][j] == mat[i+2][j])
					|| (mat[i][j] == mat[i][j-1]) && (mat[i][j] == mat[i][j+1]))
			{
				//vertical line equal
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
		//THREE: Top right field
		else if(i==0 && j==2)
		{
			if((mat[i][j] == mat[i+1][j-1]) && (mat[i][j] == mat[i+2][j-2])
					|| (mat[i][j] == mat[i+1][j]) && (mat[i][j] == mat[i+2][j])
					|| (mat[i][j] == mat[i][j-1]) && (mat[i][j] == mat[i][j-2]))
			{
				//Diagonally line equal
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
		//FOUR:2nd row 1st col 
		else if(i==1 && j==0)
		{
			if((mat[i][j] == mat[i+1][j]) && (mat[i][j] == mat[i-1][j])
					|| (mat[i][j] == mat[i][j+1]) && (mat[i][j] == mat[i][j+2]))
			{
				//vertical line equal
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
		//FIVE: 2nd row 2nd col
		else if(i==1 && j==1)
		{
			if((mat[i][j] == mat[i-1][j-1]) && (mat[i][j] == mat[i+1][j+1])
					|| (mat[i][j] == mat[i+1][j-1]) && (mat[i][j] == mat[i-1][j+1])
					|| (mat[i][j] == mat[i+1][j]) && (mat[i][j] == mat[i+2][j])
					|| (mat[i][j] == mat[i][j-1]) && (mat[i][j] == mat[i][j-2]))
			{
				//Diagonally line (\) equal
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
		//SIX: 2nd row 3rd col
		else if(i==1 && j==2)
		{
			if((mat[i][j] == mat[i-1][j]) && (mat[i][j] == mat[i+1][j])
					|| (mat[i][j] == mat[i][j-1]) && (mat[i][j] == mat[i][j-2]))
			{
				//vertical line equal
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
		//SEVEN: 3rd row 1st col
		else if(i==2 && j==0)
		{
			if((mat[i][j] == mat[i-1][j+1]) && (mat[i][j] == mat[i-2][j+2])
					|| (mat[i][j] == mat[i-1][j]) && (mat[i][j] == mat[i-2][j])
					|| (mat[i][j] == mat[i][j+1]) && (mat[i][j] == mat[i][j+2]) )
			{
				//Diagonally line equal
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
		//EIGHT: 3rd row 2nd col
		else if(i==2 && j==1)
		{
			if((mat[i][j] == mat[i-1][j]) && (mat[i][j] == mat[i-2][j])
					|| (mat[i][j] == mat[i][j-1]) && (mat[i][j] == mat[i][j+1]))
			{
				//vertical line equal
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
		//NINE: bottom right field
		else if(i==2 && j==2)
		{
			if((mat[i][j] == mat[i-1][j-1]) && (mat[i][j] == mat[i-2][j-2])
					|| (mat[i][j] == mat[i-1][j]) && (mat[i][j] == mat[i-2][j]))
			{
				//Diagonally line equal
				flag = 1;
				System.out.println("Player " + ch + " Won!");
			}
		}
	}
	public void playGameX()
	{
		Scanner sc = new Scanner(System.in);
		
		//Accepts input from user X		
		System.out.println("Enter the position(row,column) of X");
		int iRow=sc.nextInt();
		int jCol=sc.nextInt();
		
		//Scanning only the 1st digit of rows & cols when multiple digits are given 
		while (iRow >= 10) 
		{
			iRow = iRow / 10;
		}
		//Substracting with 1 as the indexes start from 0 in a matrix  
		int i = iRow - 1;
		while (jCol >= 10) 
	    {
			jCol = jCol / 10;
	   	}
		//Substracting with 1 as the indexes start from 0 in a matrix  
	    int j = jCol - 1;
	    
	    //Checking whether the indexes of rows & cols are within the range
	    if((i>=0 && i<=2) && (j>=0 && j<= 2))
	    {	
	    	//Initiating X into the requested position 
	    	char ch = 'X';
	    	//Checking if the choosen field has already either X or O
	    	if(mat[i][j]!='X' && mat[i][j]!='O')
	    	{
	    		mat[i][j]='X'; //If it is empty, successfully initiate
	    		//Check if the game requirement is satisfied
		    	checkMatchOrNot(i,j,ch);
		    	showMat();
		    	//If the game need is satisfied, flag turns 1 and the game will end
		    	if(flag == 1)
		    	{	
		    		System.out.println("Congratulations!");
		    		System.exit(0);
		    	}
		    	//if the game is not over, O player plays
		    	else
		    	{
		    		playGameO();
		    	}
	    	}
	    	//if the selected field is not empty, warn and Re-Choose
	    	else if(mat[i][j]=='X' || mat[i][j]=='O')
	    	{
	    			System.out.println("Choose a valid field which is empty!");
	    			playGameX();
	    	}
	    }
	    //if the indexes are not in range, warn and re-choose indexes
    	else	    	
    	{
    		System.out.println("Choose a valid field position!");
			playGameX();
		
	    }	
	}
	
	public void playGameO()
	{
		Scanner sc = new Scanner(System.in);
		//Accepts input from user O
		System.out.println("Enter the position(row,column) of O");
	
		int kRow=sc.nextInt();
		int lCol=sc.nextInt();
		
		//Scanning only the 1st digit of rows & cols when multiple digits are given
		while (kRow >= 10) 
		{
			kRow = kRow / 10;
		}
		//Substracting with 1 as the indexes start from 0 in a matrix  
		int k = kRow - 1;
		while (lCol >= 10) 
	    {
			lCol = lCol / 10;
	   	}
		//Substracting with 1 as the indexes start from 0 in a matrix  
	    int l = lCol - 1;
		
	  //Checking whether the indexes of rows & cols are within the range
	    if((k>=0 && l<=2) && (k>=0 && l<= 2))
	    {	
	    	//Initiating O into the requested position 
	    	char ch = 'O';
	    	//Checking if the choosen field has already either X or O
	    	if(mat[k][l]!='O' && mat[k][l]!='X')
	    	{
	    		mat[k][l]='O'; //If it is empty, successfully initiate
	    		
	    		//Check if the game requirement is satisfied
		    	checkMatchOrNot(k,l,ch);
		    	showMat();
		    	//If the game need is satisfied, flag turns 1 and the game will end
		    	if(flag == 1)
		    	{	
		    		System.out.println("Congratulations!");
		    		System.exit(0);
		    	}
		    	//if the game is not over, X player plays
		    	else
		    	{
		    		playGameX();
		    	}
	    	}
	    	//if the selected field is not empty, warn and Re-Choose
	    	else if(mat[k][l]=='O' || mat[k][l]=='X')
	   		{
	   			System.out.println("Choose a valid field which is empty!");
	   			playGameO();
	    	}
	    }
	    //if the indexes are not in range, warn and re-choose indexes
    	else	    	
    	{
    		System.out.println("Choose a valid field position!");
			playGameO();
		
	    }	
	}
	//This method starts the game by internally calling other methods on invoking this
	public void playOXO()
	{
		System.out.println("11 " + "12 " + "13");
		System.out.println("21 " + "22 " + "23");
		System.out.println("31 " + "32 " + "33");
		System.out.println();
		
		showMat();
		playGameX();
		playGameO();
	}
}
