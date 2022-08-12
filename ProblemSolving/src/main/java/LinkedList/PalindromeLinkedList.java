package LinkedList;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(head));
	}

	public static boolean isPalindrome(ListNode head) {
		ListNode curr = head;
		int len = 0;
		while (curr != null) {
			curr = curr.next;
			len++;
		}

		int mid = len / 2;
		ListNode prev = null;
		curr = head;
		ListNode next = head;
		while (mid > 0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			mid--;
		}
		if (len % 2 == 1) {
			next = next.next;
		}

		while (prev != null && next != null) {
			if (prev.val != next.val) {
				return false;
			}
			prev = prev.next;
			next = next.next;
		}
		return true;
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
