package BinarySearch;

public class MinimumElementInSortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = { 5, 6, 1, 2, 3, 4 };
		System.out.println("The minimum element is " + findMin(arr1));

		int arr2[] = { 1, 2, 3, 4 };
		System.out.println("The minimum element is " + findMin(arr2));

		int arr3[] = { 1 };
		System.out.println("The minimum element is " + findMin(arr3));

		int arr4[] = { 1, 2 };
		System.out.println("The minimum element is " + findMin(arr4));

		int arr5[] = { 2, 1 };
		System.out.println("The minimum element is " + findMin(arr5));

		int arr6[] = { 5, 6, 7, 1, 2, 3, 4 };
		System.out.println("The minimum element is " + findMin(arr6));

		int arr7[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("The minimum element is " + findMin(arr7));

		int arr8[] = { 2, 3, 4, 5, 6, 7, 8, 1 };
		System.out.println("The minimum element is " + findMin(arr8));

		int arr9[] = { 3, 4, 5, 1, 2 };
		System.out.println("The minimum element is " + findMin(arr9));

		int arr10[] = { 1, 2, 3, 4, 5, 1 };
		System.out.println("The minimum element is " + findMin(arr10));
	}

	public static int findMin(int[] arr) {
		int n = arr.length;
		int l = 0;
		int r = n - 1;

		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] == arr[r]) { // For handling duplicates
				r--;
			} else if (arr[mid] < arr[r]) {
				r = mid;
			} else if (arr[mid] > arr[r]) {
				l = mid + 1;
			}
		}
		return arr[l];
	}

	public int findMinWithoutRep(int[] nums) {
		int n = nums.length;
		int l = 0;
		int r = n - 1;

		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] < nums[r]) {
				r = mid;
			} else if (nums[mid] > nums[r]) {
				l = mid + 1;
			}
		}
		return nums[l];
	}
}
