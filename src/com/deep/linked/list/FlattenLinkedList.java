package com.deep.linked.list;

public class FlattenLinkedList {

	Node head;
	class Node{
		int data;
		Node right,down;
		Node(int data){
			this.data = data;
			right = null;
			down = null;
		}
	}
	//utility function to merge two linked lists
	Node merge(Node a, Node b){
		/*
		 * If first is empty then second and vice versa
		 */
		if(a==null) return b;
		if(b==null) return a;
		
		Node result;
		if(a.data < b.data){
			result = a;
			result.down = merge(a.down, b);
		}
		else{
			result = b;
			result.down = merge(a, b.down);
		}
		
		return result;
	}
	Node flatten(Node root){
		//base cases
		if(root == null || root.right == null){
			return root;
		}
		//recur for list on right
		root.right = flatten(root.right);
		
		//now merge
		root = merge(root, root.right);
		
		return root;
	}
}
