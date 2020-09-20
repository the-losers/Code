Max Sum Rectangle
Send Feedback
Given a 2D array, find the maximum sum rectangle in it. In other words find maximum sum over all rectangles in the matrix.
Input
First line contains 2 numbers n and m denoting number of rows and number of columns. Next n lines contain m space separated integers denoting elements of matrix nxm.
Output
Output a single integer, maximum sum rectangle.
Constraints
1<=n,m<=100
Sample Input
4 5
1 2 -1 -4 -20
-8 -3 4 2 1
3 8 10 1 3
-4 -1 1 7 -6
Sample Output
29




import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		 Scanner sc=new Scanner(System.in);
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
        
        System.out.println(maxSumRectangle(twoD));
	}

    
     private static int maxSumRectangle(int [][] mat) { 
        int m = mat.length; 
        int n = mat[0].length; 
        int preSum[][] = new int[m+1][n]; 
   
        for(int i = 0; i < m; i++) { 
            for(int j = 0; j < n; j++) { 
                preSum[i+1][j] = preSum[i][j] + mat[i][j]; 
            } 
        } 
   
        int maxSum = -1; 
        int minSum = Integer.MIN_VALUE; 
        int negRow = 0, negCol = 0; 
        int rStart = 0, rEnd = 0, cStart = 0, cEnd = 0; 
        for(int rowStart = 0; rowStart < m; rowStart++) { 
            for(int row = rowStart; row < m; row++){ 
                int sum = 0; 
                int curColStart = 0; 
                for(int col = 0; col < n; col++) { 
                    sum += preSum[row+1][col] - preSum[rowStart][col]; 
                    if(sum < 0) { 
                        if(minSum < sum) { 
                            minSum = sum; 
                            negRow = row; 
                            negCol = col; 
                        } 
                        sum = 0; 
                        curColStart = col+1; 
                    } 
                    else if(maxSum < sum) { 
                        maxSum = sum; 
                        rStart = rowStart; 
                        rEnd = row; 
                        cStart = curColStart; 
                        cEnd = col; 
                    } 
                } 
            } 
        } 
          
       
        return maxSum == -1 ? minSum : maxSum; 
    } 
}
