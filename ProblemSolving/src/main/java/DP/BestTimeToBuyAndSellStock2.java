package DP;

/**
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day. On each day, you may decide to buy and/or sell the
 * stock. You can only hold at most one share of the stock at any time. However,
 * you can buy it then immediately sell it on the same day. Find and return the
 * maximum profit you can achieve.
 */

public class BestTimeToBuyAndSellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int profit = 0;
		int n = prices.length;
		int buy = prices[0];
		for (int i = 1; i < n; ++i) {
			if (prices[i] > buy) {
				profit += prices[i] - buy;
			}
			buy = prices[i];
		}
		return profit;
	}

}
