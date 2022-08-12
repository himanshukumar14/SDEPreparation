package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in
 * [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result
 * in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Make sure the returned intervals are also sorted.
 *
 */
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		ArrayList<Interval> ans = new ArrayList<>();
		int n = intervals.size();
		int j = 0;
		while (j < n) {
			if (ans.size() == 0 || ans.get(ans.size() - 1).end < intervals.get(j).start) {
				ans.add(intervals.get(j));
			} else {
				ans.get(ans.size() - 1).end = Math.max(intervals.get(j).end, ans.get(ans.size() - 1).end);
			}
			j++;
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
