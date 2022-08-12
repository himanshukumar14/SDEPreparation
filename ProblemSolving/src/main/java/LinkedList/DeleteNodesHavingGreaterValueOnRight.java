package LinkedList;

/**
 * 
 * Given a singly linked list, remove all the nodes which have a greater value on their right side.

Example 1:

Input:
LinkedList = 12->15->10->11->5->6->2->3
Output: 15 11 6 3
Explanation: Since, 12, 10, 5 and 2 are
the elements which have greater elements
on the following nodes. So, after deleting
them, the linked list would like be 15,
11, 6, 3.
Example 2:

Input:
LinkedList = 10->20->30->40->50->60
Output: 60
 *
 */

public class DeleteNodesHavingGreaterValueOnRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteNodes(ListNode head) {
		if(head.next == null)
			return head;
		ListNode rev = reverse(head);
		int max = rev.val;
		ListNode curr = rev.next;
		ListNode prev = rev;
		
		while(curr != null) {
			if(curr.val < max) {
				prev.next = curr.next;
			} else {
				max = curr.val;
				prev = curr;
			}
			curr = curr.next;
		}
		head = reverse(rev);
		return head;
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

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
