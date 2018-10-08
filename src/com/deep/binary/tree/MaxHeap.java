package com.deep.binary.tree;

import java.util.Arrays;

public class MaxHeap {

	int[] heap;
	int size;
	
	public MaxHeap(int[] heap){
		this.size = heap.length;
		this.heap = Arrays.copyOf(heap, size);
	}
	/*
	 * Makes the array satisfy max heap property starting from
	 * {@param index} till the end of array
	 * time complexity: O(logn) 
	 */
	public void maxHeapify(int index){
		int largest = index;
		int leftIndex = 2*index +1;
		int rightIndex = 2*index+2;
		
		if(leftIndex <size && heap[index]<heap[leftIndex]){
			largest = leftIndex;
		}
		if(rightIndex <size && heap[index]<heap[rightIndex]){
			largest = rightIndex;
		}
		if(largest != index){
			swap(index,largest);
			maxHeapify(largest);
		}
	}
	/*
	 * converts array into max-heap
	 */
	public void buildMaxHeap(){
		for(int i = size/2-1;i>=0;i--){
			maxHeapify(i);
		}
	}
	/*
	 * Insert new element into heap satifying heap property
	 *  Time complexity O(logn)
	 */
	public void insert(int elem){
		//increase heap size
		heap = Arrays.copyOf(heap, size+1);
		int i=size;
		int parentIndex = (int) Math.floor((i-1)/2);
		//move through the heap till you find the right position
		while(i>0 && elem>heap[parentIndex])
		{
			heap[i] = heap[parentIndex];
			i = parentIndex;
			parentIndex = (int) Math.floor((i-1)/2);
		}
		heap[i] = elem;
		size++;
	}
	
	public int findMax(){
		if(size == 0) return -1;
		else return heap[0];
	}
	
	public void printHeap(){
		if(heap == null)
			System.out.println("null");
		int iMax = size-1,i;
		if(iMax == -1)
			System.out.println("[ ]");
		StringBuilder b = new StringBuilder();
		b.append("[");
		for(i=0; i< iMax;i++){
			b.append(heap[i]);
			b.append(", ");
		}
		System.out.println(b.append(heap[i]).append("]").toString());
	}
	
	public void swap(int firstIndex, int secondIndex){
		int temp = heap[firstIndex];
		heap[firstIndex] = heap[secondIndex];
		heap[secondIndex] = temp;
	}
	
	public static void main(String args[]){
		int[] a = new int[]{2,4,5,1,6,7,8};
		MaxHeap maxHeap = new MaxHeap(a);
		maxHeap.printHeap();
		maxHeap.buildMaxHeap();
		maxHeap.printHeap();
		maxHeap.insert(12);
		maxHeap.printHeap();
	}
	
}
