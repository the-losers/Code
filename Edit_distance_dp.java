Code: Edit Distance(Memoization and DP)
Send Feedback
Given two strings s and t of lengths m and n respectively, find the Edit Distance between the strings. Edit Distance of two strings is minimum number of steps required to make one string equal to other. In order to do so you can perform following three operations only :
1. Delete a character

2. Replace a character with another one

3. Insert a character
Note - Strings don't contain spaces
Input Format :
Line 1 : String s
Line 2 : String t
Output Format :
Line 1 : Edit Distance value
Constraints
1<= m,n <= 20
Sample Input 1 :
abc
dc
Sample Output 1 :
2

public class EditDistance {

	
	public static int editDistance(String s, String t){
		if(s.length() == 0){
			return t.length();
		}
		if(t.length() == 0){
			return s.length();
		}
		
		if(s.charAt(0) == t.charAt(0)){
			return editDistance(s.substring(1), t.substring(1));
		}else{
			// insert
			int op1 = editDistance(s, t.substring(1));
			// delete 
			int op2 = editDistance(s.substring(1), t);
			//substitute
			int op3 = editDistance(s.substring(1), t.substring(1));
			return 1 + Math.min(op1, Math.min(op2, op3));
		}
	}
	
	public static int editDistanceM(String s, String t){
		int m = s.length();
		int n = t.length();
		int storage[][] = new int[ m + 1][n + 1];
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				storage[i][j] = -1;
			}
		}
		return editDistanceM(s,t,storage);
	}
	

	private static int editDistanceM(String s, String t, int[][] storage) {
		int m = s.length();
		int n = t.length();
		if(storage[m][n] != -1){
			return storage[m][n];
		}
		
		if(m == 0){
			storage[m][n] = n;
			return storage[m][n];
		}
		if(n == 0){
			storage[m][n] = m;
			return storage[m][n];
		}
		if(s.charAt(0) == t.charAt(0)){
			storage[m][n] = editDistanceM(s.substring(1), t.substring(1), storage);
		}else{
			// insert
			int op1 = editDistanceM(s, t.substring(1), storage);
			// delete 
			int op2 = editDistanceM(s.substring(1), t, storage);
			//substitute
			int op3 = editDistanceM(s.substring(1), t.substring(1), storage);
			storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
		}
		return storage[m][n];
	}
	
	public static int editDistanceDP(String s, String t){
		int m = s.length();
		int n = t.length();
		int storage[][] = new int[ m + 1][n + 1];
		for(int j = 0; j <= n; j++){
			storage[0][j] = j;
		}
		for(int i = 0; i <= m; i++){
			storage[i][0] = i;
		}
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(s.charAt(m - i) == t.charAt(n - j)){
					storage[i][j] = storage[i - 1][j - 1];
				}else{
					storage[i][j] = 1 + Math.min(storage[i][j - 1], 
							Math.min(storage[i - 1][j], storage[i - 1][j - 1]));
				}
			}
		}
		return storage[m][n];
	}
	

	public static void main(String[] args) {
			String s = "adefdfdeadefdf";
			String t = "fdgbdedefdfdgbdfdgbd";
			System.out.println(editDistanceDP(s, t));
			System.out.println(editDistanceM(s, t));
			System.out.println(editDistance(s, t));
	}

}
