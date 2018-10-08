package com.deep.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class EulerPathAndCircuit {

	private static final BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	private static final Map<Integer, List<Integer>> accessible =new HashMap<>();
	private static Integer startingNode;
	/*
	 * Number of edges =12
	 * edges:
	 * 1 2
	 * 2 3
	 * ..
	 * ..
	 * 2,8
	 */
	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("No. of edges :");
		Integer nE = Integer.parseInt(buf.readLine());
		System.out.println("Edges :");
		for(int i = 0; i<nE;i++){
			String[] input = buf.readLine().split(" ");
			Integer u = Integer.parseInt(input[0]);
			Integer v = Integer.parseInt(input[1]);
			List<Integer> accessibleU = accessible.get(u);
			List<Integer> accessibleV = accessible.get(v);
			if(accessibleU == null){
				accessibleU = new ArrayList<>();
			}
			if(accessibleV == null){
				accessibleV = new ArrayList<>();
			}
			accessibleU.add(v);
			accessibleV.add(u);
			
			accessible.put(u, accessibleU);
			accessible.put(v, accessibleV);
		}
		
		Integer eulerStatus = evaluateEulerStatus();
		if(eulerStatus == -1) return;
		
		if(eulerStatus == 0){
			System.out.println("Euler path is :");
		}
		else{
			System.out.println("Euler status is : ");
		}
		printEuler();
		
	}
	
	private static Integer evaluateEulerStatus() {
		Integer nEven = 0;
		Integer nOdd = 0;
		for(Integer i : accessible.keySet()){
			if(accessible.get(i).size() %2 == 0){
				nEven++;
			}
			else{
				nOdd++;
				if(startingNode == null){
					startingNode = i;
				}
			}
		}
			if(nOdd == 2){
				System.out.println("Graph has a Euler path");
				return 0;
			}
			else if(nOdd == 0 ){
				System.out.println("Graph has euler circuit");
				startingNode = accessible.keySet().iterator().next();
				return 1;
			}
			else{
				System.out.println("Graph has neither euler path, nor euler circuit");
				return -1;
			}
			}
	
	private static void printEuler() {
		Stack<Integer> stack = new Stack<>();
		Integer location  = startingNode;
		Stack<Integer> euler = new Stack<>();
		while(accessible.size() !=0){
			List<Integer> accessibleFromNode = accessible.get(startingNode);
			if(accessibleFromNode != null && !(accessible.isEmpty())){
				Integer previousLocation = location;
				stack.push(location);
				location = accessibleFromNode.get(0);
				List<Integer> nextNode = accessible.get(location);
				nextNode.remove(previousLocation);
				if(nextNode.size() == 0){
					accessible.remove(location);
				}
			}
		}
		
		
		
		
		
		
		
	}
}
