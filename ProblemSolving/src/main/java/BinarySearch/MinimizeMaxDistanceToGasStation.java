package BinarySearch;

/**
 * 
 * On a horizontal number line, we have gas stations at positions stations[0],
 * stations[1], ..., stations[N-1], where N = stations.length.
 * 
 * Now, we add K more gas stations so that D, the maximum distance between
 * adjacent gas stations, is minimized.
 * 
 * Return the smallest possible value of D.
 * 
 * 
 * 1.stations.length will be an integer in range [10, 2000]. 2.stations[i] will
 * be an integer in range [0, 10^8]. 3.K will be an integer in range [1, 10^6].
 * 4.Answers within 10^-6 of the true value will be accepted as correct.
 * 
 * Example Example 1:
 * 
 * Input：stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]，K = 9 Output：0.50
 * Explanation：The distance between adjacent gas stations is 0.50 Example 2:
 * 
 * Input：stations = [3,6,12,19,33,44,67,72,89,95]，K = 2 Output：14.00
 * Explanation：construction of gas stations at 86 locations
 */

public class MinimizeMaxDistanceToGasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double minimizeDistance(int[] arr, int k) {
		int n = arr.length;
		double lo = 0;
		double hi = arr[n - 1] - arr[0];
		double ans = Double.MAX_VALUE;
		while (hi - lo >= Math.pow(10, -6)) { // since Answers within 10^-6 of the true value will be accepted as
												// correct
			double mid = lo + (hi - lo) / 2;

			if (isPossible(arr, mid, k)) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return ans;
	}

	// tracks the gap between two stations and count the number of stations we can add in between with decided mid or guess
	public boolean isPossible(int[] arr, double mid, int k) {
		int n = arr.length;
		int count = 0;
		for (int i = 1; i < n; ++i) {
			count += (int) Math.ceil((double) (arr[i] - arr[i - 1]) / mid) - 1.0;
		}
		return count == k;
	}

}
