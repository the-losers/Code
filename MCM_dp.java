Code : MCM
Send Feedback
Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to multiply these matrices i.e. determine where to place parentheses to minimise the number of multiplications.
You will be given an array p[] of size n + 1. Dimension of matrix Ai is p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.
Input Format :
Line 1 : Integer n i.e. number of matrices
Line 2 : n + 1 integers i.e. elements of array p[] 
Output Format :
Line 1 : Minimum number of multiplication needed
Constraints :
1 <= n <= 100
Sample Input 1 :
3
10 15 20 25
Sample Output :
8000
Sample Output Explanation :
There are two ways to multiply the chain - A1*(A2*A3) or (A1*A2)*A3.
If multiply in order A1*(A2*A3) then number of multiplications required are 15000.
If multiply in order (A1*A2)*A3 then number of multiplications required are 8000.
Thus minimum number of multiplications required are 8000



public class Solution {

	
	public static int mcm(int[] p){
		
	  return MatrixChainOrder(p, p.length);

	}

     static int MatrixChainOrder(int p[], int n) 
    { 
       
        int m[][] = new int[n][n]; 
  
        int i, j, k, L, q; 
  
        /* m[i, j] = Minimum number of scalar multiplications needed 
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where 
        dimension of A[i] is p[i-1] x p[i] */
  
        // cost is zero when multiplying one matrix. 
        for (i = 1; i < n; i++) 
            m[i][i] = 0; 
  
        // L is chain length. 
        for (L = 2; L < n; L++) { 
            for (i = 1; i < n - L + 1; i++) { 
                j = i + L - 1; 
                if (j == n) 
                    continue; 
                m[i][j] = Integer.MAX_VALUE; 
                for (k = i; k <= j - 1; k++) { 
                    // q = cost/scalar multiplications 
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
  
        return m[1][n - 1]; 
    } 

	
}
