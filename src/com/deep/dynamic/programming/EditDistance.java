package com.deep.dynamic.programming;

public class EditDistance {
	static int min(int x, int y, int z){
		if(x <=y && x<=z) return x;
		else if (y <=x && y<=z) return y;
		else return z;
	}

	static int editDistance(String str1, String str2, int m, int n){
		//if first string is empty, the only option is to include all characters
		//of str2 into str1
		if(m==0) return n;
		if(n==0) return m;
		/*
		 * If last characters of two strings are same, nothing much to do
		 * Ignore last characters and get count for remaining Integers.
		 */
		if(str1.charAt(m-1)== str2.charAt(n-1)){
			return editDistance(str1, str2, m-1, n-1);
		}
		/*
		 * If last characters are not same, consider all three operatins on last
		 * character of first string, recursively compute minimum cost for all three
		 * operations and take minimum of three value
		 */
		return 1+min(editDistance(str1, str2, m, n-1),//Insert
				editDistance(str1, str2, m-1, n),//remove
				editDistance(str1, str2, m-1, n-1));//replace		
	}
}
