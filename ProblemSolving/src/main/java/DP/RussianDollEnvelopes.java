package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi]
 * represents the width and the height of an envelope.
 * 
 * One envelope can fit into another if and only if both the width and height of
 * one envelope are greater than the other envelope's width and height.
 * 
 * Return the maximum number of envelopes you can Russian doll (i.e., put one
 * inside the other).
 * 
 * Note: You cannot rotate an envelope.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]] Output: 3 Explanation: The
 * maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] =>
 * [6,7]). Example 2:
 * 
 * Input: envelopes = [[1,1],[1,1],[1,1]] Output: 1
 *
 */

public class RussianDollEnvelopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// sort the envelopes in increasing order of length and if length equal, sort on
	// width in decreasing order
	/**
	 * 
	 * 
	 * Now why we need to sort in decreasing order if two widths are same. By this
	 * practice, we're assuring that no width will get counted more than one time.
	 * Let's take an example envelopes=[[3, 5], [6, 7], [7, 13], [6, 10], [8, 4],
	 * [7, 11]] image Now, if you see for a while, 6 and 7 is counted twice while
	 * we're calculating the length of LIS, which will give the wrong ans. As
	 * question is asking, if any width/height are less than or equal, then, it is
	 * not possible to russian doll these envelopes. Now, we know the problem. So,
	 * how can we tackle these conditions when two width are same, so that it won't
	 * affect our answer. We can simple reverse sort the height if two width are
	 * equal, to remove duplicacy. Now, you may question, how reverse sorting the
	 * height would remove duplicacy? As the name itself says, Longest Increasing
	 * Subsequnce, the next coming height would be less than the previous one.
	 * Hence, forbidding it to increase length count.
	 * 
	 */
	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		int n = envelopes.length;
		List<Integer> l = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < n; ++i) {
			if (l.isEmpty() || l.get(l.size() - 1) < envelopes[i][1]) {
				l.add(envelopes[i][1]);
				max = Math.max(max, l.size());
			} else {
				int j = getFirstGreater(l, envelopes[i][1]);
				l.set(j, envelopes[i][1]);
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
