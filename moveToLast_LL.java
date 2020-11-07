Move To Last
Send Feedback
Given a linked list and a key in it, the task is to move all occurrences of given key to end of linked list, keeping order of all other elements same.
Return the updated head of LL.
Input Format :
Line 1 : Elements of the linked list ending with -1 (-1 not included)
Line 2 : Key n, Element which has to shifted
Output Format :
Updated linked list
Constraints :
1 <= size of list <= 100
Sample Input 1:
1 2 2 3 4 5 -1
2
Sample Output 1:
1 3 4 5 2 2 
Sample Input 2:
1 1 2 3 4 -1
1
Sample Output 2:
2 3 4 1 1






public class Solution {


	 public static Node<Integer> func(Node<Integer> head,int key) {

        
         Node<Integer> pKey = head; 
  
        // Traverse list 
         Node<Integer> pCrawl = head; 
        while (pCrawl != null) { 
            // If current pointer is not same as pointer 
            // to a key location, then we must have found 
            // a key in linked list. We swap data of pCrawl 
            // and pKey and move pKey to next position. 
            if (pCrawl != pKey && pCrawl.data != key) { 
               
                pKey.data = pCrawl.data; 
                pCrawl.data = key; 
                pKey = pKey.next;
                // print(pKey);
            } 
  
            // Find next position where key is present 
            if (pKey.data != key) 
                pKey = pKey.next; 
  
            // Moving to next Node 
            pCrawl = pCrawl.next; 
        } 
        return head;
       		
	}


}

