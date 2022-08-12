package LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});

		for (int i = 0; i < a.size(); ++i) {
			heap.add(a.get(i));
		}

		ListNode merge = new ListNode(-1);
		ListNode ans = merge;
		while (!heap.isEmpty()) {
			ListNode temp = heap.poll();
			ans.next = temp;
			ans = ans.next;
			if (temp != null && temp.next != null)
				heap.add(temp.next);
		}
		return merge.next;
	}

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
