package LinkedList;

/**
 * 
 * Given a singly linked list A
 * 
 * A: A0 → A1 → … → An-1 → An reorder it to:
 * 
 * A0 → An → A1 → An-1 → A2 → An-2 → … You must do this in-place without
 * altering the nodes' values.
 * 
 * Problem Constraints 1 <= |A| <= 106
 * 
 * Input Format The first and the only argument of input contains a pointer to
 * the head of the linked list A.
 * 
 * Output Format Return a pointer to the head of the modified linked list.
 * 
 * Example Input Input 1:
 * 
 * A = [1, 2, 3, 4, 5] Input 2:
 * 
 * A = [1, 2, 3, 4]
 * 
 * Example Output Output 1:
 * 
 * [1, 5, 2, 4, 3] Output 2:
 * 
 * [1, 4, 2, 3]
 * 
 * Example Explanation Explanation 1:
 * 
 * The array will be arranged to [A0, An, A1, An-1, A2]. Explanation 2:
 * 
 * The array will be arranged to [A0, An, A1, An-1, A2].
 *
 * 
 */

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reorder(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		ListNode prevSlow = null;

		while (fast != null && fast.next != null) {
			prevSlow = slow;
			fast = fast.next.next;
			slow = slow.next;

		}
		if (fast != null) {
			prevSlow = slow;
			slow = slow.next;
		}
		prevSlow.next = null;
		ListNode back = reverse(slow);
		ListNode front = A;
		ListNode back2 = back;
		ListNode front2 = front;

		while (front != null && back != null) {
			front2 = front.next;
			front.next = back;
			back2 = back.next;
			back.next = front2;
			front = front2;
			back = back2;
		}
		return A;
	}

	public ListNode reverse(ListNode A) {
		ListNode prev = null;
		ListNode curr = A;
		ListNode next = A;

		while (curr != null) {
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
