package BinarySearch;

public class FirstAndLastPosInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] searchRange(int[] nums, int target) {
		int[] output = new int[] { -1, -1 };
		int ind = searchLeftEnd(nums, target);
		if (ind == nums.length || nums[ind] != target) {
			return output;
		}

		output[0] = ind;
		output[1] = searchRightEnd(nums, target) - 1;
		return output;
	}

	public int searchLeftEnd(int[] nums, int target) {
		int n = nums.length;
		int l = 0;
		int r = n - 1;

		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target || nums[mid] > target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	public int searchRightEnd(int[] nums, int target) {
		int n = nums.length;
		int l = 0;
		int r = n - 1;

		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] > target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

}
