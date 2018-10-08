package com.deep.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Dijkstras {

	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Number of nodes : ");
		Integer n = Integer.parseInt(buf.readLine());
		Integer[][] distance = new Integer[n][n];
		for(int i=0; i<n;i++){
			int x = 0;
			String[] dist = buf.readLine().split(" ");
			for(String str: dist){
				distance[i][x++] = Integer.parseInt(str);
			}
		}
		findShortestPath(distance);
	}

	private static void findShortestPath(Integer[][] distance) {
		 Set<Integer> visited = new HashSet<Integer>();
		 Integer[] minimumDistance  = distance[0]; 
		 Integer[] predecessor = new Integer[distance.length];
		 while(visited.size() != distance.length){
			 int minIndex=-1;
			 int min = Integer.MAX_VALUE;
			 for(int i=0; i < minimumDistance.length;i++){
				 if(visited.contains(i)){
					 continue;
				 }
				 if(min > minimumDistance[i]){
					 min = minimumDistance[i];
					 minIndex = i;
				 }
			 }
			 visited.add(minIndex);
			 for(int i=0; i< distance.length; i++){
				 if(minimumDistance[i]> minimumDistance[minIndex]+distance[minIndex][i]){
					 minimumDistance[i] = minimumDistance[minIndex]+distance[minIndex][i];
					 predecessor[i] = minIndex;
				 }
			 }
		 }
		 for(int i=0; i<distance.length;i++){
			 String str = i+"";
			 Integer pred = predecessor[i];
			 while(pred != null){
				 str = pred+" -> "+str;
				 pred = predecessor[pred];
			 }
			 str = "0 ->"+str;
			 System.out.println(str+" = "+minimumDistance[i]);
		 }
	}
	
}
