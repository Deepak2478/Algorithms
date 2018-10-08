package com.deep.dynamic.programming;

public class MatrixChain {

	private static int matrixChain(int arr[],int start, int end){
		if(start == end)
		{
			return 0;
		}
		int min = Integer.MAX_VALUE;
		
		for(int i = start; i< end;i++){
			int count = matrixChain(arr,start,i)+matrixChain(arr, i+1, end)+ arr[start-1]*arr[i]*arr[end];
			if(count < min){
				min = count;
			}
		}
		
		return min;
	}
	
	public static void main(String args[]){
		int arr[] = new int[]{1,2,3,4,3};
		System.out.println(matrixChain(arr, 1,arr.length -1));
	}
}
