package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * You are given n activities with their start and finish times. Select the
 * maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 * 
 * 
 * Example:
 * 
 * Example 1 : Consider the following 3 activities sorted by finish time.
 * start[] = {10, 12, 20}; finish[] = {20, 25, 30}; A person can perform at most
 * two activities. The maximum set of activities that can be executed is {0, 2}
 * [ These are indexes in start[] and finish[] ]
 * 
 * Example 2 : Consider the following 6 activities sorted by by finish time.
 * start[] = {1, 3, 0, 5, 8, 5}; finish[] = {2, 4, 6, 7, 9, 9}; A person can
 * perform at most four activities. The maximum set of activities that can be
 * executed is {0, 1, 3, 4} [ These are indexes in start[] and finish[] ]
 * 
 *
 */

public class IntervalScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Activity {
		int start;
		int finish;

		public Activity(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
	}

	public void printMaxActivities(Activity arr[], int n) {
		Arrays.sort(arr, new Comparator<Activity>() {
			@Override
			public int compare(Activity s1, Activity s2) {
				return s1.finish - s2.finish;
			}
		});

		int i = 0;
		for (int j = 1; j < n; j++) {
			if (arr[j].start >= arr[i].finish) {
				System.out.print("(" + arr[j].start + ", " + arr[j].finish + "), ");
				i = j;
			}
		}

	}
}
