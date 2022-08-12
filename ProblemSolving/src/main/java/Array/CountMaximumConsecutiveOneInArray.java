package Array;

/**
 * 
 * Problem Statement: Given an array that contains only 1 and 0 return the count
 * of maximum consecutive ones in the array.
 * 
 * Examples:
 * 
 * Example 1:
 * 
 * Input: prices = {1, 1, 0, 1, 1, 1}
 * 
 * Output: 3
 * 
 * Explanation: There are two consecutive 1’s and three consecutive 1’s in the
 * array out of which maximum is 3.
 * 
 * Input: prices = {1, 0, 1, 1, 0, 1}
 * 
 * Output: 2
 * 
 * Explanation: There are two consecutive 1's in the array.
 *
 */

public class CountMaximumConsecutiveOneInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 1, 0, 1, 1, 1 };
		System.out.println(countOnes(arr));
	}

	public static int countOnes(int[] arr) {
		int n = arr.length;
		int max = 0;
		int count = 0;

		for (int i = 0; i < n; ++i) {
			if (arr[i] == 1)
				count++;
			else if (arr[i] == 0)
				count = 0;
			max = Math.max(count, max);
		}
		return max;
	}

}
