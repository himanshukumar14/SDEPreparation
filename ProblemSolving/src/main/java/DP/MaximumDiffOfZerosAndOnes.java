package DP;

import java.util.Arrays;

/**
 * 
 * Given a binary string S consisting of 0s and 1s. The task is to find the
 * maximum difference of the number of 0s and the number of 1s (number of 0s - number of 1s)
 * in the substrings of a string.
 * 
 * Note: In the case of all 1s, the answer will be -1.
 * 
 * Example 1:
 * 
 * Input : S = "11000010001" 
 * Output : 6 
 * Explanation: From index 2 to index 9,
 * there are 7 0s and 1 1s, so (number of 0s - number of 1s) is 6. 
 * 
 * Example 2:
 * 
 * Input: S = "111111" 
 * Output: -1 
 * Explanation: S contains 1s only
 *
 */

public class MaximumDiffOfZerosAndOnes {

	//using kadane's
	public static int findLength(String str, int n) {

		int current_sum = 0;
		int max_sum = 0;

		for (int i = 0; i < n; i++) {
			current_sum += (str.charAt(i) == '0' ? 1 : -1);
			max_sum = Math.max(current_sum, max_sum);
			if (current_sum < 0)
				current_sum = 0;
		}
		return max_sum == 0 ? -1 : max_sum;
	}

	// ----------------------------------------------------------------------------------------------
	//using DP
	int maxSubstring(String S) {
		// code here
		int n = S.length();
		Data[][] dp = new Data[n][n];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; ++i) {
			if (S.charAt(i) == '0')
				dp[i][i] = new Data(0, 1);
			else
				dp[i][i] = new Data(1, 0);
			max = Math.max(max, dp[i][i].zero - dp[i][i].one);
		}
		for (int i = 0; i < n - 1; ++i) {
			if (S.charAt(i) == S.charAt(i + 1) && S.charAt(i) == '0')
				dp[i][i + 1] = new Data(0, 2);
			else if (S.charAt(i) == S.charAt(i + 1) && S.charAt(i) == '1')
				dp[i][i + 1] = new Data(2, 0);
			else
				dp[i][i + 1] = new Data(1, 1);

			max = Math.max(max, dp[i][i + 1].zero - dp[i][i + 1].one);
		}

		for (int k = 3; k <= n; ++k) {
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				if (S.charAt(i) == S.charAt(j) && S.charAt(i) == '0')
					dp[i][j] = new Data(dp[i + 1][j - 1].one, dp[i + 1][j - 1].zero + 2);
				else if (S.charAt(i) == S.charAt(j) && S.charAt(i) == '1')
					dp[i][j] = new Data(dp[i + 1][j - 1].one + 2, dp[i + 1][j - 1].zero);
				else
					dp[i][j] = new Data(dp[i + 1][j - 1].one + 1, dp[i + 1][j - 1].zero + 1);

				max = Math.max(max, dp[i][j].zero - dp[i][j].one);

			}
		}
		if (dp[0][n - 1].zero == 0)
			return -1;
		return max;
	}

	class Data {
		int one;
		int zero;

		Data(int one, int zero) {
			this.one = one;
			this.zero = zero;
		}
	}

//---------------------------------------------------------------------------------------------------
	static final int MAX = 100;

	static boolean allones(String s, int n) {
		int co = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '1')
				co += 1;
		return (co == n);
	}

	static int findlength(int arr[], int ind, int st, int dp[][]) {
		if (ind >= arr.length)
			return 0;
		if (dp[ind][st] != -1)
			return dp[ind][st];

		if (st == 0)
			return dp[ind][st] = Math.max(arr[ind] + findlength(arr, ind + 1, 1, dp), findlength(arr, ind + 1, 0, dp));
		else
			return dp[ind][st] = Math.max(arr[ind] + findlength(arr, ind + 1, 1, dp), 0);
	}

	static int maxLen(String s, int n) {
		if (allones(s, n))
			return -1;

		int arr[] = new int[MAX];
		for (int i = 0; i < n; i++)
			arr[i] = (s.charAt(i) == '0' ? 1 : -1);

		int dp[][] = new int[MAX][3];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return findlength(arr, 0, 0, dp);
	}

	public static void main(String[] args) {
		String s = "11000010001";
		int n = 11;
		System.out.println(maxLen(s, n));
	}

}
