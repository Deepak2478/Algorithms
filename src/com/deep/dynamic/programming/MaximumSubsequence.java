package com.deep.dynamic.programming;

public class MaximumSubsequence {
	
	public static void main(String args[]){
		MaximumSubsequence mss = new MaximumSubsequence();
		int arr[] = {1,101,10,2,3,100,4};
		int r = mss.maxSum(arr);
		System.out.println(r);
	}

	private int maxSum(int[] arr) {
		int T[] = new int[arr.length];
		int backTracker[] = new int[arr.length];
		for(int i=0; i< arr.length;i++){
			T[i] = arr[i];
			backTracker[i]=0;
		}
		for(int i=1; i< T.length;i++){
			for(int j=0; j<i; j++){
				if(arr[j]<arr[i]){
					T[i] = Math.max(T[i], T[j]+arr[i]);
					
					backTracker[i] = Math.max(j,backTracker[i]);
				}
			}
		}
		int reversalIndex = 0;
		int max = T[0];
		for(int i=1; i< T.length; i++){
			if(T[i] > max){
				max =T[i];
				reversalIndex=i;
				}
		}
		while(reversalIndex != 0){
			System.out.println(arr[reversalIndex]);
			reversalIndex = backTracker[reversalIndex];
		}
		return max;
	}

}
