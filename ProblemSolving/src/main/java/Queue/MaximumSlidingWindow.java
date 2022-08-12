package Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers A.  There is a sliding window of size B which 
 * is moving from the very left of the array to the very right. 
 * You can only see the w numbers in the window. Each time the sliding window moves 
 * rightwards by one position. You have to find the maximum for each window. 
 * The following example will give you more clarity.
 *
 * The array A is [1 3 -1 -3 5 3 6 7], and B is 3.
 * [1  3  -1] -3  5  3  6  7	3
 * 1 [3  -1  -3] 5  3  6  7	3
 * 1  3 [-1  -3  5] 3  6  7	5
 * 1  3  -1 [-3  5  3] 6  7	5
 * 1  3  -1  -3 [5  3  6] 7	6
 * 1  3  -1  -3  5 [3  6  7]	7
 * Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
 * 
 * Note: If B > length of the array, return 1 element with the max of the array.
*/
public class MaximumSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int B = 2;
		int[] ans = slidingMaximum(A, B);
		for (int x : ans) {
			System.out.println(x);
		}
	}

	public static int[] slidingMaximum(final int[] A, int B) {
		Deque<Integer> dq = new LinkedList<>();
		int n = A.length;
		int[] ans = new int[1];
		if (n >= B)
			ans = new int[n - B + 1];

		for (int i = 0; i < n; ++i) {
			if (!dq.isEmpty() && dq.getFirst() <= i - B)
				dq.pollFirst();
	
			while (!dq.isEmpty() && A[i] >= A[dq.getLast()]) {
				dq.pollLast();
			}
			
			dq.addLast(i);
			if (i >= B - 1)
				ans[i - B + 1] = A[dq.getFirst()];

			if (n < B && i == n - 1) // only for size is less that B
				ans[0] = A[dq.getFirst()];
		}
		return ans;
	}

}
