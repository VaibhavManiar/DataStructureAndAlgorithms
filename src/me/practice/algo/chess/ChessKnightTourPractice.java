package me.practice.algo.chess;

public class ChessKnightTourPractice {
	int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
	final int chessboardSize = 8;
	final int[][] chessboard = new int[8][8];
	final int defaultValue = Integer.MIN_VALUE;
	final int maxNoOfMoves = chessboardSize * chessboardSize;

	private int nextX(int x, int index) {
		return x + xMoves[index];
	}

	private int nextY(int y, int index) {
		return y + yMoves[index];
	}

	private boolean isValidMove(int stepcount, int x, int y) {
		if (x < 0 || x >= this.chessboardSize)
			return false;
		if (y < 0 || y >= this.chessboardSize)
			return false;
		if (this.chessboard[x][y] != this.defaultValue)
			return false;

		return true;
	}

	private boolean move(int stepcount, int x, int y) {
		if (stepcount == maxNoOfMoves) {
			return true;
		}

		for (int i = 0; i < chessboardSize; ++i) {
			int nextX = this.nextX(x, i);
			int nextY = this.nextY(y, i);

			if (this.isValidMove(stepcount, nextX, nextY)) {
				chessboard[nextX][nextY] = stepcount;
				if (this.move(stepcount + 1, nextX, nextY)) {
					return true;
				}

				this.chessboard[nextX][nextY] = this.defaultValue;
			}
		}

		return false;
	}

	public boolean move() {
		int stepcount = 0;
		// starting point 0,0
		int x = 0;
		int y = 0;

		// assign default values
		for (int i = x; i < chessboardSize; i++)
			for (int j = y; j < chessboardSize; ++j)
				chessboard[i][j] = defaultValue;

		chessboard[0][0] = stepcount;
		return move(stepcount + 1, x, y);
	}

}
