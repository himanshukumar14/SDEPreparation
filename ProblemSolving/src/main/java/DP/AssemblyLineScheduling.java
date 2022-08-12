package DP;

/**
 * 
 * The following information can be extracted from the problem statement to make
 * it simpler:
 * 
 * Two assembly lines, 1 and 2, each with stations from 1 to n. A car chassis
 * must pass through all stations from 1 to n in order(in any of the two
 * assembly lines). i.e. it cannot jump from station i to station j if they are
 * not at one move distance. The car chassis can move one station forward in the
 * same line, or one station diagonally in the other line. It incurs an extra
 * cost ti, j to move to station j from line i. No cost is incurred for movement
 * in same line. The time taken in station j on line i is ai, j. Si, j
 * represents a station j on line i.
 *
 */

public class AssemblyLineScheduling {

	public static void main(String[] args) {
		int a[][] = { { 4, 2 }, { 5, 10 }, { 3, 1 }, { 2, 4 } };
		int t[][] = { { 0, 0 }, { 7, 9 }, { 4, 2 }, { 5, 8 } };
		int e[] = { 10, 12 }, x[] = { 18, 7 };

		System.out.println(carAssembleTime(a, t, e, x));
	}

	public static int carAssembleTime(int a[][], int t[][], int e[], int x[]) {
		int n = a.length;
		int[][] dp = new int[n][2];
		dp[0][0] = a[0][0] + e[0];
		dp[0][1] = a[0][1] + e[1];
		for (int i = 1; i < n; ++i) {
			dp[i][0] = Math.min(dp[i - 1][1] + t[i][1], dp[i - 1][0]) + a[i][0];
			dp[i][1] = Math.min(dp[i - 1][0] + t[i][0], dp[i - 1][1]) + a[i][1];
		}
		dp[n - 1][0] += x[0];
		dp[n - 1][1] += x[1];
		return Math.min(dp[n - 1][0], dp[n - 1][1]);
	}

}
