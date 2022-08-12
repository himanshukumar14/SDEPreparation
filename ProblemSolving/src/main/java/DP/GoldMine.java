package DP;

public class GoldMine {

	public static void main(String[] args) {
		int[][] gold = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		int n = gold.length;
		int m = gold[0].length;
		System.out.println(getMaxGold(gold, n, m));
	}

	public static int getMaxGold(int[][] gold, int n, int m) {
		int[][] dp = new int[n][m];

		for (int i = 0; i < n; ++i) {
			dp[i][0] = gold[i][0];
		}

		for (int j = 1; j < m; ++j) {
			for (int i = 0; i < n; ++i) {
				int rightUp = 0;
				int rightDown = 0;
				int right = 0;
				if (i + 1 < n && j - 1 >= 0)
					rightUp = dp[i + 1][j - 1];

				if (i - 1 >= 0 && j - 1 >= 0)
					rightDown = dp[i - 1][j - 1];
				if (j - 1 >= 0)
					right = dp[i][j - 1];

				dp[i][j] = gold[i][j] + Math.max(rightUp, Math.max(rightDown, right));
			}
		}
		int maxGold = 0;
		for (int i = 0; i < n; ++i) {
			maxGold = Math.max(dp[i][m - 1], maxGold);
		}
		return maxGold;
	}
}
