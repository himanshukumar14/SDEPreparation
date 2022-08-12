package GreedyAlgorithm;

/**
 * 
 * Given an array a, we have to find maximum product possible with the subset of
 * elements present in the array. The maximum product can be single element
 * also. Examples:
 * 
 * Input: a[] = { -1, -1, -2, 4, 3 } Output: 24 Explanation : Maximum product
 * will be ( -2 * -1 * 4 * 3 ) = 24
 * 
 * Input: a[] = { -1, 0 } Output: 0 Explanation: 0(single element) is maximum
 * product possible
 * 
 * Input: a[] = { 0, 0, 0 } Output: 0
 *
 */

public class MaximumProductSubsetOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProductSubset(int a[], int n) {
		if (n == 1) {
			return a[0];
		}
		int max_neg = Integer.MIN_VALUE;
		int count_neg = 0, count_zero = 0;
		int prod = 1;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				count_zero++;
				continue;
			}
			if (a[i] < 0) {
				count_neg++;
				max_neg = Math.max(max_neg, a[i]);
			}
			prod = prod * a[i];
		}

		if (count_zero == n) {
			return 0;
		}

		if (count_neg % 2 == 1) {
			if (count_neg == 1 && count_zero > 0 && count_zero + count_neg == n) {
				return 0;
			}
			prod = prod / max_neg;
		}

		return prod;
	}

}
