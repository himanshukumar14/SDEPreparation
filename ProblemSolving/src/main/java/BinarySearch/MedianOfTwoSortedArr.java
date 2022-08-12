package BinarySearch;

public class MedianOfTwoSortedArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] a = new int[] { 1, 3, 8, 9, 15 };
		// int[] b = new int[] { 7, 11, 18, 19, 21, 25 };
		int[] a = new int[] {};
		int[] b = new int[] { 20 };
		System.out.println(findMedian(a, b));
		System.out.println(medianWithBS(a, b));
	}

	public static double findMedian(int[] a, int[] b) {
		int[] c = merge(a, b);
		int len = c.length;
		if (len % 2 == 1)
			return (double) (c[len / 2]);
		else
			return (double) ((double) (c[(len / 2) - 1] + c[len / 2]) / 2);

	}

	public static int[] merge(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;

		int[] tot = new int[m + n];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < n && j < m) {
			if (a[i] <= b[j])
				tot[k++] = a[i++];
			else
				tot[k++] = b[j++];
		}

		while (i < n) {
			tot[k++] = a[i++];
		}

		while (j < m) {
			tot[k++] = b[j++];
		}

		return tot;
	}

	public static double medianWithBS(int[] a, int[] b) {
		if (a.length > b.length)
			medianWithBS(b, a);
		int alen = a.length;
		int blen = b.length;

		int l = 0;
		int r = alen;

		while (l <= r) {
			int amid = (l + r) / 2;
			int bmid = ((alen + blen + 1) / 2) - amid;

			int maxLeftA = amid == 0 ? Integer.MIN_VALUE : a[amid - 1];
			int maxLeftB = bmid == 0 ? Integer.MIN_VALUE : b[bmid - 1];

			int minRightA = amid == alen ? Integer.MAX_VALUE : a[amid];
			int minRightB = bmid == blen ? Integer.MAX_VALUE : b[bmid];

			if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
				if ((alen + blen) % 2 == 0) {
					return ((double) Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
				} else {
					return (double) Math.max(maxLeftA, maxLeftB);
				}
			} else if (maxLeftA > minRightB) {
				r = amid - 1;
			} else {
				l = amid + 1;
			}
		}
		return -1;
	}
}
