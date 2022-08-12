package BinarySearch;

/**
 * 
 * Given an integer array sorted in ascending order, write a function to search
 * target in nums. If target exists, then return its index, otherwise
 * return-1.However, the array size is unknown to you. You may only access the
 * array using anArrayReader interface, where ArrayReader.get(k)returns the
 * element of the array at index k (0-indexed). You may assume all integers in
 * the array are less than 10000, and if you access the array out of
 * bounds,ArrayReader.getwill return 2147483647.
 * 
 * Example 1: Input: array = [-1,0,3,5,9,12], target = 9
 * 
 * Output: 4
 * 
 * Explanation: 9 exists in nums and its index is 4 Example 2: Input: array =
 * [-1,0,3,5,9,12], target = 2
 * 
 * Output: -1
 * 
 * Explanation: 2 does not exist in nums so return -1
 *
 */

public class SearchInASortedArrayOfUnknownSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(ArrayReader reader, int target) {
		int start = 0, end = Integer.MAX_VALUE;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (target == reader.get(mid)) {
				return mid;
			} else if (target < reader.get(mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (reader.get(start) == target) {
			return start;
		} else if (reader.get(end) == target) {
			return end;
		}
		return -1;
	}

	class ArrayReader {
		public int get(int x) {
			return 0;
		}
	}

}
