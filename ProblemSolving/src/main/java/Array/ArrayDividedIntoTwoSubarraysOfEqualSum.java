package Array;

/**
 * 
 * Given an array of integers, find if it’s possible to remove exactly one
 * integer from the array that divides the array into two subarrays with the
 * same sum. Examples:
 * 
 * 
 * Input: arr = [6, 2, 3, 2, 1] Output: true Explanation: On removing element 2
 * at index 1, the array gets divided into two subarrays [6] and [3, 2, 1]
 * having equal sum
 * 
 * Input: arr = [6, 1, 3, 2, 5] Output: true Explanation: On removing element 3
 * at index 2, the array gets divided into two subarrays [6, 1] and [2, 5]
 * having equal sum.
 * 
 * Input: arr = [6, -2, -3, 2, 3] Output: true Explanation: On removing element
 * 6 at index 0, the array gets divided into two sets [] and [-2, -3, 2, 3]
 * having equal sum
 * 
 * Input: arr = [6, -2, 3, 2, 3] Output: false
 *
 */

public class ArrayDividedIntoTwoSubarraysOfEqualSum {

	/*
	 * A naive solution would be to consider all elements of the array and calculate
	 * their left and right sum and return true if left and right sum are found to
	 * be equal. The time complexity of this solution would be O(n2). The efficient
	 * solution involves calculating sum of all elements of the array in advance.
	 * Then for each element of the array, we can calculate its right sum in O(1)
	 * time by using total sum of the array elements minus sum of elements found so
	 * far. The time complexity of this solution would be O(n) and auxiliary space
	 * used by it will be O(1). Below is the implementation of above approach:
	 */

	static void printSubArray(int arr[], int start, int end) {
		System.out.print("[ ");
		for (int i = start; i <= end; i++)
			System.out.print(arr[i] + " ");
		System.out.print("] ");
	}

	public static boolean divideArray(int arr[], int n) {
		// sum stores sum of all elements of the array
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		int sum_so_far = 0;

		for (int i = 0; i < n; i++) {
			if (2 * sum_so_far + arr[i] == sum) {
				System.out.print("The array can be divided into " + "two subarrays with equal sum\nThe"
						+ " two subarrays are - ");
				printSubArray(arr, 0, i - 1);
				printSubArray(arr, i + 1, n - 1);

				return true;
			}
			sum_so_far += arr[i];
		}

		// The array cannot be divided
		System.out.println("The array cannot be divided into two " + "subarrays with equal sum");

		return false;
	}

	// Driver program
	public static void main(String[] args) {
		int arr[] = { 6, 2, 3, 2, 1 };
		int n = arr.length;

		divideArray(arr, n);
	}

}
