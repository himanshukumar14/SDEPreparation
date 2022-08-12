package Array;

/**
 * 
 * You are given an array of N integers, A1, A2, .... AN.
 * 
 * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined
 * as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 * 
 * 
 * 
 * Problem Constraints 1 <= N <= 100000
 * 
 * -109 <= A[i] <= 109
 * 
 * 
 * 
 * Input Format First argument is an integer array A of size N.
 * 
 * 
 * 
 * Output Format Return an integer denoting the maximum value of f(i, j).
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 3, -1] Input 2:
 * 
 * 
 * A = [2]
 * 
 * 
 * Example Output Output 1:
 * 
 * 5 Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * f(1, 1) = f(2, 2) = f(3, 3) = 0 f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4 f(2, 3) = f(3, 2) = |3 - (-1)| +
 * |2 - 3| = 5
 * 
 * So, we return 5. Explanation 2:
 * 
 * Only possibility is i = 1 and j = 1. That gives answer = 0.
 *
 */

public class MaximumAbsoluteDifference {
	public int maxArr(int[] A) {
		int comp1 = Integer.MIN_VALUE;
		int comp2 = Integer.MIN_VALUE;
		int comp3 = Integer.MAX_VALUE;
		int comp4 = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; ++i) {
			comp1 = Math.max(comp1, A[i] + i);
			comp2 = Math.max(comp2, A[i] - i);
			comp3 = Math.min(comp3, A[i] + i);
			comp4 = Math.min(comp4, A[i] - i);
		}

		return Math.max(comp1 - comp3, comp2 - comp4);
	}
}
