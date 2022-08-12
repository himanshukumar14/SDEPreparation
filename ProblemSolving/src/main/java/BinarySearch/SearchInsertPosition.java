package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 2, 4, 5, 6 };
		System.out.println(searchInsert(arr, 3));
	}

	public static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int l = 0;
		int r = n - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

}
