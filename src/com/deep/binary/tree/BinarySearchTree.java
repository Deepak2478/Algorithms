package com.deep.binary.tree;

public class BinarySearchTree {
	
	class Node{
		int key;
		Node left, right;
		public Node(int item){
			key = item;
			left=right=null;
		}
	}
    
	Node root;
	
	//pointer to head node of doubly linked list
	Node head;
	/*
	 * Initialized previously visited node as NULL
	 * marked as static so that same value is accessible
	 * in all recursive calls
	 */
	static Node prev = null;
	
	public BinarySearchTree() {
		root =null;
	}
	
	void insert(int key){
		root = insertRec(root, key);
	}	
	
	Node insertRec(Node root, int key)
	{
		if(root == null){
			root = new Node(key);
			return root;
		}
		if(key< root.key){
			root.left = insertRec(root.left, key);
		}
		else if(key > root.key){
			root.right = insertRec(root.right, key);
		}
		return root;
		
	}
	
	void inorder(){
		inorderRec(root);
	}
	
	void inorderRec(Node root){
		if(root != null){
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
	// code for boundary traversal
	void printLeaves(Node node){
		if(node != null){
			printLeaves(node.left);
			if(node.left == null && node.right == null){
				System.out.println(node.key);
			}
			printLeaves(node.right);
		}
	}
	
	//fn to print only left boundaries
	void printBoundaryLeft(Node node){
		if(node != null){
			if(node.left != null){
				System.out.println(node.key);
				printBoundaryLeft(node.left);
			}
			else if(node.right != null){
				System.out.println(node.key);
				printBoundaryLeft(node.right);
			}
		}
	}
	
	void printBoundaryRight(Node node){
		if(node != null){
			if(node.right != null){
				System.out.println(node.key);
				printBoundaryLeft(node.right);
			}
			else if(node.left != null){
				System.out.println(node.key);
				printBoundaryLeft(node.left);
			}
		}
	}
	
	//boundary of the entire tree
	void printTreeBoundary(Node node){
		if(node != null){
			System.out.println(node.key);
			printBoundaryLeft(node.left);
			printLeaves(node.left);
			printLeaves(node.right);
			printBoundaryRight(node.right);
		}
	}
	
	//
	//sum tree
	int toSumTree(Node node){
		if(node == null){
			return 0;
		}
		int oldValue = node.key;
		/*
		 * recursively call for left and right subtrees
		 * and store the sum
		 */
		node.key = toSumTree(node.left)+toSumTree(node.right);
		
		return node.key+oldValue;
	}
	
	int getMaxWidth(Node node){
		int maxWidth =0;
		int width;
		int height = height(node);
		for(int i=0; i<=height; i++){
			width = getWidth(node,i);
			if(width>maxWidth){
				maxWidth = width;
			}
		}
		return maxWidth;
	}
	
	//get width of a given level
	int getWidth(Node node, int level){
		if(node == null){
			return 0;
		}
		if(level == 1){
			return 1;
		}
		else if(level >1){
			return getWidth(node.left, level-1)+getWidth(node.right, level-1);
		}
		return 0;
	}
	
	private int height(Node node) {
		if(node == null){
			return 0;
		}
		else{
			int lHeight = height(node.left);
			int rHeight = height(node.right);
			return (lHeight>rHeight?(lHeight+1):(rHeight+1));
		}
	}
	
	void toDoublyLinkedList(Node root){
		if(root == null){
			return;
		}
		toDoublyLinkedList(root.left);
		if(prev == null){
			head = root;
		}
		else{
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		toDoublyLinkedList(root.right);
	}

	public static void main(String args[])
	{
		BinarySearchTree binarySearchTree = new BinarySearchTree();
	    binarySearchTree.insert(30);
	    binarySearchTree.insert(35);
	    binarySearchTree.insert(80);
	    binarySearchTree.insert(21);
	    binarySearchTree.insert(11);
	    binarySearchTree.insert(15);
	    binarySearchTree.inorder();
	}
}

