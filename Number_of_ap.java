Number of APs
Send Feedback
Given an array of n positive integers. The task is to count the number of Arithmetic Progression subsequences in the array. As the answer could be very large, output it modulo 100001.
Note: Empty sequence or single element sequence is Arithmetic Progression.
Input Format:
First Line: N (the size of the array)
Second Line: Elements of the array separated by spaces.
Output:
 Print total number of subsequences
Input Constraints:
1 <= arr[i] <= 1000
1 <= sizeof(arr) <= 1000
Sample Input 1 :
3
1 2 3
Sample output:
8
Sample Output Explanation:
Total subsequence are: {}, { 1 }, { 2 }, { 3 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 2, 3 }
Sample Input 2:
7
1 2 3 4 5 9 10
Sample Output:
37




public class Solution {

    public  static final int MAX = 1000001; 
  
   public static int numofAP(int a[], int n) 
    { 
          
        // initializing the minimum value and 
        // maximum value of the array. 
        int minarr = +2147483647; 
        int maxarr = -2147483648; 
  
        // Finding the minimum and maximum 
        // value of the array. 
        for (int i = 0; i < n; i++) { 
            minarr = Math.min(minarr, a[i]); 
            maxarr = Math.max(maxarr, a[i]); 
        } 
  
        // dp[i] is going to store count of  
        // APs ending with arr[i]. 
        // sum[j] is going to store sun of  
        // all dp[]'s with j as an AP element. 
        int dp[] = new int[n]; 
        int sum[] = new int[MAX]; 
  
        // Initialize answer with n + 1 as  
        // single elements and empty array  
        // are also DP. 
        int ans = n + 1; 
  
        // Traversing with all common  
        // difference. 
        for (int d = (minarr - maxarr);  
                d <= (maxarr - minarr); d++)  
        { 
            Arrays.fill(sum, 0); 
  
            // Traversing all the element  
            // of the array. 
            for (int i = 0; i < n; i++) { 
                  
                // Initialize dp[i] = 1. 
                dp[i] = 1; 
  
                // Adding counts of APs with 
                // given differences and a[i]  
                // is last element. 
                // We consider all APs where  
                // an array element is previous  
                // element of AP with a particular 
                // difference 
                if (a[i] - d >= 1 &&  
                             a[i] - d <= 1000000) 
                    dp[i] += sum[a[i] - d]; 
  
                ans += dp[i] - 1; 
                sum[a[i]] += dp[i]; 
            } 
        } 
  
        return ans; 
    } 
}
