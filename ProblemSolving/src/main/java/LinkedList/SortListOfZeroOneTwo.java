package LinkedList;

public class SortListOfZeroOneTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode solve(ListNode A) {
		ListNode zero = new ListNode(-1);
		ListNode one = new ListNode(-1);
		ListNode two = new ListNode(-1);
		ListNode ans1 = zero;
		ListNode ans2 = one;
		ListNode ans3 = two;
		ListNode curr = A;

		while (curr != null) {
			if (curr.val == 0) {
				zero.next = curr;
				zero = zero.next;
			} else if (curr.val == 1) {
				one.next = curr;
				one = one.next;
			} else {
				two.next = curr;
				two = two.next;
			}
			curr = curr.next;
		}
		zero.next = ans2.next != null ? ans2.next : ans3.next;
		one.next = ans3.next;
		two.next = null;
		return ans1.next;
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
