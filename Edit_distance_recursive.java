Code: Edit Distance
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
1<= m,n <= 10
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
	
	public static void main(String[] args) {
			String s = "adef";
			String t = "gbde";
			System.out.println(editDistance(s, t));
	}

}
