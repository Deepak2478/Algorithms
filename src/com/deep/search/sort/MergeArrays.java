package com.deep.search.sort;

public class MergeArrays {

	public static void main(String args[]){
		int[] firstArr = new int[]{1,2,3,4,5};
		int[] seconfArr = new int[]{6,7,8};
	}
	public static void merge(int a[], int b[], int m, int n){
		int k = m+n-1;
		int i= n-1;
		int j= m-1;
		
		while(i>=0&&j>=0){
			if(a[i] > b[j])
			{
				a[k--] = a[i--];
			}
			else{
				a[k--] = b[j--];
			}
		}
		while(j>=0){
			a[k--] = b[j--];
		}
	}
}
