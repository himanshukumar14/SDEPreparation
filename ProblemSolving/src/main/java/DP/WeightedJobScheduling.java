package DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Given N jobs where every job is represented by following three elements of
 * it.
 * 
 * Start Time Finish Time Profit or Value Associated (>= 0) Find the maximum
 * profit subset of jobs such that no two jobs in the subset overlap.
 * 
 * Example:
 * 
 * Input: Number of Jobs n = 4 Job Details {Start Time, Finish Time, Profit} Job
 * 1: {1, 2, 50} Job 2: {3, 5, 20} Job 3: {6, 19, 100} Job 4: {2, 100, 200}
 * Output: The maximum profit is 250. We can get the maximum profit by
 * scheduling jobs 1 and 4. Note that there is longer schedules possible Jobs 1,
 * 2 and 3 but the profit with this schedule is 20+50+100 which is less than
 * 250.
 * 
 * A simple version of this problem is discussed here where every job has the
 * same profit or value. The Greedy Strategy for activity selection doesn’t work
 * here as a schedule with more jobs may have smaller profit or value.
 * 
 * The above problem can be solved using the following recursive solution.
 * 
 * 1) First sort jobs according to finish time. 2) Now apply following recursive
 * process. // Here arr[] is array of n jobs findMaximumProfit(arr[], n) { a) if
 * (n == 1) return arr[0]; b) Return the maximum of following two profits. (i)
 * Maximum profit by excluding current job, i.e., findMaximumProfit(arr, n-1)
 * (ii) Maximum profit by including the current job }
 * 
 * How to find the profit including current job? The idea is to find the latest
 * job before the current job (in sorted array) that doesn't conflict with
 * current job 'arr[n-1]'. Once we find such a job, we recur for all jobs till
 * that job and add profit of current job to result. In the above example, "job
 * 1" is the latest non-conflicting for "job 4" and "job 2" is the latest
 * non-conflicting for "job 3".
 *
 */

public class WeightedJobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int m = 4;
		// Job arr[] = new Job[m];
		// arr[0] = new Job(3, 10, 20);
		// arr[1] = new Job(1, 2, 50);
		// arr[2] = new Job(6, 19, 100);
		// arr[3] = new Job(2, 100, 200);
		// int n = arr.length;

	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job arr[] = new Job[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = new Job(startTime[i], endTime[i], profit[i]);
		}
		Arrays.sort(arr, new Comparator<Job>() {
			public int compare(Job j1, Job j2) {
				return j1.finish - j2.finish;
			}
		});

		int[] dp = new int[n];
		dp[0] = arr[0].profit;

		for (int i = 1; i < n; i++) {
			int includeCurrent = arr[i].profit;
			int l = latestNonConflict(arr, i);
			if (l != -1)
				includeCurrent += dp[l];
			dp[i] = Math.max(includeCurrent, dp[i - 1]);
		}
		return dp[n - 1];
	}

	public int latestNonConflict(Job arr[], int i) {
		for (int j = i - 1; j >= 0; j--) {
			if (arr[j].finish <= arr[i].start)
				return j;
		}
		return -1;
	}

	class Job {
		int start;
		int finish;
		int profit;

		public Job(int start, int finish, int profit) {
			this.start = start;
			this.finish = finish;
			this.profit = profit;
		}
	}
}
