package com.deep.dynamic.programming;

public class EggDrop {

	static int eggDrop(int eggs, int floors){
		if(floors ==0 || floors ==1)
		{
			return floors;
		}
		int min = Integer.MAX_VALUE;
		int result = 0;
		for(int x = 1; x <floors; x++){
			result = Math.min(eggDrop(eggs-x, x),eggDrop(eggs, floors-x));
		}
		if(result < min){
			min = result;
		}
		return 1+min;
	}
	
	public static void main(String args[]){
		System.out.println(eggDrop(2,10));
	}
}
