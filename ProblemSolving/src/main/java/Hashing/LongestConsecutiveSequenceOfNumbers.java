package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an unsorted array, find the length of the longest subarray of
 * consecutive numbers
 * 
 * Example: 7 1 5 8 9 3 4 2
 * 
 * Ans: 5
 * 
 * Explaination: Two subarrays are formed 1 2 3 4 5 7 8 9 Longest is of length 5
 *
 */

public class LongestConsecutiveSequenceOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 7, 1, 5, 8, 9, 3, 4, 2 };
		System.out.println(getLongestConsecutiveArray(nums));
	}

	public static int getLongestConsecutiveArray(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for (int n : nums)
			numSet.add(n);

		int count = 1;
		int maxCount = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (numSet.contains(nums[i] - 1))
				continue;
			while (numSet.contains(nums[i] + count)) {
				count++;
			}
			maxCount = Math.max(count, maxCount);
			count = 1;
		}
		return maxCount;
	}

}
