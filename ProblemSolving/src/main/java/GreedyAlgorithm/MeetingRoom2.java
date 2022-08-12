package GreedyAlgorithm;

import java.util.Arrays;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required. Example 1: Input: [[0, 30],[5, 10],[15, 20]] Output: 2 Example 2:
 * Input: [[7,10],[2,4]] Output: 1 NOTE: input types have been changed on April
 * 15, 2019. Please reset to default code definition to get new method
 * signature.
 *
 */

public class MeetingRoom2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxMeetings(int start[], int end[], int n) {
		Arrays.sort(start);
		Arrays.sort(end);

		int i = 0;
		int j = 0;
		int count = 0;
		int max = 0;
		while (i < n) {
			if (start[i] < end[j]) {
				count++;
				max = Math.max(max, count);
				i++;
			} else {
				count--;
				j++;
			}
		}
		return max;
	}

}
