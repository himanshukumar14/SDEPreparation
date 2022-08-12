package BinarySearch;

//same as book allocation

/**
 * 
 * Given m servers and n processes with each of them having a cpu load
 * associated with them. Our task is to distribute the load on to each server
 * such that the maximum load a server handles is minimized.
 * 
 * The load is assigned to the servers contiguously.
 * 
 * Example: 3 servers load: [2, 3, 4, 3, 2, 7]
 * 
 * ans = 9
 *
 */
public class DistributeServerLoad {
	public static void main(String[] args) {
		

	}
	
	public int books(int[] A, int B) {
		if (B > A.length)
			return -1;
		long min = 0;
		long max = 0;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; ++i) {
			max += A[i];
			min = Math.max(min, A[i]);
		}

		while (min <= max) {
			int mid = (int) (min + (max - min) / 2);
			if (isPossible(A, B, mid)) {
				ans = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return ans;
	}

	public boolean isPossible(int[] A, int B, int size) {
		int sum = 0;
		int stud = 1;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] > size)
				return false;
			sum = sum + A[i];
			if (sum > size) {
				stud++;
				sum = A[i];
			}
		}
		return stud <= B;
	}
}
