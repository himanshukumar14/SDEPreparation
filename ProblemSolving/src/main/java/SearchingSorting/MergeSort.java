package SearchingSorting;

public class MergeSort {
	// time- O(m+n)
	public static void merge(int[] a, int[] b, int m, int n) {
		int i, j, k;
		i = j = k = 0;
		int[] c = new int[m + n];
		while (i < m && j < n) {
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		while (i < m)
			c[k++] = a[i++];
		while (j < n)
			c[k++] = b[j++];
	}

	public static void mergeSingleArray(int[] a, int l, int mid, int h) {
		int i, j, k;
		int[] b = new int[h + 1];
		i = l;
		j = mid + 1;
		k = l;
		while (i <= mid && j <= h) {
			if (a[i] < a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}
		while (i <= mid)
			b[k++] = a[i++];
		while (j <= h)
			b[k++] = a[j++];
		for (i = l; i <= h; i++)
			a[i] = b[i];
	}

	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}

	// 2 way merge sort
	// time- O(nlogn)
	// Comparison based sorting
	// requires extra space (only this takes extra space in comp based sorting)
	public static void mergeSort(int A[], int n) {
		int p, l, h, mid, i;
		for (p = 2; p <= n; p = p * 2) {
			for (i = 0; i + p - 1 <= n; i = i + p) {
				l = i;
				h = i + p - 1;
				mid = (l + h) / 2;
				mergeSingleArray(A, l, mid, h);
			}
		}
		if (p / 2 < n)
			mergeSingleArray(A, 0, p / 2 - 1, n);
	}

	// 2 way merge sort
	// time- O(nlogn)
	// top down approach
	// merging is done in post order
	// requires extra space (only this takes extra space in comp based sorting)
	// extra space taken n+logn
	public static void mergeSortRecursive(int A[], int l, int h) {
		int mid;
		if (l < h) {
			mid = (l + h) / 2;
			mergeSortRecursive(A, l, mid);
			mergeSortRecursive(A, mid + 1, h);
			mergeSingleArray(A, l, mid, h);
		}
	}

	public static void main(String[] args) {
		int A[] = { 11, 13, 7, 12, 16, 9, 24, 5, 10, 3 }, n = 10, i;
		mergeSort(A, n);
		for (i = 0; i < 10; i++)
			System.out.println(A[i]);
	}

}
