Code: Number of Balanced BTs Using DP
Send Feedback
Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.
This number can be huge, so return output modulus 10^9 + 7.
Time complexity should be O(h).
Input Format :
Integer h
Output Format :
Count % 10^9 + 7
Input Constraints :
1 <= h <= 10^7
Sample Input 1:
3
Sample Output 1:
15
Sample Input 2:
4
Sample Output 2:
315






public class Solution {

	 public static int balancedTreesOfHeightH(int h) { 
        int mod = (int) Math.pow(10,9)+ 7;
        return balancedTreesOfHeightH(h, mod);
        
    }
      
     public static int balancedTreesOfHeightH(int h, int mod) { 
     
        int dp[] = new int[h+1];
        
        dp[0] = 1;
        dp[1] = 3;
        
        if(h==0 || h==1){
           return dp[h];
       }
        
        
        for(int i = 2; i<h;i++){
         int x = dp[i-1];
        int y = dp[i-2];
       
        long res1 =  (long)x * x;
         long res2 =  (long) x * y *2;
        int modOfX =  (int) (res1 % mod);
         int modOfY =  (int)(res2 % mod);
         dp[i]  =  (modOfX + modOfY) % mod;
          
        }
    
       
        return dp[h-1];
    } 
}
