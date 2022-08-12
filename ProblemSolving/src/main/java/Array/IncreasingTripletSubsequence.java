package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an integer array nums, return true if there exists a triple of indices
 * (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such
 * indices exists, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5] Output: true Explanation: Any triplet where i < j <
 * k is valid. Example 2:
 * 
 * Input: nums = [5,4,3,2,1] Output: false Explanation: No triplet exists.
 * Example 3:
 * 
 * Input: nums = [2,1,5,0,4,6] Output: true Explanation: The triplet (3, 4, 5)
 * is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 105 -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow up: Could you implement a solution that runs in O(n) time complexity
 * and O(1) space complexity?
 *
 */

public class IncreasingTripletSubsequence {
	// use the concept of LIS
	public boolean increasingTriplet(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			if (ans.isEmpty() || ans.get(ans.size() - 1) < nums[i]) {
				ans.add(nums[i]);
			} else {
				int j = findFirstGreater(nums[i], ans);
				ans.set(j, nums[i]);
			}
			if (ans.size() == 3)
				return true;
		}
		return false;
	}

	public int findFirstGreater(int target, List<Integer> arr) {
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
	// -----------Alternate
	// Solution------------------------------------------------------------------------

	public boolean increasingTriplet2(int[] nums) {
		// start with two largest values, as soon as we find a number bigger than both,
		// while both have been updated, return true.
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} // update small if n is smaller than both
			else if (n <= big) {
				big = n;
			} // update big only if greater than small but smaller than big
			else
				return true; // return if you find a number bigger than both
		}
		return false;
	}
}
