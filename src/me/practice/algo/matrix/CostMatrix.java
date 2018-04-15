package me.practice.algo.matrix;

public class CostMatrix {
	
	/**
	 * 
	 * @param m
	 * @param n
	 */
	public static final void numberOfWaysToReachMN(int m, int n) {
		int matrix[][] = new int[m][n];
		matrix[0][0] = 1;
		for(int i=1;i<m;i++) {
			matrix[i][0] = 1;
		}
		
		for(int i=1;i<m;i++) {
			matrix[0][i] = 1;
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
			}
		}
		printMatrix(matrix);
		System.out.println(matrix[m-1][n-1]);
	}
	
	public static final void minCost(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int costMatrix[][] = new int[m][n];
		costMatrix[0][0] = matrix[0][0];
		
		for(int i=1;i<m;i++) {
			costMatrix[i][0] = costMatrix[i-1][0] + matrix[i][0];
		}
		
		for(int i=1;i<m;i++) {
			costMatrix[0][i] = costMatrix[0][i-1] + matrix[0][i];
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				costMatrix[i][j] = Math.min(costMatrix[i-1][j], costMatrix[i][j-1]) + matrix[i][j];
			}
		}
		
		printMatrix(costMatrix);
	}
	
	public static final void maxCost(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int costMatrix[][] = new int[m][n];
		costMatrix[0][0] = matrix[0][0];
		
		for(int i=1;i<m;i++) {
			costMatrix[i][0] = costMatrix[i-1][0] + matrix[i][0];
		}
		
		for(int i=1;i<m;i++) {
			costMatrix[0][i] = costMatrix[0][i-1] + matrix[0][i];
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				costMatrix[i][j] = Math.max(costMatrix[i-1][j], costMatrix[i][j-1]) + matrix[i][j];
			}
		}
		
		printMatrix(costMatrix);
	}
	
	private static final void printMatrix (int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		numberOfWaysToReachMN(4, 4);
		
		int matrix[][] = 
				{{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
		minCost(matrix);
		maxCost(matrix);
	}
}
