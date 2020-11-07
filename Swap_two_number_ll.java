Swap every pair
Send Feedback
Given a Linked list, swap every pair of nodes to form a new linked list. That is, swap first two nodes, then 2nd two nodes and so on. If the size of linked list is odd, then leave the last node as it is.
You should not create new memory, instead change the references of already created nodes. And swap the entire node, not just their data.
Return the head of updated linked list.
-1 is the terminating number. That is, it just defines that your linked list has no more elements and it is not the part of LL.
Input format :
Linked list elements (separated by space and terminated by -1)`
Sample Input 1 :
1 2 3 4 5 6 -1
Sample Output 1 :
2 1 4 3 6 5
Sample Input 2 :
1 2 3 -1
Sample Output 2 :
2 1 3

public class Solution {

	
      public static LinkedListNode<Integer> swapEveryPair(LinkedListNode<Integer> head) {
         LinkedListNode<Integer> temp = head;
         
        
         
         while(temp != null && temp.next != null){
             
            int k = temp.data; 
            temp.data = temp.next.data; 
            temp.next.data = k; 
            temp = temp.next.next; 
           
           
           
           
         }

        return head;
	}
     
}
