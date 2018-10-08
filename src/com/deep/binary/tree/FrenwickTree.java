package com.deep.binary.tree;

// for calculation and manipulation of the prefix sums of a table of values
// space complexity is O(n)
// time complexity to create frenwick tree is O(nlogn)
//time complexity to update value in frenwick tree is O(logn)
// ime complexity of getting prefix sum is O(logn)
public class FrenwickTree {

	/* Start from index+1 if you are updating index in orignal array
	 * Keep adding this value for next node till you reach outside
	 * the range of the tree.
	 */ 
	public void updateBinaryIndexedTree(int binaryIndexedTree[], int val, int index)
	{
		while(index < binaryIndexedTree.length)
		{
			binaryIndexedTree[index] += val;
			index  = getNext(index);
		}
	}
	
	/*
	 * To get next,
	 * 2's complement of get minus of index
	 * AND this with index
	 * add this to index
	 */ 
	private int getNext(int index)
	{
		return index + (index & -index);
	}
	
	/* 
	 *creating a tree is like updating frenwick tree 
	 *for every value in array
	 */
	public int[] createTree(int input[])
	{
		int binaryIndexedTree[] = new int[input.length +1];
		for(int i =1; i<=input.length; i++)
		{
			updateBinaryIndexedTree(binaryIndexedTree, input[i-1], i);
		}
		return binaryIndexedTree;
	}
	
	/*
	 * Start from index i+1 if you want to prefix sum 0 to index.
	 * Keep adding values till you reach 0 
	 */
	public int getSum(int binaryIndexedTree[], int index)
	{
		index = index +1;
		int sum = 0;
		while(index > 0)
		{
			sum += binaryIndexedTree[index];
			index = getParent(index);
		}
		return sum;
	}
	/*
	 * To get parent, 2's complement to get minus of index.
	 * AND this with index
	 * subtract that from index
	 */
	private int getParent(int index)
	{
		return index - (index & -index);
	}
		
	public static void main(String args[])
	{
		int input[] = {1,2,3,4,5,6,7};
		FrenwickTree frenwickTree = new FrenwickTree();
		int binaryIndexedTree[] = frenwickTree.createTree(input);
		int x = frenwickTree.getSum(binaryIndexedTree, 6);
	}
}
