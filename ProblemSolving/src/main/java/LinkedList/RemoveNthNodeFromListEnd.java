package LinkedList;

public class RemoveNthNodeFromListEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeNthFromEnd(ListNode A, int B) {
		ListNode prev = A;
		ListNode curr = A;
		
		while(B > 0 && curr != null) {
			curr = curr.next;
			B--;
		}
		
        if(curr == null) {
            return A.next;
        }
		
		while(curr.next != null) {
			curr = curr.next;
			prev = prev.next;
		}
		
		prev.next = prev.next.next;
		return A;
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
