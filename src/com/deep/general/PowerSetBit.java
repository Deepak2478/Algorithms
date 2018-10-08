package com.deep.general;

public class PowerSetBit {

	public static void main(String args[])
	{
		char set[] = {'a','b','c'};
		printPowerSet(set);
	}
	public static void printPowerSet(char[] set)
	{
		int power_set_size = (int) Math.pow(2, set.length);
		//run from 000 to 111
		int counter;
		for(counter =0; counter<power_set_size; counter++)
		{
			for(int j = 0; j< set.length; j++)
			{
				// check if jth bit of counter is set
				// If set then print jth element from set
				
				if((counter & (1<<j))>0)
				{
					System.out.print(set[j]);;
				}
				
			}
			System.out.println(",");
		}
	}
}
