package me.practice.algo.game;

import java.util.Scanner;

public class TicTacToeGame {

	final int size;
	int[][] board;
	boolean[][] visited;
	boolean flag = false;

	public TicTacToeGame(int size) {
		this.size = size;
		board = new int[this.size][this.size];
		visited = new boolean[this.size][this.size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = -1;
				visited[i][j] = false;
			}
		}
	}

	public void play() {
		int n = this.size * this.size;
		Scanner s = new Scanner(System.in);
		boolean isWon = false;
		while (n > 0 && !isWon) {
			String msg = flag ? "Player 2 please enter next cell number as i,j"
					: "Player 1 please enter next cell number as i,j";
			System.out.println(msg);
			String input = s.nextLine();
			String[] iArr = input.split(",");
			if (iArr.length < 2 || iArr.length > 2) {
				System.out.println("Incorrect input : " + input);
				continue;
			}
			int x = Integer.parseInt(iArr[0]);
			int y = Integer.parseInt(iArr[1]);
			if (flag)
				board[x][y] = 0;
			else
				board[x][y] = 1;
			flag = !flag;
			isWon = this.isWon();
			this.print();
		}
		s.close();
		if (isWon) {
			String msg = flag ? "Player 1 won.." : "Player 2 won..";
			System.out.println(msg);
			this.print();
		}
	}

	private void print() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] != -1)
					System.out.print(board[i][j]);
				else
					System.out.print("-");
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	private boolean isWon() {

		boolean isWon = true;
		int i;
		for (i = 0; i < size - 1; i++) {
			if (board[0][i] == -1 || board[0][i] != board[0][i + 1]) {
				isWon = false;
				break;
			}
		}

		if (i == 2)
			isWon = true;
		else
			i = 0;
		for (; i < size - 1 && !isWon; i++) {
			if (board[i][0] == -1 || board[i][0] != board[i + 1][0]) {
				isWon = false;
				break;
			}
		}

		if (i == 2)
			isWon = true;
		else
			i = 0;
		for (; i < size - 1 && !isWon; i++) {
			if (board[1][i] == -1 || board[1][i] != board[1][i + 1]) {
				isWon = false;
				break;
			}
		}

		if (i == 2)
			isWon = true;
		else
			i = 0;
		for (; i < size - 1 && !isWon; i++) {
			if (board[i][1] == -1 || board[i][1] != board[i + 1][1]) {
				isWon = false;
				break;
			}
		}

		if (i == 2)
			isWon = true;
		else
			i = 0;
		for (; i < size - 1 && !isWon; i++) {
			if (board[2][i] == -1 || board[2][i] != board[2][i + 1]) {
				isWon = false;
				break;
			}
		}

		if (i == 2)
			isWon = true;
		else
			i = 0;
		for (; i < size - 1 && !isWon; i++) {
			if (board[i][2] == -1 || board[i][2] != board[i + 1][2]) {
				isWon = false;
				break;
			}
		}

		if (i == 2)
			isWon = true;
		else
			i = 0;
		for (; i < size - 1 && !isWon; i++) {
			if (board[i][i] == -1 || board[i][i] != board[i + 1][i + 1]) {
				isWon = false;
				break;
			}
		}
		return isWon;
	}

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame(3);
		game.play();
	}

}
