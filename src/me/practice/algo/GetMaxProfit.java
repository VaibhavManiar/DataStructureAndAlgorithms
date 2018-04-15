package me.practice.algo;

import java.util.ArrayList;
import java.util.List;

public class GetMaxProfit {

	public static final int getMaxProfitDp(int price[], int n) {
		int[][] dp = new int[n][n];
		for (int size = 1; size <= n; ++size) {
			for (int i = 0; i <= n - size; ++i) {
				int j = i + size - 1;
				if (i == j) {
					dp[i][j] = 0;
				} else if (i + 1 == j) {
					dp[i][j] = price[j] - price[i];
				} else {
					dp[i][j] = price[j] - price[i];
					for (int k = i + 1; k < j; ++k) {
						dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
					}
				}
			}
		}
		printMatrix(dp);
		return dp[0][n - 1];
	}

	public static final int getMaxProfit(int[] prices) {
		int n = prices.length;
		int i = 0;
		List<ProfitOrLoss> profits = new ArrayList<>();
		int maxProfit = 0;
		while (i < n - 1) {

			while (i < n - 1 && prices[i] >= prices[i + 1])
				i++;

			if (i >= n - 1)
				break;

			ProfitOrLoss profit = new ProfitOrLoss();
			profit.buy = prices[i++];

			while (i < n - 1 && prices[i - 1] <= prices[i])
				i++;
			if (prices[i - 1] <= prices[i])
				profit.sell = prices[i];
			else
				profit.sell = prices[i - 1];

			profits.add(profit);
		}
		
		for (ProfitOrLoss val : profits)
			maxProfit += val.calculate();

		return maxProfit;
	}
	
	public static final int maxLoss (int[] prices) {
		int n = prices.length;
		int i = 0;
		List<ProfitOrLoss> losses = new ArrayList<>();
		int maxLoss = 0;
		while(i < n-1) {
			
			while(i < n-1 && prices[i] <= prices[i+1])
				i++;
			
			if (i >= n - 1)
				break;
			
			ProfitOrLoss loss = new ProfitOrLoss();
			loss.buy = prices[i++];
			
			
			while(i < n-1 && prices[i-1] >= prices[i])
				i++;
			
			if(i <= n-1 && prices[i-1] >= prices[i])
				loss.sell = prices[i];
			else
				loss.sell = prices[i-1];
				
			losses.add(loss);
		}
		
		for (ProfitOrLoss val : losses)
			maxLoss += val.calculate();

		return maxLoss * -1;
	}

	private static final void printMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int profit[] = { 100, 180, 260, 310, 40, 535, 695 };
		int n = profit.length;
		System.out.println(getMaxProfitDp(profit, n) == 210 + 655);

		System.out.println(getMaxProfit(profit) == 210 + 655);

		int newProfit[] = { 100, 180, 260, 310, 40, 535, 495 };
		n = newProfit.length;
		System.out.println(getMaxProfitDp(newProfit, n) == 210 + 495);

		System.out.println(getMaxProfit(newProfit) == 210 + 495);
		
		
		int loss[] = { 100, 180, 260, 310, 40, 535, 695 };
		n = loss.length;

		System.out.println(maxLoss(loss) == 270);

		int newLoss[] = { 100, 180, 260, 310, 40, 535, 495 };
		n = newLoss.length;
		System.out.println(maxLoss(newLoss) == 270 + 40);
	}

	private static class ProfitOrLoss {
		int buy;
		int sell;

		int calculate() {
			return this.sell - this.buy;
		}
	}
}
