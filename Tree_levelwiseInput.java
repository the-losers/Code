public class Node<T> {
	
	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		next = null;
	}
	
	
}
  public static void replaceWithDepthValue(TreeNode<Integer> root){

        if(root == null){
            return ;
        }

        replaceWithDepthValue(root,0);
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root, int k) {
       
        root.data = k;

        for (int i = 0; i < root.children.size(); i++) {
           
            replaceWithDepthValue(root.children.get(i), k + 1);
        }
    }
public static int getHeight(TreeNode<Integer> root){
		int height = 0;
    		if (root == null ) {
   				 return height;
   			 }
   
        if (root.children == null) {
   				 return 1;
  			}
 		  for (TreeNode<Integer> child : root.children) {
 				   height = Math.max(height, getHeight(child));
  				}
  		 return height + 1;
	}

public static int countLeafNodes(TreeNode<Integer> root){
 int s = 0;
		if(root == null){
            return 0;
        }
        
        if(root.children.size() == 0){
            return 1;
        }
        
        for (int i = 0; i < root.children.size(); i++) {
			s = s + countLeafNodes(root.children.get(i));
		}
return s;
	}

	public static void preorder(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		for (int i = 0; i < root.children.size(); i++) {
			preorder(root.children.get(i));
		}
	}

	public static void printAtK(TreeNode<Integer> root, int k) {
		if (k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		for (int i = 0; i < root.children.size(); i++) {
			printAtK(root.children.get(i), k - 1);
		}
	}
class QueueUsingLL<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;

	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}
	int size(){
		return size;
	}

	boolean isEmpty(){
		return size == 0;
	}

	T front() throws QueueEmptyException{
		if(size == 0){
			throw new QueueEmptyException();
		}	
		return front.data;
	}

	void enqueue(T element){
		Node<T> newNode = new Node<>(element);
		if(rear == null){
			front = newNode;
			rear = newNode;
		}else{
			rear.next = newNode;
			rear = newNode;
		}
		size++;

	}

	T dequeue() throws QueueEmptyException{
		if(size == 0){
			throw new QueueEmptyException();
		}	
		
		T temp = front.data;
		front = front.next;
		if(size == 1){
			rear = null;
		}
		size--;
		
		return temp;
	}


}
class TreeNode<T> {
	public T data;
	public ArrayList<TreeNode<T>> children;
	
	public TreeNode(T data) {
		this.data = data;
		children = new ArrayList<>();
	}
	
}

class TreeUse {
	
	public static TreeNode<Integer> takeInput(Scanner s) {
		int n;
		System.out.println("Enter next node data");
		n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of children for " + n);
		int childCount = s.nextInt();
		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String s = root.data + ":";
		for (int i = 0; i < root.children.size(); i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
	
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter num of children of " + frontNode.data);
				int numChildren = s.nextInt();
				for (int i = 0; i < numChildren; i++) {
					System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			} catch (QueueEmptyException e) {
				// Shouldn't come here
				return null;
			}
		}
		return root;
	}
	
		public static int numNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int count = 1;
		for (int i = 0; i < root.children.size(); i++) {
			count += numNodes(root.children.get(i));
		}
		return count;
	}
	
	public static int sumOfAllNode(TreeNode<Integer> root){
	  if (root == null) {
			return 0;
		}
		int count = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			count += sumOfAllNode(root.children.get(i));
		}
		return count;
	}
	
		public static int largest(TreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		
		int ans = root.data;
		for (int i = 0; i < root.children.size(); i++) {	
			int childLargest = largest(root.children.get(i));
			if (childLargest > ans) {
				ans = childLargest;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
//		Scanner s= new Scanner(System.in);
//		
//		TreeNode<Integer> root = takeInput(s);
		TreeNode<Integer> root = takeInputLevelWise();
		print(root);
	}
}

