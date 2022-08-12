package SearchingSorting;

public class QuickSort {

	// Partioning process
	// if elements are in ascending order or descending order than O(n2) complexity,
	// ie the partioning happens at one end of the list
	// Best Case-partioning in middle O(nlogn)
	// Worst Case-partioning in any end O(n2)
	// Average time- O(nlogn)
	// Also called as selection exchange sort
	// Also called as partioning process sort
	// Even though we change pivot position worst case time remains same

	public static void main(String[] args) {
		int[] A = new int[] { 11, 13, 7, 12, 16, 9, 24, 5, 10, 3, Integer.MAX_VALUE };
		int n = A.length;
		quickSort(A, 0, n - 1);
		for (int i = 0; i < 10; i++)
			System.out.println(A[i]);
	}

	public static void swap(int[] A, int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}

	public static int partition(int A[], int l, int h) {
//		int pivot = A[l];
//		int i = l, j = h;
//		do {
//			do {
//				i++;
//			} while (A[i] <= pivot);
//			do {
//				j--;
//			} while (A[j] > pivot);
//			if (i < j)
//				swap(A, i, j);
//		} while (i < j);
//		swap(A, l, j);
//		return j;

		int pivot = A[h];
		int i = (l - 1);
		for (int j = l; j <= h - 1; j++) {
			if (A[j] < pivot) {
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i + 1, h);
		return (i + 1);
	}

	public static void quickSort(int[] A, int l, int h) {
		int j;
		if (l < h) {
			j = partition(A, l, h);
			quickSort(A, l, j);
			quickSort(A, j + 1, h);
		}
	}

}
