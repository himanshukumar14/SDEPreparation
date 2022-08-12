package DP;

import java.util.Arrays;

/**
 * Given an array of integers and a number k. We can pair two numbers of the
 * array if the difference between them is strictly less than k. The task is to
 * find the maximum possible sum of disjoint pairs. Sum of P pairs is the sum of
 * all 2P numbers of pairs.
 * 
 * Examples:
 * 
 * Input : arr[] = {3, 5, 10, 15, 17, 12, 9}, K = 4 Output : 62 Explanation:
 * Then disjoint pairs with difference less than K are, (3, 5), (10, 12), (15,
 * 17) So maximum sum which we can get is 3 + 5 + 12 + 10 + 15 + 17 = 62 Note
 * that an alternate way to form disjoint pairs is, (3, 5), (9, 12), (15, 17),
 * but this pairing produces lesser sum.
 * 
 * Input : arr[] = {5, 15, 10, 300}, k = 12 Output : 25
 *
 */

public class MaximumSumPairsSpecificDifference {

	/**
	 * 
	 * First, we sort the given array in increasing order. Once array is sorted, we
	 * traverse the array. For every element, we try to pair it with its previous
	 * element first. Why do we prefer previous element? Let arr[i] can be paired
	 * with arr[i-1] and arr[i-2] (i.e. arr[i] – arr[i-1] < K and arr[i]-arr[i-2] <
	 * K). Since the array is sorted, value of arr[i-1] would be more than arr[i-2].
	 * Also, we need to pair with difference less than k, it means if arr[i-2] can
	 * be paired, then arr[i-1] can also be paired in a sorted array. Now observing
	 * the above facts, we can formulate our dynamic programming solution as below,
	 * Let dp[i] denotes the maximum disjoint pair sum we can achieve using first i
	 * elements of the array. Assume currently, we are at i’th position, then there
	 * are two possibilities for us.
	 * 
	 * Pair up i with (i-1)th element, i.e. dp[i] = dp[i-2] + arr[i] + arr[i-1]
	 * Don't pair up, i.e. dp[i] = dp[i-1]
	 */
	public static void main(String[] args) {
		int arr[] = { 3, 5, 10, 15, 17, 12, 9 };
		int N = arr.length;
		int K = 4;

		System.out.println(maxSumPairWithDifferenceLessThanK(arr, N, K));

	}

	public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) {
		Arrays.sort(arr);

		int dp[] = new int[N];
		dp[0] = 0;

		for (int i = 1; i < N; i++) {
			if (arr[i] - arr[i - 1] < K) {
				if (i >= 2)
					dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i] + arr[i - 1]);
				else
					dp[i] = Math.max(dp[i - 1], arr[i] + arr[i - 1]);
			} else {
				dp[i] = dp[i - 1];
			}
		}

		return dp[N - 1];
	}

}
