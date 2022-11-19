package Array;

/**
 * 
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Example 1: Input: [1,2,0] Output: 3 
 * Example 2: Input: [3,4,-1,1] Output: 2
 *
 */

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Put each number in its right place.
	 * 
	 * For example:
	 * 
	 * When we find 5, then swap it with A[4].
	 * 
	 * At last, the first place where its number is not right, return the place + 1.
	 */
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[temp - 1] = temp;
			}
		}

		for (int i = 0; i < n; ++i)
			if (nums[i] != i + 1)
				return i + 1;
		return n + 1;
	}
}
