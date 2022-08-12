package BinarySearch;

public class SpecialInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//sliding window approach
	public int solve(int[] A, int B) {
		int max = A.length + 1;
		int sum = A[0];
		int count = 1;
		int j = 0;

		for (int i = 1; i <= A.length; ++i) {
			while (sum > B) {
				if (sum > B) {
					max = Math.min(max, count);
				}
				sum = sum - A[j];
				count--;
				j++;
			}

			if (i < A.length) {
				sum = sum + A[i];
				count++;
			}
		}
		return max - 1;
	}

	// binary search method
	/**
	 * 
	 * You need to find the maximal K. Think of a way to do this by binary search.
	 * You can use binary seacrh to find if a certain K is allowed or not. if it is,
	 * you try finding a bigger answer if not, try finding a smaller answer. int l =
	 * 1, r = a.length; while(l <= r) { int m = (l + r) » 1; if(check(a, b, m)) l =
	 * m + 1; else r = m - 1; } return l-1;
	 */
	public int solve2(int[] A, int B) {
		int n = A.length;
		long[] prefix = new long[n];
		prefix[0] = A[0];
		for (int i = 1; i < n; ++i)
			prefix[i] = prefix[i - 1] + A[i];

		int l = 1;
		int r = n;
		int ans = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (check(prefix, mid, B)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ans;
	}

	public boolean check(long[] A, int x, int max) {
		for (int i = x - 1, j = -1; i < A.length; ++i) {
			long sum = j > -1 ? A[i] - A[j] : A[i];
			if (sum > max)
				return false;
			j++;
		}
		return true;
	}

}
