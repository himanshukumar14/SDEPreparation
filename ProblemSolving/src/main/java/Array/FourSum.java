package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * 0 <= a, b, c, d < n a, b, c, and d are distinct. nums[a] + nums[b] + nums[c]
 * + nums[d] == target You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,-1,0,-2,2], target = 0 Output:
 * [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] Example 2:
 * 
 * Input: nums = [2,2,2,2,2], target = 8 Output: [[2,2,2,2]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200 -109 <= nums[i] <= 109 -109 <= target <= 109
 *
 */

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int first = nums[i];
			for (int j = i + 1; j < n; ++j) {
				int second = nums[j];
				int l = j + 1;
				int r = n - 1;
				while (l < r) {
					long sum = (long) first + (long) second + (long) nums[l] + (long) nums[r];
					if (sum == target) {
						ans.add(Arrays.asList(first, second, nums[l], nums[r]));
						while (l + 1 <= r && nums[l] == nums[l + 1]) {
							l++;
						}
						l++;
						r--;
					} else if (sum > target) {
						r--;
					} else {
						l++;
					}
				}
				while (j + 1 < n && nums[j] == nums[j + 1]) {
					j++;
				}
			}
			while (i + 1 < n && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return ans;
	}

}
