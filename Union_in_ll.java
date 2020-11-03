/*******
 * Following is the LinkedListNode structure
class ListNode<T> {
	T data;
	ListNode<T> next;
	ListNode(T data)
	{
		this.data=data;
		next = null;
	}
}
*********/

public class solution {

	 public static boolean isPresent(ListNode<Integer> head, int data){
        
         
         while(head != null){
             
             if (head.data == data){
                 return true;
             }
             
             head = head.next;
         }
         
         return false;
     }
     
     
     public static ListNode<Integer> Union(ListNode<Integer> head1, ListNode<Integer> head2) {
		ListNode<Integer> temp = null;
		
		while(head1 != null){
		   
		    ListNode<Integer> new_node = new ListNode<Integer>(head1.data); 
  
        
            new_node.next = temp; 
            temp = new_node; 
           
		    // print(temp);
		    head1 = head1.next;
		}
		
	
		
		while(head2 != null){
		   // System.out.println(head2.data);
		    if(!isPresent(temp,head2.data)){
		         ListNode<Integer> new_node = new ListNode<Integer>(head2.data);
		          new_node.next = temp; 
                temp = new_node;
		       
		    }
		    head2 = head2.next;
		}
		
		return reverse(temp);
		
	}
     private static ListNode reverse(ListNode<Integer> head){
     
       ListNode current = head; 
       ListNode next = null; 
       ListNode prev = null; 
        while ( current != null)   
       { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
          
       } 
        
        return prev;
    }
}
