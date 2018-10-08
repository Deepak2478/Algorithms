package com.deep.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.InputMap;

/*
 * Time complexity O(2^n * n*2)
 * Space complexity O(2^n)
 * 
 */

public class TravelingSalesmanHeldKarp {
	
	public static int INFINITY = 1000000;
	
	private static class Index{
		int currentVertex;
		Set<Integer> vertexSet;
		@Override
		public boolean equals(Object o){
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			
			Index index =  (Index)o;
			
			if(currentVertex != index.currentVertex) return false;
			return !(vertexSet != null ? !vertexSet.equals(index.vertexSet): index.vertexSet !=null);
		}
		@Override
		public int hashCode(){
			int result = currentVertex;
			result = 31 * result + (vertexSet != null? vertexSet.hashCode() :0);
			return result;
		}
		public static Index createIndex(int vertex, Set<Integer> vertexSet){
			Index i = new Index();
			i.currentVertex = vertex;
			i.vertexSet = vertexSet;
			return i;		
		}
	}
	
	public int minCost(int[][] distance){
		Map<Index, Integer> minCostDP = new HashMap<>();
		Map<Index, Integer> parent = new HashMap<>();
		List<Set<Integer>> allSets = generateCombination(distance.length -1);
		
		for(Set<Integer> set : allSets){
			for(int currentVertex = 1; currentVertex < distance.length; currentVertex++){
				if(set.contains(currentVertex)){
					continue;
				}
				Index index = Index.createIndex(currentVertex, set);
				int minCost = INFINITY;
				int minPreviousVertex = 0;
				Set<Integer> copySet = new HashSet<>(set);
				for(int prevVertex : set){
					int cost = distance[prevVertex][currentVertex]+getCost(copySet,prevVertex,minCostDP);
					if(cost<minCost){
						minCost = cost;
						minPreviousVertex = prevVertex;
					}
				}
				if(set.size() == 0){
					minCost = distance[0][currentVertex];
				}
				minCostDP.put(index, minCost);
				parent.put(index, minPreviousVertex);
			}
		}
		
		return 0;		
	}

	private int getCost(Set<Integer> set, int prevVertex, Map<Index, Integer> minCostDP) {
		set.remove(prevVertex);
		Index index = Index.createIndex(prevVertex, set);
		int cost = minCostDP.get(index);
		set.add(prevVertex);
		return cost;
	}

	private List<Set<Integer>> generateCombination(int n) {
		int  input[] = new int[n];
		for(int i = 0; i< input.length; i++){
			input[i] = i+1;
		}
		List<Set<Integer>> allSets = new ArrayList<Set<Integer>>();
		int result[] = new int[input.length];
		generateCombination(input,0,0,allSets,result);
		Collections.sort(allSets, new Comparator<Set<Integer>>() {

			@Override
			public int compare(Set<Integer> o1, Set<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.size()-o2.size();
			}
			
		});
		
		return allSets;
	}

	private void generateCombination(int[] input, int start, int pos, List<Set<Integer>> allSets, int[] result) {
		if(pos == input.length){
			return;
		}
		Set<Integer> set = createSet(result,pos);
		allSets.add(set);
		for(int i =start; i< input.length;i++){
			result[pos] = input[i];
			generateCombination(input, i+1, pos+1, allSets, result);
		}
		
	}

	private Set<Integer> createSet(int[] result, int pos) {
		if(pos == 0){
			return new HashSet<>();
		}
		Set<Integer> set  = new HashSet<>();
		for(int i=0; i<pos; i++){
			set.add(result[i]);
		}
		return set;
	}
	

}
