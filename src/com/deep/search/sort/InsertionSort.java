package com.deep.search.sort;

public class InsertionSort {
	
  void sort(int arr[])
	{
		
		for(int i=1; i < arr.length;i++)
		{
			
			int j=i;
			while(j >0 && arr[j] < arr[j-1])
			{
				// swap arr[j-1] with arr[j]
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1]= temp;
				j=j-1;
			}
		}
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+ ", ");
		}

	}
	
	public static void main(String args[])
	{
		int arr[] = {23,11,66,33,2,9};
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(arr);
	}

}
