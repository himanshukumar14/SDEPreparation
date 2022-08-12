package LinkedList;

public class MoveLastElementToFront {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode moveToFront(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode curr = head;

		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		curr.next = head;
		return curr;
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
