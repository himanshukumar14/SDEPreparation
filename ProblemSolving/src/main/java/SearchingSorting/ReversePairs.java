package SearchingSorting;

/**
 * 
 * Given an integer array nums, return the number of reverse pairs in the array.
 * 
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] >
 * 2 * nums[j].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,2,3,1] Output: 2 Example 2:
 * 
 * Input: nums = [2,4,3,5,1] Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 104 -231 <= nums[i] <= 231 - 1
 */

public class ReversePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int count = 0;

	public int reversePairs(int[] nums) {
		int n = nums.length;
		mergeSort(nums, 0, n - 1);
		return count;
	}

	public void mergeSort(int[] A, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(A, l, mid);
			mergeSort(A, mid + 1, r);
			for (int i = l, j = mid + 1; i <= mid; ++i) {
				while (j <= r && A[i] / 2.0 > A[j])
					j++;
				count += j - (mid + 1);
			}
			merge(A, l, mid, r);
		}
	}

	public void merge(int[] a, int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int k = 0;
		int[] b = new int[r - l + 1];

		while (i <= mid && j <= r) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else {
				b[k++] = a[j++];
			}
		}

		while (i <= mid) {
			b[k++] = a[i++];
		}
		while (j <= r) {
			b[k++] = a[j++];
		}
		for (i = l; i <= r; i++)
			a[i] = b[i - l];
	}

	// -------------------------------------------------------------------------------------------------------------------

	int reverseCount = 0;

	public int solve(int[] A) {
		sort(A, 0, A.length - 1);
		return reverseCount;
	}

	public void sort(int[] A, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			sort(A, l, mid);
			sort(A, mid + 1, r);
			merge(A, l, mid, r);
		}
	}

	public void merge2(int[] a, int l, int mid, int r) {
		int i, j, k;

		int[] b = new int[r - l + 1];
		i = l;
		j = mid + 1;
		k = 0;
		while (i <= mid && j <= r) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else {
				reverseCount += getSum(a, i, mid, a[j]);
				b[k++] = a[j++];
			}
		}
		while (i <= mid) {
			b[k++] = a[i++];
		}
		while (j <= r) {
			b[k++] = a[j++];
		}
		for (i = l; i <= r; i++)
			a[i] = b[i - l];
	}

	public int getSum(int[] a, int i, int j, int comp) {
		int sum = 0;
		while (a[i] <= 2 * comp && i <= j) {
			i++;
		}
		if (a[i] > 2 * comp)
			sum = j - i + 1;
		return sum;
	}

}
