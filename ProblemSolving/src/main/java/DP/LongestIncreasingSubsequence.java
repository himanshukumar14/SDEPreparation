package DP;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n2)
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
		}

		int max = 1;
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	// O(logn) algo
	public int lengthOfLIS2(int[] nums) {
		int n = nums.length;
		List<Integer> l = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < n; ++i) {
			if (l.isEmpty() || l.get(l.size() - 1) < nums[i]) {
				l.add(nums[i]);
				max = Math.max(max, l.size());
			} else {
				int j = getFirstGreater(l, nums[i]);
				l.set(j, nums[i]);
			}
		}
		return max;
	}

	public int getFirstGreater(List<Integer> arr, int target) {
		int l = 0;
		int r = arr.size() - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr.get(mid) == target) {
				return mid;
			} else if (arr.get(mid) < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}
}
