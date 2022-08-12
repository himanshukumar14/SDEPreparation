package LinkedList;

public class SplitCircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void splitList(ListNode head) {
		if (head == null || head.next == head)
			return;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != head && fast.next.next != head) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast.next.next == head) {
			fast = fast.next;
		}

		fast.next = slow.next;
		slow.next = head;
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
