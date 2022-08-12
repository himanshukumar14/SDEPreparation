package Stack;

import java.util.Stack;

/**
 * 
 * Given an array of integers arr, find the sum of min(b), where b ranges over
 * every (contiguous) subarray of arr. Since the answer may be large, return the
 * answer modulo 109 + 7.
 * 
 * Example 1:
 * 
 * Input: arr = [3,1,2,4] Output: 17 Explanation: Subarrays are [3], [1], [2],
 * [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. Minimums are 3, 1, 2,
 * 4, 1, 1, 2, 1, 1, 1. Sum is 17. Example 2:
 * 
 * Input: arr = [11,81,94,43,3] Output: 444
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 3 * 104 1 <= arr[i] <= 3 * 104
 *
 */

public class SumOfSubarrayMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
	
	public int sumSubarrayMins(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		int[] ple = new int[n];
		int[] nle = new int[n];

		for (int i = 0; i < n; ++i) {
			while (!stack1.isEmpty() && arr[stack1.peek()] >= arr[i]) {
				stack1.pop();
			}
			ple[i] = stack1.isEmpty() ? -1 : stack1.peek();
			stack1.add(i);
		}

		for (int i = n - 1; i >= 0; --i) {
			while (!stack2.isEmpty() && arr[stack2.peek()] > arr[i]) {
				stack2.pop();
			}
			nle[i] = stack2.isEmpty() ? n : stack2.peek();
			stack2.add(i);
		}

		long sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += (nle[i] - i) * (i - ple[i]) * arr[i];
		}
		return (int) sum;
	}

}
