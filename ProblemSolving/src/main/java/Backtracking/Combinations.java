package Backtracking;

import java.util.ArrayList;
/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

Constraints:

1 <= n <= 20
1 <= k <= n
 */

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<Integer> l = new ArrayList<>();
		recur(B, l, 1, A);
		return ans;
	}

	public void recur(int B, ArrayList<Integer> l, int start, int end) {
		if (l.size() == B) {
			ans.add(new ArrayList<Integer>(l));
		}
		for (int i = start; i <= end; ++i) {
			if (l.size() < B) {
				l.add(i);
				recur(B, l, i + 1, end);
				l.remove(l.size() - 1);
			}
		}
	}
}
