package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example:
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 * 
 * Make sure the returned intervals are sorted.
 *
 */

public class MergeOverlappingInterval {

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> ans = new ArrayList<>();

		int curr = -1;

		for (int i = 0; i < intervals.length; ++i) {
			if (ans.isEmpty() || ans.get(curr)[1] < intervals[i][0]) {
				curr++;
				ans.add(intervals[i]);
			} else {
				ans.get(curr)[1] = Math.max(ans.get(curr)[1], intervals[i][1]);
			}
		}
		return ans.toArray(new int[ans.size()][]);
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		ArrayList<Interval> ans = new ArrayList<>();

		int curr = -1;

		for (int i = 0; i < intervals.size(); ++i) {
			if (ans.isEmpty() || ans.get(curr).end < intervals.get(i).start) {
				curr++;
				ans.add(intervals.get(i));
			} else {
				ans.get(curr).end = Math.max(ans.get(curr).end, intervals.get(i).end);
			}
		}
		return ans;
	}

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
