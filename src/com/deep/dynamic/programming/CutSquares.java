package com.deep.dynamic.programming;

public class CutSquares {
 
	static Integer[][] dp = new Integer[300][300];
	public static void main(String args[])
	{
		int m=36,n=30;
		System.out.println("Minnimum no. of squares are :"+getMinnimumSquares(m,n));
	}

	private static Integer getMinnimumSquares(int m, int n) {
		if(m==n)
		{ 
			return 1;
		}
		if(dp[m][n] != null)
		{
			return dp[m][n];
		}
		int vertical = Integer.MAX_VALUE;
		int horizontal  = Integer.MAX_VALUE;
		for(int i=0; i<m/2;i++)
		{
			horizontal = Math.min(horizontal, getMinnimumSquares(i, n)+getMinnimumSquares(m-i, n));
		}
		for(int i=0; i<n/2;i++)
		{
			vertical = Math.min(vertical, getMinnimumSquares(m, i)+getMinnimumSquares(m, n-i));
		}
		dp[m][n] = Math.min(horizontal, vertical);
		return dp[m][n];
	}
}
