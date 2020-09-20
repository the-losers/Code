Magic Grid
Send Feedback
You are given a magrid S ( a magic grid ) having R rows and C columns. Each cell in this magrid has either a Hungarian horntail dragon that our intrepid hero has to defeat, or a flask of magic potion that his teacher Snape has left for him. A dragon at a cell (i,j) takes away |S[i][j]| strength points from him, and a potion at a cell (i,j) increases Harry's strength by S[i][j]. If his strength drops to 0 or less at any point during his journey, Harry dies, and no magical stone can revive him.
Harry starts from the top-left corner cell (1,1) and the Sorcerer's Stone is in the bottom-right corner cell (R,C). From a cell (i,j), Harry can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and he can not move outside the magrid. Harry has used magic before starting his journey to determine which cell contains what, but lacks the basic simple mathematical skill to determine what minimum strength he needs to start with to collect the Sorcerer's Stone. Please help him once again.
Input (STDIN)
The first line contains the number of test cases T. T cases follow. Each test case consists of R C in the first line followed by the description of the grid in R lines, each containing C integers. Rows are numbered 1 to R from top to bottom and columns are numbered 1 to C from left to right. Cells with S[i][j] < 0 contain dragons, others contain magic potions.
Output (STDOUT):
Output T lines, one for each case containing the minimum strength Harry should start with from the cell (1,1) to have a positive strength through out his journey to the cell (R,C).
Constraints:
1 ≤ T ≤ 5

2 ≤ R, C ≤ 500

-10^3 ≤ S[i][j] ≤ 10^3

S[1][1] = S[R][C] = 0
Sample Input
3
2 3
0 1 -3
1 -2 0
2 2
0 1
2 0
3 4
0 -2 -3 1
-1 4 0 -2
1 -2 -3 0
Sample Output
2
1
2



import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		 Scanner sc=new Scanner(System.in);
      int numberOFTimes = sc.nextInt();
        
        for(int k=0;k<numberOFTimes;k++){
          int rows=sc.nextInt();
       int columns=sc.nextInt();
       
        
        
       int twoD[][]=new int[rows][columns];
        
          
        for(int i=0; i<rows;i++)
         {            
            for(int j=0; j<columns;j++)
            {
                twoD[i][j]=sc.nextInt();
            }
         }
        
        System.out.println(minInitialPoints(twoD,rows,columns));  
        }
       
	}
    
    
   public  static int minInitialPoints(int points[][],int R,int C) 
    { 
        // dp[i][j] represents the minimum initial points player 
        // should have so that when starts with cell(i, j) successfully 
        // reaches the destination cell(m-1, n-1) 
        int dp[][] = new int[R][C]; 
        int m = R, n = C; 
       
        // Base case 
        dp[m-1][n-1] = points[m-1][n-1] > 0? 1: 
                       Math.abs(points[m-1][n-1]) + 1; 
       
        // Fill last row and last column as base to fill 
        // entire table 
        for (int i = m-2; i >= 0; i--) 
             dp[i][n-1] = Math.max(dp[i+1][n-1] - points[i][n-1], 1); 
        for (int j = n-2; j >= 0; j--) 
             dp[m-1][j] = Math.max(dp[m-1][j+1] - points[m-1][j], 1); 
       
        // fill the table in bottom-up fashion 
        for (int i=m-2; i>=0; i--) 
        { 
            for (int j=n-2; j>=0; j--) 
            { 
                int min_points_on_exit = Math.min(dp[i+1][j], dp[i][j+1]); 
                dp[i][j] = Math.max(min_points_on_exit - points[i][j], 1); 
            } 
         } 
       
         return dp[0][0]; 
    } 

}
