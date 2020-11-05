Code : Merge Sort
Send Feedback
 Given a singly linked list of integers, sort it using 'Merge Sort.'
Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Output 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90

/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/

public class Solution {

	

         public static LinkedListNode<Integer> sortList(LinkedListNode<Integer> left,LinkedListNode<Integer> right) {
		 LinkedListNode<Integer> result = null;
		 
		 if(left == null){
		     return right;
		 }
		 
		 if(right == null){
		     return left;
		 }
		 
		 if(left.data<= right.data){
		     result = left;
		     result.next = sortList(left.next,right);
		 }else{
		      result = right;
		     result.next = sortList(left,right.next);
		 }
		 
		 return result;
	}
     
     public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
       
         
         LinkedListNode<Integer> slow = head;
         LinkedListNode<Integer> fast = head;
         
        if (head == null){
            return head;
        }
        
        while(fast !=null && fast.next!=null  && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
       
        return slow;
      
    }
     public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		 if(head == null || head.next == null){
		     return head;
		 }
		 
		LinkedListNode<Integer> middle = midPoint(head);
		LinkedListNode<Integer> nextToMiddle = middle.next;
		middle.next = null;
		 
		LinkedListNode<Integer> left = mergeSort(head);
		LinkedListNode<Integer> right = mergeSort(nextToMiddle);
		LinkedListNode<Integer> sorted = sortList(left,right);
		
        return sorted;
	}
}
