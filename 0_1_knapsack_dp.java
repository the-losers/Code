0 1 Knapsack
Send Feedback
A thief robbing a store and can carry a maximal weight of W into his knapsack. There are N items and ith item weigh wi and is of value vi. What is the maximum value V, that thief can take ?
Space complexity should be O(W).
Input Format :
Line 1 : N i.e. number of items
Line 2 : N Integers i.e. weights of items separated by space
Line 3 : N Integers i.e. values of items separated by space
Line 4 : Integer W i.e. maximum weight thief can carry
Output Format :
Line 1 : Maximum value V
Constraints
1 <= N <= 10^4
1<= wi <= 100
1 <= vi <= 100
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output :
13



public class Solution {
	
	
	
	public static int knapsack(int[] wt,int val[],int W){
   
        int n = wt.length;
         int i, w; 
        int K[][] = new int[n + 1][W + 1]; 
  
        // Build table K[][] in bottom up manner 
        for (i = 0; i <= n; i++) { 
            for (w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max( 
                        val[i - 1] + K[i - 1][w - wt[i - 1]], 
                        K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w]; 
            } 
        } 
  
        return K[n][W]; 
		
	}
	
}
