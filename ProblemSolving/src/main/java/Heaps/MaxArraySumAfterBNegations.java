package Heaps;

import java.util.Arrays;

public class MaxArraySumAfterBNegations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] A, int B) {
		Arrays.sort(A);

		int i = 0;
		while (B > 0) {
			A[i] = -1 * A[i];
			if (i < A.length && (A[i + 1] < 0 || A[i] > A[i + 1]))
				i++;
			B--;
		}
		
		int sum = 0;
		for(int x : A) {
			sum += x;
		}
		return sum;
	}

}
