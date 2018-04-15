package me.practice.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	LinkedList<Integer> adj[] = null;
	private final int V;

	public Graph(int v) {
		this.V = v;
		adj = new LinkedList[this.V];
		for (int i = 0; i < this.V; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int v, int e) {
		adj[v].add(e);
	}

	public void BFS(int s) {
		boolean[] visited = new boolean[this.V];
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.remove();
			if (!visited[v]) {
				LinkedList<Integer> ll = adj[v];
				ll.forEach(e -> {
					q.add(e);
				});
				System.out.println(v);
				visited[v] = true;
			}
		}
	}

	public void DFS(int s) {
		boolean[] visited = new boolean[this.V];
		this.DFS(s, visited);
	}

	public void DFS(int s, boolean[] visited) {
		System.out.println(s);
		visited[s] = true;
		Iterator<Integer> it = adj[s].iterator();
		while (it.hasNext()) {
			int v = it.next();
			if (!visited[v]) {
				DFS(v, visited);
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.BFS(2);
	}

}
