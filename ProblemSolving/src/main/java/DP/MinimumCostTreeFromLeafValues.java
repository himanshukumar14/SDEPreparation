package DP;

/**
 * 
 * Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children.

 

Example 1:


Input: arr = [6,2,4]
Output: 32
Explanation: There are two possible trees shown.
The first has a non-leaf node sum 36, and the second has non-leaf node sum 32.
Example 2:


Input: arr = [4,11]
Output: 44
 

Constraints:

2 <= arr.length <= 40
1 <= arr[i] <= 15
It is guaranteed that the answer fits into a 32-bit signed integer (i.e., it is less than 2^31).
 *
 */

public class MinimumCostTreeFromLeafValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mctFromLeafValues(int[] arr) {
		int n = arr.length;
		Pair[][] dp = new Pair[n][n];
		return build(0, n - 1, arr, dp).sum;
	}

	// sum - max
	public Pair build(int l, int r, int[] arr, Pair[][] dp) {
		if (l > r)
			return new Pair(100000, 0);

		if (l == r)
			return new Pair(0, arr[l]);

		if (dp[l][r] != null) {
			return dp[l][r];
		}
		Pair curr = new Pair(100000, 0);
		for (int k = l; k < r; ++k) {
			Pair left = build(l, k, arr, dp);
			Pair right = build(k + 1, r, arr, dp);

			int total = left.sum + right.sum + left.max * right.max;
			if (total < curr.sum) {
				curr.sum = total;
				curr.max = Math.max(left.max, right.max);
			}
		}
		dp[l][r] = curr;
		return curr;
	}

	class Pair {
		int sum;
		int max;

		Pair(int sum, int max) {
			this.sum = sum;
			this.max = max;
		}
	}

}
