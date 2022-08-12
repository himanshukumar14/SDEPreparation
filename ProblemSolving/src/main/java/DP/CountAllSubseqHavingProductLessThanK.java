package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a positive array, find the number of subsequences having product
 * smaller than or equal to K. Examples:
 * 
 * Input : [1, 2, 3, 4] k = 10 Output :11 Explanation: The subsequences are {1},
 * {2}, {3}, {4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {1, 2, 3}, {1, 2, 4}
 * 
 * Input : [4, 8, 7, 2] k = 50 Output : 9
 *
 */

// similar as coin change or 0/1 knapsack
public class CountAllSubseqHavingProductLessThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		int k = 10;
		System.out.println(productSubSeqCount(A, k));
	}

	public static int productSubSeqCount(List<Integer> arr, int product) {
		int n = arr.size();
		int dp[][] = new int[n + 1][product + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= product; j++) {
				if (arr.get(i - 1) <= j && arr.get(i - 1) > 0)
					dp[i][j] += dp[i - 1][j / arr.get(i - 1)] + 1;
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][product];
	}

}
