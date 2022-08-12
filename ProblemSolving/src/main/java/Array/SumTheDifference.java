package Array;

import java.util.Arrays;

/**
 * 
 * Given an integer array, A of size N. You have to find all possible non-empty
 * subsequences of the array of numbers and then, for each subsequence, find the
 * difference between the largest and smallest numbers in that subsequence. Then
 * add up all the differences to get the number.
 * 
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 * 
 * NOTE: Subsequence can be non-contiguous.
 * 
 * 
 * 
 * Problem Constraints 1 <= N <= 10000
 * 
 * 1<= A[i] <=1000
 * 
 * 
 * 
 * Input Format First argument is an integer array A.
 * 
 * 
 * 
 * Output Format Return an integer denoting the output.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 2] Input 2:
 * 
 * A = [1]
 * 
 * 
 * Example Output Output 1:
 * 
 * 1 Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * All possible non-empty subsets are: [1] largest-smallest = 1 - 1 = 0 [2]
 * largest-smallest = 2 - 2 = 0 [1 2] largest-smallest = 2 - 1 = 1 Sum of the
 * differences = 0 + 0 + 1 = 1 So, the resultant number is 1 Explanation 2:
 * 
 * Only 1 subsequence of 1 element is formed.
 */

public class SumTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Logic - Observations 1: Order doesn't matter Observations 2: Every numbers
	 * contribute based on its index in the sorted array.
	 * 
	 * Mathematical Derivations - Consider that there are total (n) number in a
	 * sorted array, then (i) numbers will be <= nums[i] and (n-i-1) numbers will be
	 * >= A[i]
	 * 
	 * A[i] will be upper bound of (2^i) subsequences <-------- when A[i] as maxm
	 * value A[i] will be lower bound of (2^(n-i-1)) subsequences <-------- when
	 * A[i] as minm value
	 * 
	 * so, contribution of A[i] = upper - lower = A[i]*(2^i) - A[i]*(2^(n-i-1))
	 * 
	 * Ans = Sum{A[i]* 2^i - A[i] * 2^(n-i-1)} , for 0 <= i < n = (A[0]*2^0 -
	 * A[0]*2^(n-1) + (A[1]*2^1 - A[1]*2^(n-2) + ... + (A[i]*2^i - A[i]*2^(n-i-1) +
	 * ... + (A[n-i-1]*2^(n-i-1) - A[n-i-1]*2^i + ... + (A[n-1] * 2^(n-1) -
	 * A[n-1]*2^0)
	 */

	// Sum of Subsequence Widths - leetcode

	public int solve(int[] A) {
		long sum = 0;
		Arrays.sort(A);
		int n = A.length;
		for (int i = 0; i < A.length; ++i) {
			sum += (A[i] * (power(i) - power(n - i - 1))) % 1000000007;
		}
		return (int) sum;
	}

	public long power(int i) {
		long one = 1;
		int x = i;
		while (x > 0) {
			one = (one * 2) % 1000000007;
			x--;
		}
		return one % 1000000007;
	}

	// ---------------------------------------------------------------------------------------------------
	// more optimal calculation of power
	public int sumSubseqWidths(int[] A) {
		int mod = 1000000007;
		Arrays.sort(A);
		int n = A.length;
		long[] pow2 = new long[n];
		pow2[0] = 1;
		for (int i = 1; i < n; ++i)
			pow2[i] = pow2[i - 1] * 2 % mod;

		long sum = 0;
		for (int i = 0; i < n; ++i) {
			sum = (sum + ((long) A[i] * (pow2[i] - pow2[n - i - 1]))) % mod;
		}
		return (int) sum;
	}

}
