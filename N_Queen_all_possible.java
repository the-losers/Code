Code: N Queens
Send Feedback
You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
Input Format :
Line 1 : Integer N
Output Format :
One Line for every board configuration. 
Every line will have N*N board elements printed row wise and are separated by space
Note : Don't print anything if there isn't any valid configuration.
Constraints :
1<=N<=10
Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0




public class Solution {
	
		
      public static void placeNQueens(int n){
	
	  int board[][] = new int[n][n];	


        if(!solveNQUtil(board,0,n)){
            return;
        }
   
	}
     
     static void printSolution(int board[][],int N)  
{  
    
    for (int i = 0; i < N; i++)  
    {  
        for (int j = 0; j < N; j++)  
            System.out.print(board[i][j]+" ");  
        
    }  
    System.out.println(""); 
}  
  

static boolean isSafe(int board[][], int row, int col,int N)  
{  
    int i, j;  
  
    /* Check this row on left side */
    for (i = 0; i < col; i++)  
        if (board[row][i] == 1)  
            return false;  
  
    /* Check upper diagonal on left side */
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)  
        if (board[i][j] == 1)  
            return false;  
  
    /* Check lower diagonal on left side */
    for (i = row, j = col; j >= 0 && i < N; i++, j--)  
        if (board[i][j] == 1)  
            return false;  
  
    return true;  
}  
  
/* A recursive utility function   
to solve N Queen problem */
static boolean solveNQUtil(int board[][], int col,int N)  
{  
    /* base case: If all queens are placed  
    then return true */
    if (col == N)  
    {  
        printSolution(board, N);  
        return true;  
    }  
  
    /* Consider this column and try placing  
    this queen in all rows one by one */
    boolean res = false;  
    for (int i = 0; i < N; i++)  
    {  
        /* Check if queen can be placed on  
        board[i][col] */
        if ( isSafe(board, i, col, N) )  
        {  
            /* Place this queen in board[i][col] */
            board[i][col] = 1;  
  
            // Make result true if any placement  
            // is possible  
            res = solveNQUtil(board, col + 1,N) || res;  
  
            /* If placing queen in board[i][col]  
            doesn't lead to a solution, then  
            remove queen from board[i][col] */
            board[i][col] = 0; // BACKTRACK  
        }  
    }  
  
    /* If queen can not be place in any row in  
        this column col then return false */
    return res;  
}  
      
  

 
	
}
