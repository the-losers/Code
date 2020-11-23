 class BinaryTreeNode<T> {
	public BinaryTreeNode(T data) {
		this.data = data;
	}
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
}
 class Node<T> {
	
	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		next = null;
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

public class Pair<T,V> {
	public T first;
	public V second;
}


import java.util.Scanner;

public class BinaryTreeUse {

	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + "";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}
		
		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s) {
		int rootData;
		System.out.println("Enter root data");
		rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left = child;
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
		}
		return root;
	}
	
	public static int countNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int ans = 1;
		ans += countNodes(root.left);
		ans += countNodes(root.right);
		return ans;
	}
	
	public static void mirror(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		mirror(root.left);
		mirror(root.right);
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		return;
	}
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Math.max(lh, rh);
	}

	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair<Integer,Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer, Integer> lo = heightDiameter(root.left);
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		int height = 1 + Math.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Math.max(option1, Math.max(option2, option3));		
		Pair<Integer,Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}
	
	public static void inorder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public static BinaryTreeNode<Integer> buildTreeHelper(int in[], int pre[], int inS, int inE, int preS, int preE) {
		if (inS > inE) {
			return null;
		}
		int rootData = pre[preS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int rootInIndex = -1;
		for (int i = inS; i <= inE; i++) {
			if (in[i] == rootData) {
				rootInIndex = i;
				break;
			}
		}
		if (rootInIndex == -1) {
			return null;
		}
		
		int leftInS = inS;
		int leftInE = rootInIndex - 1;
		int leftPreS = preS + 1;
		int leftPreE = leftInE - leftInS + leftPreS;
		int rightInS = rootInIndex + 1;
		int rightInE = inE;
		int rightPreS = leftPreE + 1;
		int rightPreE = preE;
		root.left = buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right = buildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);
		return root;
	}
	
	public static BinaryTreeNode<Integer> buildTree(int in[], int pre[]) {
		return buildTreeHelper(in, pre, 0, in.length - 1, 0, pre.length -1);
	}
	
	public static void main(String[] args) {
//		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		printTree(root);
//		System.out.println("diameter:" + heightDiameter(root).second);
//		System.out.println("Height:" + heightDiameter(root).first);
		int in[] = {4,2,5,1,3,7};
		int pre[] = {1,2,4,5,3,7};
		BinaryTreeNode<Integer> root = buildTree(in, pre);
		printTree(root);
		
	}
}
