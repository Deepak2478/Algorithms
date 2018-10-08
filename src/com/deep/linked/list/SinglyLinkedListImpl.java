package com.deep.linked.list;

import java.util.Hashtable;

public class SinglyLinkedListImpl<T> {

	private Node<T> head;
	private Node<T> tail;
	public static void main(String args[])
	{
		SinglyLinkedListImpl<Integer>  sl  = new SinglyLinkedListImpl<Integer>();
	}
	public void add(T elemnt)
	{
		Node<T> node = new Node<T>();
		node.setValue(elemnt);
		System.out.println("Adding :"+elemnt);
		
		// check i list is empty
		if(head == null)
		{
			// since there is only one element, both head and tail point to same object
			head = node;
			tail = node;
		}
		else
		{
			tail.setNextRef(node);
			tail = node;
		}
	}
	public void addAfter(T element, T after)
	{
		Node<T> tmp = head;
		Node<T> refNode = null;
		System.out.println("traversing to all nodes");
		
		//Traverse till a given element
		while(true)
		{
			if(tmp == null)
			{
				break;
			}
			if(tmp.compareTo(after) == 0)
			{
				//found target node, add after this node
				refNode = tmp;
				break;
			}
			tmp =tmp.getNextRef();
		}
		if(refNode != null)
		{
			// add element after the target node
			Node<T> nd = new Node<T>();
			nd.setValue(element);
			nd.setNextRef(tmp.getNextRef());
			if(tmp == tail)
			{
				tail = nd;
			}
			tmp.setNextRef(nd);
		}
		else
		{
			System.out.println("Unable to find a given element");
		}
	}
	
	public void deleteFront()
	{
		if(head == null)
		{
			System.out.println("Underflow ...");
		}
		Node<T> tmp = head;
		head = tmp.getNextRef();
		if(head == null)
		{
			tail = null;
		}
		System.out.println("Deleted :"+tmp.getValue());
	}
	
	public void deleteAfter(T after)
	{
		Node<T> tmp = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes...");
		/*
		 * Traverse till given element
		 */
		while(true)
		{
			if(tmp == null)
			{
				break;
			}
			if(tmp.compareTo(after) == 0)
			{
				//found the target node, add after this node
				refNode = tmp;
				break;
			}
			tmp = tmp.getNextRef();
		}
		if(refNode != null)
		{
			tmp = refNode.getNextRef();
			refNode.setNextRef(tmp.getNextRef());
			if(refNode.getNextRef() == null)
			{
				tail = refNode;
			}
			System.out.println("Deleted :"+tmp.getValue());
		}
		else
		{
			System.out.println("Unable to find given elemnt");
		}
	}
	
	public void traverse()
	{
		Node<T> tmp =head;
		while(true)
		{
			if(tmp == null)
			{
				break;
			}
			System.out.println(tmp.getValue());
			tmp = tmp.getNextRef();
		}
	}
	public Node reverseRecursively(Node node){
		Node newHead;
		
		if(node.getNextRef() == null){
			return node;
		}
		
		newHead = reverseRecursively(node.getNextRef());
		
		// reverse the adjacency
		//node.next.next
		node.getNextRef().getNextRef().setNextRef(node);
		//node.next
		node.getNextRef().setNextRef(null);
		return newHead;
	}
	
	public void segregateEvenOdd(){
		Node end = head;
		Node prev = null;
		Node curr = head;
		//getting pointer to last node
		while(end.getNextRef() != null){
			end  =end.getNextRef();
		}
		Node new_end =end;
		// consider all  odd nodes before getting all even nodes
		while(((Integer)curr.getValue()%2) != 0 && curr !=end){
			new_end.setNextRef(curr);
			curr = curr.getNextRef();
			new_end.getNextRef().setNextRef(null);
			new_end = new_end.getNextRef();
		}
		
		//do the following for even node
		if((Integer)curr.getValue()%2 == 0){
			head =curr;
			//now current points to next even node
			while(curr != end){
				if((Integer)curr.getValue() %2 == 0){
					prev = curr;
					curr  = curr.getNextRef();
				}
				else{
					//break the link between previous and current
					prev.setNextRef(curr.getNextRef());
					curr.setNextRef(null);
					
					//move current to end
					new_end.setNextRef(curr);
					
					// make current as new end of list
					new_end = curr;
					
					//update curr pointer
					curr = prev.getNextRef();
				}
			}
		}
		else{
			prev = curr;
		}
		if(new_end != end && ((Integer)end.getValue()%2) !=0)
		{
			prev.setNextRef(end.getNextRef());
			end.setNextRef(null);
			new_end.setNextRef(end);
		}
	}
	
	public void removeDuplicates(Node<T> n){
		Hashtable table = new Hashtable<>();
		Node previous =null;
		while(n != null){
			if(table.containsKey(n.getValue())){
				previous.setNextRef(n.getNextRef());
			}
			else{
				table.put(n.getValue(), true);
				previous = n;
			}
			n=n.getNextRef();
		}
	}
	
	public void remodeDuplicatesUsingrunner(Node head){
		if(head == null)return;
		Node previous = head;
		Node current = previous.getNextRef();
		while(current !=null){
			Node runner =head;
			while(runner != current){
				if(runner.getValue()== current.getValue()){
					Node tmp = current.getNextRef();
					previous.setNextRef(tmp);
					current = tmp;
					break;
				}
				runner = runner.getNextRef();
			}
			if(runner == current){
				previous = current;
				current = current.getNextRef();
			}
		}
	}
	
}
