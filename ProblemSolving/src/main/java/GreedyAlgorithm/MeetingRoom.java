package GreedyAlgorithm;

import java.util.Arrays;

/**
 * 
 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
 * determine if a person could attend all meetings.
 *
 * Example 1:
 * 
 * Input: intervals = [[0,30],[5,10],[15,20]] Output: false Example 2:
 * 
 * Input: intervals = [[7,10],[2,4]] Output: true
 *
 */

public class MeetingRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canAttendMeetings(int[][] intervals) {
		int len = intervals.length;
		if (len == 0)
			return true;
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		for (int i = 1; i < len; i++) {
			if (intervals[i][0] < intervals[i - 1][1])
				return false;
		}
		return true;
	}

}
