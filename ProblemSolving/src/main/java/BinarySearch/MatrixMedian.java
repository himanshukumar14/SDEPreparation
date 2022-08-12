package BinarySearch;

/**
 * 
 * Given a matrix of integers A of size N x M in which each row is sorted.
 * 
 * Find and return the overall median of matrix A.
 * 
 * NOTE: No extra memory is allowed.
 * 
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left
 * to right.
 * 
 * Problem Constraints 1 <= N, M <= 10^5
 * 
 * 1 <= N*M <= 10^6
 * 
 * 1 <= A[i] <= 10^9
 * 
 * N*M is odd
 * 
 * Input Format The first and only argument given is the integer matrix A.
 * 
 * Output Format Return the overall median of matrix A.
 * 
 * Example Input Input 1:
 * 
 * A = [ [1, 3, 5], [2, 6, 9], [3, 6, 9] ] Input 2:
 * 
 * A = [ [5, 17, 100] ]
 * 
 * 
 * Example Output Output 1:
 * 
 * 5 Output 2:
 * 
 * 17
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9] Median is 5. So, we return 5. Explanation 2:
 * 
 * Median is 17.
 *
 * 
 */

public class MatrixMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMedian(int[][] A) {
		int r = A.length;
		int c = A[0].length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int median = (r * c + 1) / 2;

		for (int i = 0; i < r; ++i) {
			min = Math.min(min, A[i][0]);
			max = Math.max(max, A[i][c - 1]);
		}

		while (min < max) {
			int mid = (max + min) / 2;
			int count = 0;
			for (int i = 0; i < r; ++i) {
				int temp = binarysearch(A[i], mid);
				if (temp < 0) {
					temp = Math.abs(temp) - 1;
				} else {
					while (temp < c && A[i][temp] == mid) {
						temp++;
					}
				}
				count = count + temp;
			}

			if (count < median) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}

	public int binarysearch(int[] A, int x) {
		int l = 0;
		int r = A.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (A[mid] == x) {
				return mid;
			} else if (x < A[mid]) {
				r = mid - 1;
			} else if (x > A[mid]) {
				l = mid + 1;
			}
		}
		return -l - 1;
	}

}
