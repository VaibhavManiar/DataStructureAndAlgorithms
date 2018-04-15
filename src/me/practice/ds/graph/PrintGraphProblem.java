package me.practice.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintGraphProblem {
	LinkedList<Integer>[] graph;
	private int pathCount = 0;
	@SuppressWarnings("unchecked")
	public PrintGraphProblem(int size) {
		graph = new LinkedList[size];
		for (int e = 0; e < size; e++) {
			graph[e] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int e) {
		graph[v].add(e);
	}

	public void printAllPaths() {
		List<Integer> indices = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			indices.add(i);
		}
		for (int index : this.getAllStartPoints(indices)) {
			List<Integer> list = new ArrayList<>();
			boolean[] visited = new boolean[graph.length];
			this.printAllPaths(index, list, visited);
		}
		System.out.println("Paths count : " + pathCount);
	}

	private void printAllPaths(int index, List<Integer> list, boolean[] visited) {
		if (graph == null)
			return;
		visited[index] = true;
		list.add(index);
		List<Integer> adj = getAdjacentIndicies(index);
		if (adj == null || adj.size() <= 0) {
			this.print(list);
			pathCount++;
		}
		for (Integer e : adj) {
			if (!visited[e]) {
				printAllPaths(e, list, visited);
				list.remove(e);
			}
		}
		visited[index] = false;
	}

	private List<Integer> getAllStartPoints(List<Integer> indices) {
		for (int i = 0; i < graph.length; i++) {
			for (Integer j : graph[i]) {
				indices.remove(j);
			}
		}
		return indices;
	}

	private void print(List<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " -> ");
		}
		System.out.println();
	}

	private List<Integer> getAdjacentIndicies(int index) {
		return graph[index];
	}

	public static void main(String[] args) {
		PrintGraphProblem problem = new PrintGraphProblem(6);
		problem.addEdge(0, 1);
		problem.addEdge(0, 2);
		problem.addEdge(5, 2);
		problem.addEdge(1, 3);
		problem.addEdge(1, 4);
		problem.addEdge(2, 4);

		problem.printAllPaths();
	}
}
