package com.deep.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {
	
	private int V; // no. of vertices
	private LinkedList<Integer> adj[]; //adjacency lists
	public BreadthFirstSearch(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i)
		{
			adj[i] = new LinkedList();
		}
	}
	
	//function to add an edge into the graph
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	// prints BFS traversal from a given source
	void BFS(int s)
	{
	//Mark all the vertices as not visited(by default, set as false)
		boolean[] visited = new boolean[V];
		
	// create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();
	
	// mark the current node as visited and enque it
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0)
		{
			// dequeue a vertex from a queue and print it
			s= queue.poll();
			System.out.print(s+" ");
			
			// get all the adjacent vertices of the dequeued vertex s
			// If an adjacent node has not been visited, then mark it visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	
	public static  void main(String args[])
	{
		BreadthFirstSearch bfs = new BreadthFirstSearch(4);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);
		
		System.out.println("Breadth traversal from starting vertex 2");
	}
}
