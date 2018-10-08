package com.deep.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {

	private int V; // number of vertices
	//Array of lists for adjacency list representation
	private LinkedList<Integer> adj[];
	
	private DepthFirstSearch(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;++i)
		{
			adj[i] = new LinkedList();
		}
	}
	//Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	void DFSUtil(int v, boolean visited[])
	{
		//mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v+" ");
		
		//Recur for all vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	//Function for DFS traversal. Uses recursive DFSUtil() calls
	void DFS(int v)
	{
		// mark all the vertices as not visited, kept as false by default
		boolean visited[] = new boolean[V];
		// call the recursive helper function to pint DFS traversal
		DFSUtil(v, visited);
	}
	
	public static void main(String args[])
	{
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch(4);
		depthFirstSearch.addEdge(0, 1);
		depthFirstSearch.addEdge(0, 2);
		depthFirstSearch.addEdge(1, 2);
		depthFirstSearch.addEdge(2, 0);
		depthFirstSearch.addEdge(2, 3);
		depthFirstSearch.addEdge(3, 3);
	}
}
