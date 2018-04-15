package me.practice.algo.dp;

public class KnapSackProblem {
	private final int[] W;
	private final int[] V;
	private final int[][] arr;

	public KnapSackProblem(int[] W, int[] V, int C) {
		this.W = W;
		this.V = V;
		arr = new int[V.length + 1][C + 1];
	}

	int result = 0;

	public int solve(int n, int C) {
		if (n <= 0 || C <= 0)
			return 0;
		else if (arr[n][C] > 0)
			return arr[n][C];
		else if (W[n - 1] > C)
			result = solve(n - 1, C);
		else {
			int tmp1 = solve(n - 1, C);
			int tmp2 = V[n - 1] + solve(n - 1, C - W[n - 1]);
			result = Math.max(tmp1, tmp2);
			arr[n][C] = result;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] V = { 5, 3, 5, 3, 2 };
		int[] W = { 1, 2, -4, 2, 5 };
		int n = V.length;
		int C = 10;
		KnapSackProblem kc = new KnapSackProblem(W, V, C);
		int result = kc.solve(n, C);
		System.out.println(kc.arr);
		System.out.println(result);

	}
}
