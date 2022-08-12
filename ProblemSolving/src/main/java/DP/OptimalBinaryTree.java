package DP;

/**
 * 
 * Given a sorted array key [0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches for keys[i]. Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
Let us first define the cost of a BST. The cost of a BST node is the level of that node multiplied by its frequency. The level of the root is 1.

Examples:  

Input:  keys[] = {10, 12}, freq[] = {34, 50}
There can be following two possible BSTs 
        10                       12
          \                     / 
           12                 10
          I                     II
Frequency of searches of 10 and 12 are 34 and 50 respectively.
The cost of tree I is 34*1 + 50*2 = 134
The cost of tree II is 50*1 + 34*2 = 118 


Input:  keys[] = {10, 12, 20}, freq[] = {34, 8, 50}
There can be following possible BSTs
    10                12                 20         10              20
      \             /    \              /             \            /
      12          10     20           12               20         10  
        \                            /                 /           \
         20                        10                12             12  
     I               II             III             IV             V
Among all possible BSTs, cost of the fifth BST is minimum.  
Cost of the fifth BST is 1*50 + 2*34 + 3*8 = 142 
 *
 */

public class OptimalBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int keys[] = { 10, 12, 20 };
		int freq[] = { 34, 8, 50 };
		int n = keys.length;
		System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));
	}

	public static int optimalSearchTree(int[] keys, int[] freq, int n) {
		setSum(freq, n);
		cost = new int[n + 1][n + 1];
		return treeCost(freq, 0, n - 1);
	}

	public static int[][] cost;
	public static int[] prefix;

	public static int treeCost(int[] freq, int l, int r) {
		if (l > r)
			return 0;
		if (l == r)
			return cost[l][r] = freq[l];
		if (cost[l][r] != 0) {
			return cost[l][r];
		}
		// choosing the total sum once
		int fsum = getSum(l, r);
		int min = Integer.MAX_VALUE;

		for (int k = l; k <= r; ++k) { // choose k as root and calc extra cost for children
			int val = treeCost(freq, l, k - 1) + treeCost(freq, k + 1, r);
			min = Math.min(val, min);
		}
		cost[l][r] = fsum + min;
		return cost[l][r];
	}

	public static void setSum(int[] arr, int n) {
		prefix = new int[n + 1];
		for (int i = 1; i < n + 1; ++i) {
			prefix[i] = prefix[i - 1] + arr[i - 1];
		}
	}

	public static int getSum(int i, int j) {
		return prefix[j + 1] - prefix[i];
	}

	// -------------------------------------------------------------------------------------------------

	// Tushar Roy O(n3)

	public int optimalCost(int[] freq, int[] key, int n) {
		int[][] dp = new int[n][n];
		setSum(freq, n);
		for (int l = 2; l <= n; ++l) {
			for (int i = 0; i < n - l + 1; ++i) {
				int j = i + l - 1;
				int fsum = getSum(i, j);
				int min = Integer.MAX_VALUE;
				for (int k = i; k <= j; ++k) {
					int left = k - 1 < i ? 0 : dp[i][k - 1];
					int right = k + 1 > j ? 0 : dp[k + 1][j];
					min = Math.min(min, left + right);
				}
				dp[i][j] = fsum + min;
			}
		}
		return dp[0][n - 1];
	}
}
