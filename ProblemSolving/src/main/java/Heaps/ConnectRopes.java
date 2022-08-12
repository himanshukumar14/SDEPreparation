package Heaps;

import java.util.PriorityQueue;

public class ConnectRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] A) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); //minHeap
		int cost = 0;

		for (int x : A) {
			pq.add(x);
		}

		while (pq.size() != 1) {
			int l1 = pq.poll();
			int l2 = pq.poll();

			cost += l1 + l2;
			pq.add(l1 + l2);
		}

		return cost;
	}

}
