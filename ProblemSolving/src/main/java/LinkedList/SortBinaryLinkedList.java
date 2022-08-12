package LinkedList;

/*Problem Description

Given a Linked List A consisting of N nodes.

The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.

You need to sort the linked list and return the new linked list.

NOTE:

Try to do it in constant space.

Problem Constraints
1 <= N <= 105

A.val = 0 or A.val = 1

Input Format
First and only argument is the head pointer of the linkedlist A.

Output Format
Return the head pointer of the new sorted linked list.

Example Input
Input 1:
 1 -> 0 -> 0 -> 1
 
Input 2:
 0 -> 0 -> 1 -> 1 -> 0

Example Output
Output 1:
 0 -> 0 -> 1 -> 1

Output 2:
 0 -> 0 -> 0 -> 1 -> 1

Example Explanation
Explanation 1:
 The sorted linked list looks like:
  0 -> 0 -> 1 -> 1
Explanation 2:
 The sorted linked list looks like:
  0 -> 0 -> 0 -> 1 -> 1*/

public class SortBinaryLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode solve(ListNode A) {
		ListNode zero = new ListNode(-1);
		ListNode one = new ListNode(-1);
		ListNode ans1 = zero;
		ListNode ans2 = one;
		ListNode curr = A;

		while (curr != null) {
			if (curr.val == 0) {
				zero.next = curr;
				zero = zero.next;
			} else {
				one.next = curr;
				one = one.next;
			}
			curr = curr.next;
		}
		zero.next = ans2.next;
		one.next = null;

		return ans1.next;
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
