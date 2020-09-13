Code : Max sum sub-array
Send Feedback
Given an integer array containing both negative and positive integers. Find and return the sum of contiguous sub-array with maximum sum.
Input Format :
Line 1: Integer N, size of input array
Line 2: N integers, elements of input array (separated by space)
Output Format :
Maximum Sum of the contiguous sub-array
Contraints :
1 = N = 1000
-100 = A[i] <= 100
Sample Input 1:
3
1 2 3
Sample Output 1:
6
Sample Input 2:
4
-1 -2 -3 -4
Sample Output 2:
-1



public class Solution{	
	
public static int findSum(int arr[],int n){
		
    int max = 0;
    if(n==1){
      return arr[0];
    }
    
        int dp[] = new int[n+1];
      	
    	dp[0] = arr[0];
    
       for(int i =1; i < n ;i++){
           if(dp[i-1]>0){
               dp[i] = dp[i-1]+arr[i];
           }else{
               dp[i] = arr[i];
           }
       }
    
      for (int i = 0; i < n; i++ ) 
			if ( max < dp[i] ) 
				max = dp[i]; 

			return max; 
    
    }
}
