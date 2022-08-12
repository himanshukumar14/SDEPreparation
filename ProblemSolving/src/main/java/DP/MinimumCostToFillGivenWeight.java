package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array cost[] of positive integers of size N and an integer W,
 * cost[i] represents the cost of ‘i’ kg packet of oranges, the task is to find
 * the minimum cost to buy W kgs of oranges. If it is not possible to buy
 * exactly W kg oranges then the output will be -1
 * 
 * Note: 1. cost[i] = -1 means that ‘i’ kg packet of orange is unavailable 2. It
 * may be assumed that there is infinite supply of all available packet types.
 * 
 * Example 1:
 * 
 * Input: N = 5, arr[] = {20, 10, 4, 50, 100} W = 5 Output: 14 Explanation:
 * choose two oranges to minimize cost. First orange of 2Kg and cost 10. Second
 * orange of 3Kg and cost 4. Example 2:
 * 
 * Input: N = 5, arr[] = {-1, -1, 4, 3, -1} W = 5 Output: -1 Explanation: It is
 * not possible to buy 5 kgs of oranges
 *
 * 
 */

public class MinimumCostToFillGivenWeight {

	//Unbounded Knapsack
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumCost(int cost[], int n, int W) {
		int mod = 1000000007;

		List<Integer> val = new ArrayList<>();
		List<Integer> wt = new ArrayList<>();

		int size = 0;
		for (int i = 0; i < n; i++) {
			if (cost[i] != -1) {
				val.add(cost[i]);
				wt.add(i + 1);
				size++;
			}
		}

		n = size;
		int min_cost[][] = new int[n + 1][W + 1];

		for (int i = 0; i <= W; i++)
			min_cost[0][i] = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++)
			min_cost[i][0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (j - wt.get(i - 1) >= 0)
					min_cost[i][j] = Math.min(min_cost[i - 1][j] % mod,
							((min_cost[i][j - wt.get(i - 1)]) % mod + val.get(i - 1) % mod) % mod);
				else
					min_cost[i][j] = min_cost[i - 1][j] % mod;
			}
		}

		return (min_cost[n][W] == Integer.MAX_VALUE) ? -1 : min_cost[n][W];
	}

}
