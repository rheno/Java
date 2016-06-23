/*  Solution for https://www.hackerrank.com/challenges/swap-nodes-algo  */
/*			rhenobudiasa@yahoo.com				*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Node{

public int data;
public Node left;
public Node right;

public Node(int data, Node left, Node right){
	this.data = data;
	this.left = left;
	this.right = right;
}

}

class BinaryTree{
  
private Node root;

public BinaryTree(){
	/* Initilize root with 1 */
	root = new Node(1, null, null);
}

public Node getRoot(){
	return root;
}

/* Insert */
public void insert(int left, int right, int find, Node root){

	if(root == null){	
		return;
	}else if(root.data == find){
		if(left != -1){
			root.left = new Node(left, null, null);
		}
		if(right != -1){
			root.right = new Node(right, null, null);
		}
		return;
	}
	insert(left, right, find, root.left);
	insert(left, right, find, root.right);
}


/* Print Binary Tree In Order */
public void printInOrder(Node root){
	if(root == null){
		return;
	}
	printInOrder(root.left);
	System.out.print(root.data+" ");
	printInOrder(root.right);
}

public void swapNodes(Node root, int level){
	Queue<Node> q = new LinkedList<Node>();
	q.add(root);
	int lev = 0;
	while(q.size() != 0){
		
		int i=q.size();
				
		while(i > 0){
			Node curr = q.peek();
			if(( (lev + 1) % level) == 0){
				Node temp = curr.left;
				curr.left = curr.right;
				curr.right = temp;
			}
		
			if(curr.left != null){
				q.add(curr.left);
			}

			if(curr.right != null){
				q.add(curr.right);
			}
			i--;
			q.remove();
		}
		lev++;

		
	}
}


}


public class Solution{

public static void main(String[] args){
	
	BinaryTree bt = new BinaryTree();
	int N, T, K, a, b;
	Scanner sc = new Scanner(System.in);
	
	N = sc.nextInt();
	
	for(int i=0;i<N;i++){
		a = sc.nextInt();
		b = sc.nextInt();
		bt.insert(a, b, i+1, bt.getRoot());
	}
	
	T = sc.nextInt();

	for(int i=0;i<T;i++){
		K = sc.nextInt();
	        bt.swapNodes(bt.getRoot(), K);
		bt.printInOrder(bt.getRoot());
		System.out.println();
	}
}

}
