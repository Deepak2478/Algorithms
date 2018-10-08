package com.deep.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl {
	private BstNode root;

	private void insert(Integer data) {
		if (root.getData() == null) {
			root = new BstNode();
			root.setData(data);
			return;
		} else {
			insertNode(root, data);
		}
	}

	private void insertNode(BstNode root, Integer data) {
		if (data < root.getData()) {
			if (root.getLeft() == null) {
				BstNode node = new BstNode();
				node.setData(data);
				root.setLeft(node);
			} else {
				insertNode(root.getLeft(), data);
			}
		} else {
			if (root.getRight() == null) {
				BstNode node = new BstNode();
				node.setData(data);
				root.setRight(node);
			} else {
				insertNode(root.getRight(), data);
			}
		}
	}

	void inorderTraversal(BstNode root) {
		if (root != null) {
			inorderTraversal(root.getLeft());
			System.out.println(root.getData());
			inorderTraversal(root.getRight());
		}
	}

	Integer findMinimum() {
		return getSmallest(root);
	}

	private Integer getSmallest(BstNode root) {
		if (root != null) {
			getSmallest(root.getLeft());
		}
		return root.getData();
	}

	Integer findMaximum() {
		return getLargest(root);
	}

	private Integer getLargest(BstNode root) {
		if (root != null) {
			getSmallest(root.getRight());
		}
		return root.getData();
	}

	private Integer getTreeHeight() {
		return traverseFromRootToLeaf(root);
	}

	private Integer traverseFromRootToLeaf(BstNode node) {
		if (node == null) {
			return -1;
		}
		// TODO Auto-generated method stub
		return Math.max(traverseFromRootToLeaf(node.getLeft()), traverseFromRootToLeaf(node.getRight())) + 1;
	}

	private void bredthFirstTraversal() {
		Queue<BstNode> queue = new LinkedList<>();
		if (this.root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			BstNode node = queue.poll();
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
			System.out.println(node.getData());
		}
	}
	private void inorderTraversal(){
		inorderTraversal(this.root);
	}
	private void mirror()
	{
		invertTree(root);
	}
	private void invertTree(BstNode node)
	{
		if(node != null){
			invertTree(node.getLeft());
			invertTree(node.getRight());
			 BstNode temp = node.getLeft();
			 node.setLeft(node.getRight());
			 node.setRight(temp);
		}
		return;
	}
	private int getDiameter()
	{
		return findDiameter(root);
	}

	private int findDiameter(BstNode node) {
		// TODO Auto-generated method stub
		if(node == null)
		{
			return 0;
		}
		int ldiameter = findDiameter(node.getLeft());
		int rdiameter = findDiameter(node.getRight());
		int lHeight = traverseFromRootToLeaf(root.getLeft());
		int rHeight = traverseFromRootToLeaf(root.getRight());
		return Math.max(lHeight+rHeight+1, ldiameter+rdiameter);
	}
}
