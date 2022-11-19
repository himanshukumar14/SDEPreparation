package Array;

import java.util.Arrays;

/**
 * 
 * Given an array of integers A and an integer B. You must modify the array
 * exactly B number of times. In a single modification, we can replace any one
 * array element A[i] by -A[i].
 * 
 * You need to perform these modifications in such a way that after exactly B
 * modifications, sum of the array must be maximum.
 * 
 * 
 * 
 * Problem Constraints 1 <= length of the array <= 5*105 1 <= B <= 5 * 106 -100
 * <= A[i] <= 100
 * 
 * 
 * 
 * Input Format The first argument given is an integer array A. The second
 * argument given is an integer B.
 * 
 * 
 * 
 * Output Format Return an integer denoting the maximum array sum after B
 * modifications.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [24, -68, -29, -9, 84] B = 4 Input 2:
 * 
 * A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61] B = 10
 * 
 * 
 * Example Output Output 1:
 * 
 * 196 Output 2:
 * 
 * 362
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Final array after B modifications = [24, 68, 29, -9, 84] Explanation 2:
 * 
 * Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 *
 * 
 */

public class MaximumArraySumAfterBNegations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] A, int B) {
		int n = A.length;
		Arrays.sort(A);

		int i = 0;
		while (B > 0) {
			A[i] = -1 * A[i];
			if (i < n && A[i + 1] < 0) {
				i++;
			} else if (A[i] > A[i + 1]) {
				i++;
			}
			B--;
		}

		int sum = 0;
		for (int j = 0; j < n; ++j) {
			sum += A[j];
		}
		return sum;
	}

}
