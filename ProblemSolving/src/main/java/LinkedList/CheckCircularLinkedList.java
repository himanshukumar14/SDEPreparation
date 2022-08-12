package LinkedList;

public class CheckCircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isCircular(ListNode head) {
		if(head == null)
			return true;
		ListNode curr = head.next;
		
		while(curr != null && curr != head) {
			curr = curr.next;
		}
		
		return curr == head;
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
