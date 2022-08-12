package SearchingSorting;

/**
 * 
 * Given two sorted arrays arr1 and arr2 of size N and M respectively and an
 * element K. The task is to find the element that would be at the k’th position
 * of the final sorted array.
 * 
 * 
 * Example 1:
 * 
 * Input: arr1[] = {2, 3, 6, 7, 9} arr2[] = {1, 4, 8, 10} k = 5 Output: 6
 * Explanation: The final sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10 The
 * 5th element of this array is 6. Example 2: Input: arr1[] = {100, 112, 256,
 * 349, 770} arr2[] = {72, 86, 113, 119, 265, 445, 892} k = 7 Output: 256
 * Explanation: Final sorted array is - 72, 86, 100, 112, 113, 119, 256, 265,
 * 349, 445, 770, 892 7th element of this array is 256.
 * 
 * Your Task: You don't need to read input or print anything. Your task is to
 * complete the function kthElement() which takes the arrays arr1[], arr2[], its
 * size N and M respectively and an integer K as inputs and returns the element
 * at the Kth position.
 * 
 * 
 * Expected Time Complexity: O(Log(N) + Log(M)) Expected Auxiliary Space: O(Log
 * (N))
 *
 * 
 * 
 */

public class KthElementOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//O(k) time // O(logn + logm) possible
	public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
		int count = 0;
		int ans = -1;
		int l = 0;
		int r = 0;
		while (l < n && r < m && count < k) {
			if (arr1[l] < arr2[r]) {
				count++;
				ans = arr1[l++];
			} else {
				count++;
				ans = arr2[r++];
			}
		}

		while (l < n && count < k) {
			count++;
			ans = arr1[l++];
		}

		while (r < m && count < k) {
			count++;
			ans = arr2[r++];
		}
		return ans;
	}

}
