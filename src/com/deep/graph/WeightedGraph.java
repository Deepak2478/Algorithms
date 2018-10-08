package com.deep.graph;

import java.util.LinkedList;

public class WeightedGraph {

	static class Edge{
		int source;
		int destination;
		int weight;
		public Edge(int source, int destination, int weight)
		{
			this.source = source;
			this.destination  =destination;
			this.weight =weight;
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
	
	
	public void addEdge(int source, int destination, int weight)
	{
		Edge edge = new Edge(source, destination, weight);
         adjecencyList[source].addFirst(edge);   
	}
	
	public void printGraph(){
		for(int i=0; i< vertices;i++)
		{
			LinkedList<Edge> list = adjecencyList[i];
			for(int j=0; j< list.size();j++)
			{
				System.out.println("Vertex "+i+"is connected to "+list.get(j).destination+" with weight :"+list.get(j).weight);
			}
		}
	}
	public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);
        graph.printGraph();
    }
}
}
