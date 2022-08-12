package LinkedList;

public class ReverseLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverse(ListNode A) {
		ListNode prev = null;
		ListNode curr = A;
		ListNode next = A;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
