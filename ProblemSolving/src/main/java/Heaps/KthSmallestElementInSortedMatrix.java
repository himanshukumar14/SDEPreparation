package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int m = matrix[0].length;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});

		for (int i = 0; i < n; ++i) {
			pq.add(new int[] { matrix[i][0], i, 0 });
		}
		for (int i = 1; i < k; ++i) {
			int[] curr = pq.poll();
			// System.out.println(curr[0]);
			int newx = curr[1];
			int newy = curr[2] + 1;
			if (newy < m)
				pq.add(new int[] { matrix[newx][newy], newx, newy });
		}
		return pq.poll()[0];
	}

}
