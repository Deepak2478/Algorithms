package com.deep.search.sort;

public class EnhancedMerge {
	
	static int sort(int arr[], int array_size){
		int temp[] = new int[array_size-1];
		
		return mergeSort(arr, temp, 0, array_size-1);
	}

	private static int mergeSort(int[] arr, int[] temp, int left, int right) {
		int mid, inversionCount =0;
		if(left < right){
			mid = (left+right)/2;
			inversionCount += mergeSort(arr, temp, left, mid);
			inversionCount += mergeSort(arr, temp, mid+1, right);
			inversionCount += merge(arr, temp, left,mid+1, right);
		}
		
		return inversionCount;
	}

	private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
		int i,j,k;
		int inversionCount = 0;
		i = left;
		j = mid;
		k = left;
		while((i<mid-1)&&(j<right)){
			if(arr[i] <= arr[j])
			{
				temp[k++] = arr[i++];
			}
			else{
				temp[k++] = arr[j++];
				inversionCount = inversionCount + mid -i;
			}
		}
		while(i< mid-1){
			temp[k++] = arr[i++];
		}
		while(j<right){
			temp[k++] = arr[j++];
		}
		for (i=left; i <= right; i++)
	        arr[i] = temp[i];
	      
	      return inversionCount;
	}

}
