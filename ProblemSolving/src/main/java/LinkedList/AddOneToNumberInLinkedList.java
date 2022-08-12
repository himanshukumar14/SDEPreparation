package LinkedList;

public class AddOneToNumberInLinkedList {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(9);
		node.next.next = new ListNode(9);
		node.next.next.next = new ListNode(9);

		ListNode ans = addOne(node);

		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = head;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static ListNode addOne(ListNode head) {
		head = reverse(head);
		ListNode temp = null;
		ListNode res = head;
		int carry = 1;
		int sum = 0;

		while (head != null) {
			sum = head.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			head.val = sum;
			temp = head;
			head = head.next;
		}

		if (carry > 0) {
			ListNode node = new ListNode(carry);
			temp.next = node;
		}

		head = reverse(res);
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
