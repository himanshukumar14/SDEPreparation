package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProductOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solve(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2.compareTo(i1);
			}
		});
		ans[0] = -1;
		ans[1] = -1;

		pq.add(A[0]);
		pq.add(A[1]);

		for (int i = 2; i < n; ++i) {
			pq.add(A[i]);
			int a = pq.poll();
			int b = pq.poll();
			int c = pq.poll();
			ans[i] = a * b * c;
			pq.add(a);
			pq.add(b);
			pq.add(c);
		}
		return ans;
	}
}
