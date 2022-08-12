package Backtracking;

import java.util.ArrayList;
import java.util.List;

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
