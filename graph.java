import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

class QueueUsingLL<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    T front() {
        if (size == 0) {
            return null;
        }
        return front.data;
    }

    void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;

    }

    T dequeue() {
        if (size == 0) {
            return null;
        }

        T temp = front.data;
        front = front.next;
        if (size == 1) {
            rear = null;
        }
        size--;

        return temp;
    }


}

class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

}

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
     
        int n;
        int e;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        e = s.nextInt();

        int edges[][] = new int[n][n];
        for (int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        printHelper(edges);
    
	}
    
    public static void printBFSHelper(int edges[][], int sv, boolean visited[]) {
        QueueUsingLL<Integer> queueUsingLL = new QueueUsingLL<>();
        queueUsingLL.enqueue(sv);
        visited[sv] = true;
        int n = edges.length;

        while (!queueUsingLL.isEmpty()) {
            int front = queueUsingLL.dequeue();
            System.out.print(front+" ");
            for (int i = 0; i < n; i++) {
               if(edges[front][i] == 1 && !visited[i]){
                   queueUsingLL.enqueue(i);
                   visited[i] = true;
               }
            }
        }
    }

 public static void printDFSHelper(int edges[][], int sv, boolean visited[]) {
        System.out.println(sv);
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                printHelper(edges, i, visited);
            }
        }
    }


    public static void printHelper(int edges[][]) {
        boolean visited[] = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printBFSHelper(edges, i, visited);
            }
        }


    }

}
