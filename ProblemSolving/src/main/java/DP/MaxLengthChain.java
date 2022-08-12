package DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * You are given N pairs of numbers. In every pair, the first number is always
 * smaller than the second number. A pair (c, d) can follow another pair (a, b)
 * if b < c. Chain of pairs can be formed in this fashion. You have to find the
 * longest chain which can be formed from the given set of pairs.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 5 P[] = {5 24 , 39 60 , 15 28 , 27 40 , 50 90} Output: 3
 * Explanation: The given pairs are { {5, 24}, {39, 60}, {15, 28}, {27, 40},
 * {50, 90} },the longest chain that can be formed is of length 3, and the chain
 * is {{5, 24}, {27, 40}, {50, 90}}
 * 
 * ​Example 2:
 * 
 * Input: N = 2 P[] = {5 10 , 1 11} Output: 1 Explanation:The max length chain
 * possible is only of length one.
 *
 */

public class MaxLengthChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class CompareByFirst implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return a.x - b.x;
		}
	}

	class Pair {
		int x;
		int y;
	}

	public int maxChainLength(Pair arr[], int n) {
		// Sort given pairs in increasing order of first (or smaller) element. Why do
		// not need sorting? Consider the example {{6, 8}, {3, 4}} to understand the
		// need of sorting. If we proceed to second step without sorting, we get output
		// as 1. But the correct output is 2.
		Arrays.sort(arr, new CompareByFirst());
		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[j].y < arr[i].x) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; ++i) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	// -------------------------------------------------------------------------------------------------------------------

	// This is equivalent to interval scheduling problem. We sort the array by
	// finishing time, choose the first one, discard all those that conflict, and
	// continue this process until the end.
	
	public int findLongestChain(int[][] pairs) {
	    Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
	    int count = 0, i = 0, n = pairs.length;
	    while (i < n) {
	        count++;
	        int curEnd = pairs[i][1];
	        while (i < n && pairs[i][0] <= curEnd) i++;
	    }
	    return count;
	}

}
