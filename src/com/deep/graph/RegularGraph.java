package com.deep.graph;

import java.util.LinkedList;

public class RegularGraph {

	static class Edge{
		int source;
		int destination;		
		public Edge(int source, int destination)
		{
			this.source = source;
			this.destination  =destination;			
		}
		
	}
	static class Graph{
		int vertices;
		LinkedList<Edge>[] adjecencyList;
		public Graph(int vertices)
		{
			this.vertices = vertices;
			adjecencyList = new LinkedList[vertices];
			for(int i=0; i<vertices; i++){
				adjecencyList[i] = new LinkedList<Edge>();
			}
		}
	
	
	public void addEdge(int source, int destination)
	{
		Edge edge = new Edge(source, destination);
         adjecencyList[source].addFirst(edge);   
	}
	
	public void printGraph(){
		for(int i=0; i< vertices;i++)
		{
			LinkedList<Edge> list = adjecencyList[i];
			for(int j=0; j< list.size();j++)
			{
				System.out.println("Vertex "+i+"is connected to "+list.get(j).destination);
			}
		}
	}
	public boolean detectCycle(){
		Boolean[] visited = new Boolean[vertices];
		Boolean[] revStack = new Boolean[vertices];
		for(int i=0; i<vertices;i++)
		{
			return isCycleDetected(i,visited,revStack);
		}
		
 		return false;
	}
	public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.printGraph();
    }

	public  boolean isCycleDetected(int i, Boolean[] visited, Boolean[] revStack) {
		
		if(revStack[i])
		{
			return true;
		}
		if(visited[i])
		{
			return false;
		}
		visited[i] = true;
		revStack[i] = false;
		LinkedList<Edge> children = adjecencyList[i];
		for(int c=0;c<children.size();c++)
		{
			if(isCycleDetected(c, visited, revStack))
			{
				return true;
			}
			
		}
		revStack[i] = false;
		return false;
	}
}
}