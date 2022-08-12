package LinkedList;

public class MiddleElementOfLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getMiddle(ListNode list) {
		ListNode slow = list;
		ListNode fast = list;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow.val;
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
