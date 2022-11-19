package DP;

/**
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 *
 */

public class BestTimeToBuyAndSellStock3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int buy1 = Integer.MAX_VALUE;
		int buy2 = Integer.MAX_VALUE;
		int profit1 = 0;
		int profit2 = 0;
		for (int i = 0; i < prices.length; ++i) {
			buy1 = Math.min(buy1, prices[i]);
			profit1 = Math.max(profit1, prices[i] - buy1);
			buy2 = Math.min(buy2, prices[i] - profit1);
			profit2 = Math.max(profit2, prices[i] - buy2);
		}
		return profit2;
	}
}
