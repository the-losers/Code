Code: Number of Balanced BTs
Send Feedback
Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.
This number can be huge, so return output modulus 10^9 + 7.
Write a simple recursive solution.
Input Format :
Integer h
Output Format :
Count % 10^9 + 7
Input Constraints :
1 <= h <= 40
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
       if(h==0 || h==1){
           return 1;
       }
        
        int x = balancedTreesOfHeightH(h-1);
        int y = balancedTreesOfHeightH(h-2);
        
        long res1 =  (long)x * x;
         long res2 =  (long) x * y *2;
        int modOfX =  (int) (res1 % mod);
         int modOfY =  (int)(res2 % mod);
        
        return  (modOfX + modOfY) % mod;
    } 
}
