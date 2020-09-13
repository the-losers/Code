Loot Houses
Send Feedback
A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
Input Format
Line 1 : An integer N 
Line 2 : N spaced integers denoting money in each house
Output Format
 Line 1 : Maximum amount of money looted
Input Constraints
1 <= n <= 10^4
1 <= A[i] < 10^4
Sample Input :
6
5 5 10 100 10 5
Sample Output 1 :
110




public class Solution {
	 public static int getMaxMoney(int arr[], int n){

          if(n==1){
            return arr[n-1];
        }
        
		int dp[] = new int[n+1];
        dp[0] = arr[0];
        dp[1] = arr[1];
        
        if(n == 2){
            return Math.max(dp[0],dp[1]);
        }

        for(int i= 2;i < n;i++){
            
            dp[i] = Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        
        
        return dp[n-1];
	}
     
}
