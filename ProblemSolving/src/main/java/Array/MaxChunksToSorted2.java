package Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * You are given an integer array arr.
 * 
 * We split arr into some number of chunks (i.e., partitions), and individually
 * sort each chunk. After concatenating them, the result should equal the sorted
 * array.
 * 
 * Return the largest number of chunks we can make to sort the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [5,4,3,2,1] Output: 1 Explanation: Splitting into two or more
 * chunks will not return the required result. For example, splitting into [5,
 * 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted. Example 2:
 * 
 * Input: arr = [2,1,3,4,4] Output: 4 Explanation: We can split into two chunks,
 * such as [2, 1], [3, 4, 4]. However, splitting into [2, 1], [3], [4], [4] is
 * the highest number of chunks possible.
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 2000 0 <= arr[i] <= 10^8 Number can be duplicates
 */

public class MaxChunksToSorted2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxChunksToSorted(int[] arr) {
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			int curmax = st.isEmpty() ? arr[i] : Math.max(st.peek(), arr[i]);
			while ((!st.isEmpty()) && (st.peek() > arr[i]))
				st.pop();
			st.push(curmax);
		}
		return st.size();
	}

	// O(n2)
	public int maxChunksToSortednew(int[] arr) {
		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		int res = 0, sum1 = 0, sum2 = 0;
		for (int i = 0; i < arr.length; i++) {
			sum1 += arr[i];
			sum2 += sorted[i];
			if (sum1 == sum2)
				res += 1;
		}
		return res;
	}

	// O(n)
	public int maxChunksToSortednew2(int[] arr) {
		int n = arr.length;
		int[] leftMax = new int[n + 1];
		int[] rightMin = new int[n + 1];
		leftMax[0] = arr[0];
		for (int i = 1; i < n; ++i) {
			leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
		}
		rightMin[n] = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; --i) {
			rightMin[i] = Math.min(arr[i], rightMin[i + 1]);
		}
		int count = 0;
		for (int i = 0; i < n; ++i) {
			if (leftMax[i] <= rightMin[i + 1]) {
				count++;
			}
		}
		return count;
	}

}
