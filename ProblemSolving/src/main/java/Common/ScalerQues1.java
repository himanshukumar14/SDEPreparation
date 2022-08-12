import java.util.HashMap;
import java.util.Map;

//Given an array arr[] consisting of N integers, the task is to find the length of the Smallest subarray with a sum equal to K.
public class ScalerQues1 {

	public static int smallestSubarraySumK(int arr[], int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int currPrefixSum = 0;
		int n = arr.length;
		int result = Integer.MAX_VALUE;
		map.put(0, -1); // for complete array
		for (int i = 0; i < n; i++) {
			currPrefixSum += arr[i];
			if (map.containsKey(currPrefixSum - k)) {
				result = Math.min(result, Math.abs(i - map.get(currPrefixSum - k)));
			}
			map.put(currPrefixSum, i);
		}

		if (result >= Integer.MAX_VALUE)
			return -1;
		return result;
	}

	// Driver Code
	public static void main(String[] args) {

		int arr[] = { 2, -1, 2 };
		int n = arr.length;
		int K = 3;

		System.out.println(smallestSubarraySumK(arr, K));
	}

}
