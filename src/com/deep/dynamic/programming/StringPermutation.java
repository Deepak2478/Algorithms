package com.deep.dynamic.programming;

import java.util.ArrayList;

public class StringPermutation {

	ArrayList<String> permutations = new ArrayList<String>();
	public void permute(String fixedChar, String input){
		if(!fixedChar.isEmpty())
		{
			permutations.add(fixedChar+input);
			return;
		}
		for(int i=0; i<input.length();i++)
		{
		   permute(fixedChar+input.charAt(i), input.substring(0,i)+input.substring(i+1));
		   return;
		}
	}
	
	public static void main(String args[])
	{
		StringPermutation permutation = new StringPermutation();
		permutation.permute("", "xyz");
		permutation.permutations.forEach(s -> System.out.println(s));
	}
}
