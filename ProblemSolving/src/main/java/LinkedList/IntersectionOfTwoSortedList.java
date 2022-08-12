package LinkedList;

/**
 * 
 * Given two lists sorted in increasing order, create a new list representing the intersection of the two lists. 
 * The new list should be made with its own memory — the original lists should not be changed.
Note: The list elements are not necessarily distinct.

Example 1:

Input:
L1 = 1->2->3->4->6
L2 = 2->4->6->8
Output: 2 4 6
Explanation: For the given first two
linked list, 2, 4 and 6 are the elements
in the intersection.
Example 2:

Input:
L1 = 10->20->40->50
L2 = 15->40
Output: 40
 *
 */

public class IntersectionOfTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode sortedIntersect(ListNode a, ListNode b) {
		ListNode temp1 = a;
		ListNode temp2 = b;
		ListNode inter = new ListNode(-1);
		ListNode ans = inter;

		while (temp1 != null && temp2 != null) {
			if (temp1.val < temp2.val) {
				while (temp1 != null && temp1.val < temp2.val) {
					temp1 = temp1.next;
				}
			} else if (temp2.val < temp1.val) {
				while (temp2 != null && temp2.val < temp1.val) {
					temp2 = temp2.next;
				}
			} else {
				ans.next = new ListNode(temp1.val);
				ans = ans.next;
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		return inter.next;
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
