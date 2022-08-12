package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
 * with a number on it represented by an array nums. You are asked to burst all
 * the balloons.
 * 
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i +
 * 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as
 * if there is a balloon with a 1 painted on it.
 * 
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,5,8] Output: 167 Explanation: nums = [3,1,5,8] --> [3,5,8]
 * --> [3,8] --> [8] --> [] coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * 
 * Example 2:
 * 
 * Input: nums = [1,5] Output: 10
 *
 */

public class BurstBalloons {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 1, 5, 8 };
		System.out.println(maxCoins(nums));
	}

	public static int maxCoins(int[] nums) {
		int n = nums.length;
		Pair[][] dp = new Pair[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				dp[i][j] = new Pair(0, 0);
			}
		}

		for (int l = 1; l <= n; ++l) {
			for (int i = 0; i < n - l + 1; ++i) {
				int j = i + l - 1;
				// let's burst kth balloon at last
				for (int k = i; k <= j; ++k) {
					int coinCollectedFromLeft = 0;
					int coinCollectedFromRight = 0;
					if (k != i)
						coinCollectedFromLeft = dp[i][k - 1].sum;
					if (k != j)
						coinCollectedFromRight = dp[k + 1][j].sum;
					int left = 1;
					int right = 1;
					if (i - 1 >= 0)
						left = nums[i - 1];
					if (j + 1 < n)
						right = nums[j + 1];
					int last = left * nums[k] * right;
					if (dp[i][j].sum < coinCollectedFromLeft + coinCollectedFromRight + last) {
						dp[i][j].sum = coinCollectedFromLeft + coinCollectedFromRight + last;
						dp[i][j].index = k;
					}
				}
			}
		}
		getBurstOrder(nums, dp, 0, n - 1);
		for (int i = order.size() - 1; i >= 0; --i) {
			System.out.println(order.get(i));
		}
		return dp[0][n - 1].sum;
	}

	public static List<Integer> order = new ArrayList<>();

	// for tracking the order
	public static void getBurstOrder(int[] nums, Pair[][] dp, int l, int r) {
		if (l > r)
			return;
		int k = dp[l][r].index;
		order.add(nums[k]);
		getBurstOrder(nums, dp, l, k - 1);
		getBurstOrder(nums, dp, k + 1, r);
	}

	static class Pair {
		int sum;
		int index;

		Pair(int sum, int index) {
			this.sum = sum;
			this.index = index;
		}
	}

}
