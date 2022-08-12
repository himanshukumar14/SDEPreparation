package Heaps;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(List<ListNode> a) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		ListNode sorted = new ListNode(-1);
		ListNode curr = sorted;
		for (ListNode temp : a) {
			pq.add(temp);
		}

		while (!pq.isEmpty()) {
			ListNode c = pq.poll();
			if (c.next != null)
				pq.add(c.next);

			curr.next = c;
			curr = curr.next;
		}
		return sorted.next;
	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
