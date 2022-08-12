package DP;

/**
 * 
 * Given a height h, count and return the maximum number of balanced binary
 * trees possible with height h. A balanced binary tree is one in which for
 * every node, the difference between heights of left and right subtree is not
 * more than 1. Examples :
 * 
 * 
 * Input : h = 3 Output : 15
 * 
 * Input : h = 4 Output : 315
 *
 */

/**
 * 
 * Height of tree, h = 1 + max(left height, right height) Since the difference
 * between the heights of left and right subtree is not more than one, possible
 * heights of left and right part can be one of the following:
 * 
 * 
 * (h-1), (h-2) (h-2), (h-1) (h-1), (h-1)
 * 
 * 
 * count(h) = count(h-1) * count(h-2) + count(h-2) * count(h-1) + count(h-1) *
 * count(h-1) = 2 * count(h-1) * count(h-2) + count(h-1) * count(h-1) =
 * count(h-1) * (2*count(h - 2) + count(h - 1))
 *
 */

public class CountOfBalancedBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countOfBinaryTree(3));
	}

	public static int countOfBinaryTree(int h) {
		int[] dp = new int[h + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < h + 1; ++i) {
			dp[i] = dp[i - 1] * dp[i - 2] + dp[i - 2] * dp[i - 1] + dp[i - 1] * dp[i - 1];
		}
		return dp[h];
	}

}
