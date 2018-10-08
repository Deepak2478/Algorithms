package com.deep.dynamic.programming;

public class KnapsackRecursive {
	
	public static void main(String args[])
	{
		int val[] = new int[]{60,100,120};
		int wt[] = new int[]{10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(findKnapsack(wt, val, W, n));
	}
	
	static int max(int a, int b){
		return (a>b)? a:b;
	}
	static int findKnapsack(int wt[], int val[], int W, int n){
		if(W == 0 || n ==0){
			return 0 ;
		}
		if(wt[n-1]>W){
			return findKnapsack(wt, val, W, n-1);
		}
		else return(max(val[n-1]+findKnapsack(wt, val, W-wt[n-1], n-1),findKnapsack(wt, val, W, n-1)));
	}

}
