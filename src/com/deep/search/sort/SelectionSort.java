package com.deep.search.sort;

public class SelectionSort 
{
	private static int arr[];
	private SelectionSort(int arr[]){
		this.arr = arr;
	}
	void sort(int arr[])
	{
		int n = arr.length;
		for(int i=0; i < n-1; i++)
		{
			int min_index = i;
			for(int j=i+1; j< n; j++)
			{
				if(arr[j]<arr[i]){
					min_index = j;
				
				int temp = arr[min_index];
				arr[min_index]= arr[i];
				arr[i] = temp;
				}	
			}
		  for(int k=0; k<=5;k++){
			  System.out.print(arr[k]+",");
		  }
		  System.out.println();
		}
	}
	public static void main(String args[])
	{
		SelectionSort selectionSort = new SelectionSort( new int[]{23,11,15,2});
		int arr2[] = {9,8,7,6,5,4};
		selectionSort.sort(arr2);
	}
}
