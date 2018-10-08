package com.deep.dynamic.programming;

public class LongestIncreasingSubsequence {
	
	static int max_ref;
	
	public static void main(String args[])
	{
		int arr[] = {10,22,9,31,21,50,41,60};
		int n = arr.length;
		System.out.println("Length of list is :"+lis(arr,n)+"\n");
	}
	
	/*To make recursive calls, this function must return two things
	 * a) Length of LIS ending with element arr[n-1], max_ending_here is used or this purpose
	 * b) Overall maximum as the LIS may end up with an element
	 * before arr[n-1] max_ref is used for this purpose
	 * 
	 * The value of LIS of a full array of size n is stored in max_ref which is our final result
	 */
	static int _lis(int arr[], int n)
	{
		//base case
		if(n == 1)
			return 1;
		// max_ending_here is length of LISending with arr[n-1]
		int res, max_ending_here = 1;
		
		/*
		 * Recursively get all LIS ending with arr[0],arr[1]...arr[n-2]
		 * If arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs to be updated,
		 * then update it.
		 */
		
		for(int i =1; i<n ; i++)
		{
			res = _lis(arr, i);
			if(arr[i-1]< arr[n-1] && (res +1) > max_ending_here)
			{
				max_ending_here = res + 1;
			}
		}
		
		// Compare the max_ending_here with overall max
		// Update overall max if needed
		if(max_ref < max_ending_here)
		{
			max_ref = max_ending_here;
		}
		// Return length of LIS ending with arr[n-1]
		return max_ending_here;
	}
	
	// The wrapper function of _lis()
	static int lis(int arr[], int n)
	{
		// The max variable holds the result
		max_ref = 1;
		
		//the function _lis() stores its result in max
		_lis(arr,n);
		
		return max_ref;
	}
	
}
