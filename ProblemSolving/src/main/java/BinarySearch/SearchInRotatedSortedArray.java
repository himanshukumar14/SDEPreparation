package BinarySearch;

/**
 * 
 * Given a sorted array of integers A of size N and an integer B.
 * 
 * array A is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * 
 * You are given a target value B to search. If found in the array, return its
 * index otherwise, return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * NOTE: Users are expected to solve this in O(log(N)) time.
 * 
 * 
 * 
 * Problem Constraints 1 <= N <= 1000000
 * 
 * 1 <= A[i] <= 10^9
 * 
 * all elements in A are distinct.
 * 
 * 
 * 
 * Input Format The first argument given is the integer array A.
 * 
 * The second argument given is the integer B.
 * 
 * 
 * 
 * Output Format Return index of B in array A, otherwise return -1
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [4, 5, 6, 7, 0, 1, 2, 3] B = 4 Input 2:
 * 
 * A = [1] B = 1
 * 
 * 
 * Example Output Output 1:
 * 
 * 0 Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * 
 * Target 4 is found at index 0 in A. Explanation 2:
 * 
 * 
 * Target 1 is found at index 0 in A.
 *
 * 
 */

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 3, 1 };
		int target = 1;
		System.out.println("Ans: " + search(nums, target));
	}

	public static int search(int[] nums, int target) {
		int n = nums.length;
		int l = 0;
		int r = n - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				if (nums[l] <= nums[mid] && target < nums[l]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			} else {
				if (nums[r] >= nums[mid] && target > nums[r]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}
		return -1;
	}

	public boolean searchWithRep(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return true;
			} else if (nums[l] < nums[mid] || nums[mid] > nums[r]) {
				if (target < nums[mid] && target >= nums[l]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else if (nums[r] > nums[mid] || nums[mid] < nums[l]) {
				if (target > nums[mid] && target <= nums[r]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			} else { // For handling duplicates -- nums[mid] == nums[l]
				l++;
			}
		}
		return false;
	}

	public int search2(final int[] A, int B) {
		int l = 0;
		int r = A.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (A[mid] == B) {
				return mid;
			}

			if (A[l] <= A[mid]) {
				if (B >= A[l] && B < A[mid])
					r = mid - 1;
				else
					l = mid + 1;
			} else {
				if (B > A[mid] && B <= A[r])
					l = mid + 1;
				else
					r = mid - 1;
			}
		}
		return -1;
	}

}
