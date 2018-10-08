package com.deep.dynamic.programming;

public class LcsTest {
	
	public static int findLongestCommonSubsequence(char[] s1,char s2[])
	{
		int max = 0;
		int temp[][] = new int[s1.length+1][s2.length+1];
		for(int i=1; i< temp.length;i++){
			for(int j=1; j<temp[i].length;j++)
			{
				if(s1[i-1] == s2[j-1])
				{
					temp[i][j] = temp[i-1][j-1]+1;
				}
				else
				{
					temp[i][j] = Math.max(temp[i][j-1], temp[i-1][j]);
				}
				if(temp[i][j]>max)
				{
					max = temp[i][j];
				}
			}
		}
		
		return max;
	}
	public static void main(String args[])
	{
		String s1 = "duey";
		String s2 = "degy";
		System.out.println(findLongestCommonSubsequence(s1.toCharArray(), s2.toCharArray()));
	}
}
