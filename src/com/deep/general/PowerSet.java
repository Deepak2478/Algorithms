package com.deep.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PowerSet {

	public static void main(String args[])
	{
		System.out.println("\n"+createSubsetUsingTree("ABC"));
	}
	private static List<String> createSubsetUsingTree(String str)
	{
		List<String> result = new ArrayList<String>();
		result.add("[]");
		
		// if string is not null, then process further
		if(str != null && str.length() >0)
		{
			// Iterate each element of the set
			for(int i=0; i< str.length(); i++)
			{
				//working on str.charAt(i)
				//Store the result of subset of str.charAt(i) in tempList
				List<String> tempList  = new ArrayList<String>();
				
				//Add str.charAt(i) in each item of result
				Iterator<String> iter = result.iterator();
				while(iter.hasNext())
				{
					String val = iter.next();
					//If val is [], it means str.charAt(i) is not included
					if(val.equals("[]"))
					{
						tempList.add("[ "+str.charAt(i)+" ]");
					}
					else
					{
					// for each item, there will be 2 subsets one including it and other one not including it
					//if val is not [], it means it already contains some subset without str.charAt(i)	
					tempList.add("[ "+val.substring(1, val.length()-1)+" , " +str.charAt(i)+ " ] ");
					}
				}
				result.addAll(tempList);
			}
		}
		return result;
	}
}
