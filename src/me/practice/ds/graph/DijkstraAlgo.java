package me.practice.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class DijkstraAlgo {
	public void solve(int[][] graph, int src) {
		int[] dist = new int[graph.length];
		boolean[] visited = new boolean[graph.length];

		for (int i = 0; i < graph.length; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		dist[0] = 0;

		for (int i = 0; i < graph.length; i++) {
			int minIndex = this.minIndex(dist, visited);
			visited[minIndex] = true;
			Integer[] adjacentVertexIndices = this.adjacentVertexIndices(graph, minIndex, visited);
			for (int j = 0; j < adjacentVertexIndices.length; j++) {
				if (graph[i][adjacentVertexIndices[j]] + dist[i] < dist[adjacentVertexIndices[j]]) {
					dist[i] = graph[i][adjacentVertexIndices[j]] + dist[i];
				}
			}
		}
	}

	private Integer[] adjacentVertexIndices(int[][] graph, int minIndex, boolean[] visited) {
		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			if (graph[minIndex][i] > 0 && !visited[i])
				indices.add(graph[minIndex][i]);
		}
		return indices.toArray(new Integer[0]);
	}

	private int minIndex(int[] dist, boolean[] visited) {
		int min = dist[0];
		int minIndex = 0;
		for (int i = 1; i < dist.length; i++) {
			if (!visited[i] && dist[i] < min) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}