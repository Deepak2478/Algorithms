package com.deep.greedy;

public class DijkstraShortestPath {

	static final int V = 9;
	
	public static void main(String args[])
	{
		int graph[][] = new int[][]{{0,4,0,0,0,0,0,8,0},
									{4,0,8,0,0,0,0,11,0},	
									{0,8,0,7,0,4,0,0,2},
									{0,0,7,0,9,14,0,0,0},
									{0,0,0,9,0,10,0,0,0},
									{0,0,4,14,10,0,2,0,0},
									{0,0,0,0,0,2,0,1,6},
									{8,11,0,0,0,0,1,0,7},
									{0,0,2,0,0,0,6,7,0}};
									
		DijkstraShortestPath djsp = new DijkstraShortestPath();
		djsp.findShortestPath(graph,0);
	}

	private void findShortestPath(int[][] graph, int src) {
		// The output array. dist[i] will hold the shortest distance
		// from src to i
		int dist[] = new int[V];
		//sptSet[i] will e true if vertex i is included in shortest path
		//tree or shortest distance from src to i is finalized
		Boolean sptSet[] = new Boolean[V];
		//Initialize all distances as infinite and sptSet[] as false
		for(int i=0; i<V; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		//distance of source vertex from itself is always zero
		dist[src] = 0;
		
		// find the shortest path of all vertices
		for(int count = 0; count < V-1 ; count++ )
		{
			// Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
			int u = minDistance(dist,sptSet);		
			//mark the picked vertex as processed
			sptSet[u] = true;
			//update distance values of adjacent vertices from
			//the picked vertex
			for(int v=0; v <V ; v++)
			{
				// update dist[v] only if it is not in sptSet, there is an
				//edge from u to v , and total weight of path from src to v
				//through u is smaller than the current value of dist[v]
				if(!sptSet[v] && graph[u][v]!=0 && 
					dist[u]	!= Integer.MAX_VALUE &&
					(dist[u] + graph[u][v] < dist[v]))
				{
					dist[v] = dist[u] + graph[u][v];
				}
			}		
		}
		printSolution(dist,V);
	}
	private void printSolution(int[] dist, int v2) {
		System.out.println("Vertex distance from source");
		for(int i=0; i<V ; i++)
		{
			System.out.println(i+1+"  \t\t "+ dist[i]);
		}		
	}

	// a utility function to find the vertex with minimum distance value,
	// from the set of vertices not yet included in the shortest path tree
	private int minDistance(int[] dist, Boolean[] sptSet) {
		
		//Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;
		
		for(int v =0; v<V; v++)
		{
			if(sptSet[v] == false && dist[v] <= min)
			{
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}
}
