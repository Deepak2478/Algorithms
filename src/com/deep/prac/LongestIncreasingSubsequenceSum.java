package com.deep.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LongestIncreasingSubsequenceSum {
	public static final BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("No. of elements : ");
		Integer n = new Integer(buf.readLine());
		Integer[] arr = new Integer[n];
		for(int i=0; i< n; i++){
			arr[i] = Integer.parseInt(buf.readLine());
		}
		getLongestIncreasingSum(arr);
	}
	private static void getLongestIncreasingSum(Integer[] arr) {
		Integer n = arr.length;
		Integer[] sum = new Integer[n];
		Integer[] predecessor = new Integer[n];
		for(int i = 0; i<n; i++){
			sum[i] = arr[i];
			predecessor[i] = null;
		}
		
		for(int i=1; i < n;i++){
			for(int j=0; j<i;j++){
				if(arr[j] < arr[i]){
					if(sum[i] < arr[i]+sum[j]){
						sum[i]  = arr[i]+sum[j];
						predecessor[i] = j;
					}
				}
			}
		}
		
		int maxIndex = -1;
		int max = -1;
		for(int i =0 ; i<n;i++){
			if(max<sum[i]){
				max = sum[i];
				maxIndex = i;
			}
		}
		
		System.out.println("Longest increasing sunsequesnce of length "+sum[maxIndex]+" is : ");
		
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[maxIndex]);
		while (predecessor[maxIndex] != null) {
			stack.push(arr[predecessor[maxIndex]]);
			maxIndex = predecessor[maxIndex];			
		}
		
		while (!stack.isEmpty()) {
		      System.out.print(stack.pop());
		      if(!stack.isEmpty()) {
		        System.out.print(", ");
		      } else {
		        System.out.println();
		      }
		    }
	}

}
