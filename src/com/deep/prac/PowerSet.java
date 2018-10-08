package com.deep.prac;

public class PowerSet {

	public static void main(String args[]){
		String[] elements = new String[]{"C","B","A"};
		Integer noOfSubsets = 1 << elements.length; // 2^n
		
		for(int i=0; i<noOfSubsets;i++){
			System.out.print("{");
			Integer bitMask =i;
			Integer pos = elements.length -1;
			while(bitMask !=0){
				boolean extend = false;
				if((bitMask & 1) == 1){
					System.out.print(elements[pos]);
					extend =true;
				}
				bitMask >>= 1;
				pos --;
				
				if(bitMask !=0 && extend){
					System.out.print(",");
				}
			}
			System.out.println("}");
		}
		System.out.println("}");
	}
}
