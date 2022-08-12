package LinkedList;

public class NthLastElementOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		nthLastElement(head, 6);
	}

	public static void nthLastElement(ListNode head, int n) {
		ListNode prev = head;
		ListNode curr = head;

		while (curr != null && n > 0) {
			curr = curr.next;
			n--;
		}
		if (n > 0) {
			System.out.println("invalid n");
			return;
		}
		while (curr != null) {
			curr = curr.next;
			prev = prev.next;
		}
		System.out.println(prev.val);
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
