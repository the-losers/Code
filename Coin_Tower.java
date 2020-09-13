Coin Tower
Send Feedback
Whis and Beerus are playing a new game today . They form a tower of N coins and make a move in alternate turns . Beerus being the God plays first . In one move player can remove 1 or X or Y coins from the tower . The person to make the last move wins the Game . Can you find out who wins the game ?
Input Format :
Contains three value N,X,Y as mentioned in the problem statement
Output Format :
A string containing the name of the winner like “Whis” or “Beerus” (without quotes)
Constraints:
1<=N<=10^6
2<=X<=Y<=50
Sample Input :
 4 2 3
Sample Output :
 Whis
 
 
 
 
 
 import java.util.*;

public class solution {

	
    // To find winner of game 
    public static String solve(int n,int x,int y) 
    { 
        // To store results 
        boolean[] dp = new boolean[n + 1]; 
       
        Arrays.fill(dp, false); 
      
        // Initial values 
        dp[0] = false; 
        dp[1] = true; 
       
        // Computing other values. 
        for (int i = 2; i <= n; i++) { 
       
            // If A losses any of i-1 or i-x 
            // or i-y game then he will 
            // definitely win game i 
            if (i - 1 >= 0 && dp[i - 1] == false) 
                dp[i] = true; 
            else if (i - x >= 0 && dp[i - x] == false) 
                dp[i] = true; 
            else if (i - y >= 0 && dp[i - y] == false) 
                dp[i] = true; 
       
            // Else A loses game. 
            else
                dp[i] = false; 
        } 
       
       
        return dp[n]!=true?"Whis":"Beerus"; 
    } 
}
