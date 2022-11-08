package BinarySearch;

/**
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given an integer array nums, find a peak element, and return its index. If
 * the array contains multiple peaks, return the index to any of the peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * You must write an algorithm that runs in O(log n) time.
 *
 */

public class FindAPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPeakElement(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		if (nums.length == 1)
			return 0;

		while (l < r) {
			int mid = (l + r) / 2;

			if (nums[mid] > nums[mid + 1]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	// my solution
	public int solve(int[] A) {
		int l = 0;
		int r = A.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if ((mid == 0 && A[mid + 1] < A[mid]) || (mid == A.length - 1 && A[mid - 1] < A[mid]))  //cover edge case
				return A[mid];
			else {
				if (A[mid - 1] <= A[mid] && A[mid] >= A[mid + 1]) {  // if the mid is peak
					return A[mid];
				} else if (A[mid] < A[mid - 1] && A[mid + 1] < A[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}
		return -1;
	}

}
