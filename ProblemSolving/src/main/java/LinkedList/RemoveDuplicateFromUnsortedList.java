package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromUnsortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode removeDuplicate(ListNode head) {
		Set<Integer> hs = new HashSet<>();
		ListNode current = head;
		ListNode prev = null;
		while (current != null) {
			int curval = current.val;
			if (hs.contains(curval)) {
				prev.next = current.next;
			} else {
				hs.add(curval);
				prev = current;
			}
			current = current.next;
		}
		return head;
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
