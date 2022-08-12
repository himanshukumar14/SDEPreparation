package LinkedList;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	public ListNode addTwoLists(ListNode first, ListNode second) {
		first = reverse(first);
		second = reverse(second);
		ListNode temp1 = first;
		ListNode temp2 = second;
		ListNode add = new ListNode(-1);
		ListNode ans = add;
		int carry = 0;
		int sum = 0;
		while (temp1 != null || temp2 != null) {
			sum = (temp1 != null ? temp1.val : 0) + (temp2 != null ? temp2.val : 0) + carry;
			ans.next = new ListNode(sum % 10);
			ans = ans.next;
			carry = sum / 10;
			temp1 = temp1 != null ? temp1.next : temp1;
			temp2 = temp2 != null ? temp2.next : temp2;
		}

		if (carry > 0) {
			ans.next = new ListNode(carry);
			ans = ans.next;
		}

		add = reverse(add.next);
		return add;
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
