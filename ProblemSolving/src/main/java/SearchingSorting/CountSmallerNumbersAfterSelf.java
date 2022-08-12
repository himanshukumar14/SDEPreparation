package SearchingSorting;

/**
 * 
 * Problem Description
 * 
 * Given an array of integers A, find and return new integer array B.
 * 
 * Array B has the property where B[i] is the number of smaller elements to the
 * right of A[i].
 * 
 * 
 * 
 * Problem Constraints 1 <= length of the array <= 100000
 * 
 * 1 <= A[i] <= 109
 * 
 * 
 * 
 * Input Format The only argument given is the integer array A.
 * 
 * 
 * 
 * Output Format Return the new integer array B.
 * 
 * 
 * 
 * Example Input A = [1, 5, 4, 2, 1]
 * 
 * 
 * Example Output [0, 3, 2, 1, 0]
 * 
 * 
 * Example Explanation Number of smaller elements to the right of 1 are 0.
 * Number of smaller elements to the right of 5 are 3 (4, 2, 1). Number of
 * smaller elements to the right of 4 are 2 (2, 1). Number of smaller elements
 * to the right of 2 are 1 (1). Number of smaller elements to the right of 1 are
 * 0.
 *
 * 
 */

public class CountSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] temp;

	public int[] solve(int[] A) {
		int n = A.length;
		temp = new int[n];
		int[] indexes = new int[n];
		for (int i = 0; i < n; i++) {
			indexes[i] = i;
		}
		sort(A, indexes, 0, n - 1);
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = temp[i];
		}
		return res;
	}

	public void sort(int[] A, int[] indexes, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			sort(A, indexes, l, mid);
			sort(A, indexes, mid + 1, r);
			merge(A, indexes, l, mid, r);
		}
	}

	public void merge(int[] a, int[] indexes, int l, int mid, int r) {
		int i, j, k;
		int[] b = new int[r - l + 1];
		i = l;
		j = mid + 1;
		k = 0;
		int rightcount = 0;
		while (i <= mid && j <= r) {
			if (a[indexes[j]] < a[indexes[i]]) {
				b[k++] = indexes[j++];
				rightcount++;
			} else {
				temp[indexes[i]] += rightcount;
				b[k++] = indexes[i++];
			}
		}
		while (i <= mid) {
			temp[indexes[i]] += rightcount;
			b[k++] = indexes[i++];
		}
		while (j <= r) {
			b[k++] = indexes[j++];
		}
		for (i = l; i <= r; i++) {
			indexes[i] = b[i - l];
		}
	}

}
