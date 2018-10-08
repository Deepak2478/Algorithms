package com.deep.binary.tree;

import java.util.PriorityQueue;

public class KthLargest {
	
	public int fingKthLargest(int[] nums, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for(int i:nums){
			queue.offer(i);
			if(queue.size()>k)
			{
				queue.poll();
			}
		}
		return queue.peek();
	}

}
