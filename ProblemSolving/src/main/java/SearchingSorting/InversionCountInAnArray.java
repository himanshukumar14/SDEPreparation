package SearchingSorting;

/**
 * 
 * Inversion count in an array Problem Description Given an array of integers A.
 * If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
 * Find the total number of inversions of A modulo (109 + 7).
 * 
 * 
 * 
 * Problem Constraints 1 <= length of the array <= 100000
 * 
 * 1 <= A[i] <= 10^9
 * 
 * 
 * 
 * Input Format The only argument given is the integer array A.
 * 
 * 
 * 
 * Output Format Return the number of inversions of A modulo (109 + 7).
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [3, 2, 1] Input 2:
 * 
 * A = [1, 2, 3]
 * 
 * 
 * Example Output Output 1:
 * 
 * 3 Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * All pairs are inversions. Explanation 2:
 * 
 * No inversions.
 *
 * 
 */

public class InversionCountInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long inversion = 0;

	public int solve(int[] A) {
		sort(A, 0, A.length - 1);
		long inver = (inversion % 1000000007);
		return (int) inver;
	}

	public void sort(int[] A, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			sort(A, l, mid);
			sort(A, mid + 1, r);
			merge(A, l, mid, r);
		}
	}

	public void merge(int[] a, int l, int mid, int r) {
		int i, j, k;

		int[] b = new int[r - l + 1];
		i = l;
		j = mid + 1;
		k = 0;
		while (i <= mid && j <= r) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else {
				b[k++] = a[j++];
				inversion += (mid - i + 1); // if element at i is greater than element at j then, all element after i
											// till mid will also be greater than element j
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

}
