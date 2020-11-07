Next Number
Send Feedback
Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).
Note: You don't need to print the elements, just update the elements and return the head of updated LL.
Input Constraints:
1 <= Length of Linked List <=10^6.
Input format :
Line 1 : Linked list elements (separated by space and terminated by -1)
Output Format :
Line 1: Updated linked list elements 
Sample Input 1 :
3 9 2 5 -1
Sample Output 1 :
3 9 2 6
Sample Input 2 :
9 9 9 -1
Sample Output 1 :
1 0 0 0




/*************** 
 * Following is the Node class already written 
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}
 ***************/

public class Solution {


	
      private static LinkedListNode reverse(LinkedListNode<Integer> head){
     
       LinkedListNode current = head; 
       LinkedListNode next = null; 
       LinkedListNode prev = null; 
        
        while ( current != null)   
           { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
           } 
        
        return prev;
    }

     
     
    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
         LinkedListNode<Integer> rev = reverse(head);
         
         return reverse(addOneNumber(rev));
	}
	
	public static LinkedListNode<Integer> addOneNumber(LinkedListNode<Integer> head) {
       LinkedListNode<Integer> result = head;
        LinkedListNode<Integer> temp = null;
       int carry = 1,sum=0;
       
       while(head != null){
           
           sum = carry + head.data;
           
           if (sum >= 10){
               carry = 1;
           }else{
               carry = 0;
           }
           
           
           sum = sum % 10;
           
           head.data = sum;
           temp = head;
           
           head = head.next;
       }
       
       if(carry > 0){
           temp.next =  new LinkedListNode<Integer>(carry);
       }
      
       return result;
	}


}
