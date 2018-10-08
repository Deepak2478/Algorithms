package com.deep.search.sort;

public class RotatedSearch {

	
	static int search(int arr[], int low, int high, int key ){
		if(low>high) return -1;
		
		int mid = (low+high)/2;
		if(arr[mid] == key){
			return mid;
		}
		/*
		 * If arr[1....mid] is sorted
		 */
		if(arr[low] < arr[mid]){
			/*
			 * As the subarray is sorted,, we can check if the key
			 * lies in first half or second half
			 */
			if(key> arr[low] && key< arr[high]){
				return search(arr, low, mid-1, key);
			}
			else{
				return search(arr, mid+1, high, key);
			}
			
		}
		
		/*
		 * If arr[1....mid] is not sorted then
		 * arr[mid+1 .... high] is sorted
		 */
		if(key > arr[mid] && key <arr[high]){
			return search(arr, mid+1, high, key);
		}
		
		return search(arr, low, mid-1, key);
	}
	
	public static void main(String args[]){
		int arr[] = {4,5,6,7,8,3,2,1};
		int n = arr.length;
		int key = 6;
		System.out.println(search(arr, 0, n-1, key));
	}
}
