package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Write an efficient program for printing k largest elements in an array.
 * Elements in an array can be in any order. For example, if the given array is
 * [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements i.e.,
 * k = 3 then your program should print 50, 30, and 23.
 *
 */

public class KLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] kLargest(int[] arr, int k) {
		int n = arr.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		int[] ans = new int[k];
		for (int i = 0; i < n; ++i) {
			pq.add(arr[i]);
		}
		for (int i = 0; i < k && !pq.isEmpty(); ++i) {
			ans[i] = pq.poll();
		}
		return ans;
	}

	//more optimal
	public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		});

		for (int i = 0; i < A.size(); ++i) {
			if (minHeap.size() < B) {
				minHeap.add(A.get(i));
			} else if (A.get(i) > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(A.get(i));
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			int temp = minHeap.poll();
			ans.add(temp);
		}
		return ans;
	}

}
