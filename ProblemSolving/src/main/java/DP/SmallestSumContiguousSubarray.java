package DP;

public class SmallestSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, -4, 2, -3, -1, 7, -5 };
		int n = arr.length;

		System.out.print("Smallest sum: " + smallestSumSubarr(arr, n));
	}

	//kadane
	public static int smallestSumSubarr(int arr[], int n) {
		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			min = Math.min(min, sum);
			if (sum > 0)
				sum = 0;
		}
		return min;
	}

}
