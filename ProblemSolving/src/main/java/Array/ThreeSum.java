package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Example 2:
 * 
 * Input: nums = [] Output: [] Example 3:
 * 
 * Input: nums = [0] Output: []
 *
 * 
 */

public class ThreeSum {

	// Two possible ways - 1) either select an index i and run two sum on rest
	// 2) SOrt the array and fix an index i and ten run two pointer
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> threeSum(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0)
				break; // Since arr[i] <= arr[l] <= arr[r], if a[i] > 0 then sum=arr[i]+arr[l]+arr[r] >0
						
			int l = i + 1;
			int r = n - 1;
			while (l < r) {
				int sum = arr[i] + arr[l] + arr[r];
				if (sum < 0)
					l++;
				else if (sum > 0)
					r--;
				else {
					ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
					while (l + 1 <= r && arr[l] == arr[l + 1])
						l++; // Skip duplicate nums[l]
					l++;
					r--;
				}
			}
			while (i + 1 < n && arr[i + 1] == arr[i])
				i++; // Skip duplicate nums[i]
		}
		return ans;
	}

}
