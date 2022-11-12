package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsets(new int[] { 1, 2, 3 });
		for(int  i = 0; i < ans.size(); ++i) {
			for(int j = 0; j < ans.get(i).size(); ++j) {
				System.out.print(ans.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {
		int n = nums.length;
		recur(0, n - 1, nums, new ArrayList<>());
		return ans;
	}

	static List<List<Integer>> ans = new ArrayList<>();

	public static void recur(int l, int r, int[] nums, List<Integer> list) {
		ans.add(new ArrayList<>(list));
		if (l == r + 1)
			return;

		for (int i = l; i <= r; ++i) {
			list.add(nums[i]);
			recur(i + 1, r, nums, list);
			list.remove(list.size() - 1);
		}
	}

}
