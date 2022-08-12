package DP;

public class BestTimeToBuyAndSellStock1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int maxProfit = 0;
		int low = prices[0];
		for (int i = 1; i < n; ++i) {
			if (prices[i] >= low) {
				maxProfit = Math.max(maxProfit, prices[i] - low);
			} else {
				low = prices[i];
			}
		}
		return maxProfit;
	}

}
