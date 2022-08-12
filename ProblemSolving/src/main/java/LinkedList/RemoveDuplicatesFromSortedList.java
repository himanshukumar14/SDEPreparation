package LinkedList;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode A) {
		ListNode prev = A;
		ListNode curr = A;

		while (curr != null) {
			while (curr != null && prev.val == curr.val) {
				curr = curr.next;
			}
			prev.next = curr;
			prev = prev.next;
		}
		return A;
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
