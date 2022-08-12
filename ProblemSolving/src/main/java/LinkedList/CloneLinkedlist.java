package LinkedList;

public class CloneLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode cloneList(ListNode A) {
	    ListNode curr = A;
	    
	    while(curr != null) {
	    	ListNode temp = new ListNode(curr.val);
	    	temp.next = curr.next;
	    	curr.next = temp;
	    	curr = curr.next.next;
	    }
	    curr = A;
	    while(curr != null) {
	    	curr.next.random = curr.random != null ? curr.random.next : null;
	    	curr = curr.next.next;
	    }
	    curr = A;
	    ListNode copy = curr.next;
	    ListNode next = copy;

	    while(curr != null) {
	    	curr.next = curr.next.next;
	    	next.next = next.next != null ? next.next.next : null;
	    	curr = curr.next;
	    	next = next.next;
	    }
	    return copy;
	}

	class ListNode {
		int val;
		ListNode next, random;

		ListNode(int x) {
			val = x;
			next = random = null;
		}
	}
}
