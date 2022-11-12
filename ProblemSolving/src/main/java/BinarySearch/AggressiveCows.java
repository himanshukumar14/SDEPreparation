package BinarySearch;

import java.util.Arrays;

/**
 * 
 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The
 * stalls are located along a straight line at positions x1,...,xN (0 <= xi <=
 * 1,000,000,000).
 * 
 * His C (2 <= C <= N) cows don't like this barn layout and become aggressive
 * towards each other once put into a stall. To prevent the cows from hurting
 * each other, FJ wants to assign the cows to the stalls, such that the minimum
 * distance between any two of them is as large as possible. What is the largest
 * minimum distance? Input t  the number of test cases, then t test cases
 * follows. Line 1: Two space-separated integers: N and C Lines 2..N+1: Line i+1
 * contains an integer stall location, xi Output For each test case output one
 * integer: the largest minimum distance. Example Input:
 * 
 * 1 5 3 1 2 8 4 9
 *
 * Output:
 * 3
 *
 * Output details:
 * FJ can put his 3 cows in the stalls at positions 1, 4 and 8, resulting in a
 * minimum distance of 3.
 *
 * 
 */

public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3,4,5};
		int cow = 3;
		System.out.println(solve(arr, cow));
	}

	public static int solve(int[] A, int B) {
		Arrays.sort(A);
		if (A.length == 2)
			return (A[1] - A[0]);
		int n = A.length;
		int min = 0;
		int max = A[n - 1] - A[0];
		int bigmax = -1;

		while (min <= max) {
			int mid = min + ((max - min) / 2);
			if (place(A, mid, B)) {
				bigmax = Math.max(bigmax, mid);
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return (int) bigmax;
	}

	public static boolean place(int[] A, int gap, int B) {
		int cows = 1;
		int pos = A[0];
		for (int i = 1; i < A.length; ++i) {
			if (A[i] - pos >= gap) {
				pos = A[i];
				cows++;
				if (cows == B)
					return true;
			}
		}
		return false;
	}
}
