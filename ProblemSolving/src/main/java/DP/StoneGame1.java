package DP;

public class StoneGame1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] piles;
	int[][] mem;

	public boolean stoneGame(int[] piles) {
		int n = piles.length;
		this.piles = piles;
		this.mem = new int[n][n];

		int A = recur(0, n - 1);
		int B = total() - A;
		return A > B;
	}

	public int total() {
		int n = piles.length;
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += piles[i];
		}
		return sum;
	}

	public int recur(int left, int right) {
		if (left > right)
			return 0;
		if (mem[left][right] != 0)
			return mem[left][right];
		int val1 = piles[left] + Math.min(recur(left + 1, right - 1), recur(left + 2, right));
		int val2 = piles[right] + Math.min(recur(left, right - 2), recur(left + 1, right - 1));
		mem[left][right] = Math.max(val1, val2);
		return mem[left][right];
	}

	
	
	
	
	
	
	
	// From Tushar Roy video
	public boolean stoneGame2(int[] piles) {
		int n = piles.length;

		Pair[][] dp = new Pair[n][n];
		for (int i = 0; i < n; ++i) {
			dp[i][i] = new Pair(piles[i], 0);
		}

		for (int i = 0; i < n - 1; ++i) {
			dp[i][i + 1] = new Pair(Math.max(piles[i], piles[i + 1]), Math.min(piles[i], piles[i + 1]));
		}

		for (int k = 3; k <= n; ++k)
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				Pair x;
				if (dp[i + 1][j].second + piles[i] > piles[j] + dp[i][j - 1].second) {
					x = new Pair(dp[i + 1][j].second + piles[i], dp[i + 1][j].first);
				} else if (dp[i + 1][j].second + piles[i] == piles[j] + dp[i][j - 1].second) {
					if (dp[i][j - 1].first < dp[i + 1][j].first) {
						x = new Pair(dp[i][j - 1].second + piles[j], dp[i][j - 1].first);
					} else {
						x = new Pair(dp[i + 1][j].second + piles[i], dp[i + 1][j].first);
					}
				} else {
					x = new Pair(dp[i][j - 1].second + piles[j], dp[i][j - 1].first);
				}
				dp[i][j] = x;
			}
		return dp[0][n - 1].first > dp[0][n - 1].second;
	}

	class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

}
