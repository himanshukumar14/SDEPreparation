package LinkedList;

/**
 * 
 * Given a singly linked list A and an integer B, reverse the nodes of the list
 * B at a time and return the modified linked list.
 * 
 * 
 * 
 * Problem Constraints 1 <= |A| <= 103
 * 
 * B always divides A
 * 
 * 
 * 
 * Input Format The first argument of input contains a pointer to the head of
 * the linked list.
 * 
 * The second arugment of input contains the integer, B.
 * 
 * 
 * 
 * Output Format Return a pointer to the head of the modified linked list.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 2, 3, 4, 5, 6] B = 2 Input 2:
 * 
 * A = [1, 2, 3, 4, 5, 6] B = 3
 * 
 * 
 * Example Output Output 1:
 * 
 * [2, 1, 4, 3, 6, 5] Output 2:
 * 
 * [3, 2, 1, 6, 5, 4]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * For the first example, the list can be reversed in groups of 2. [[1, 2], [3,
 * 4], [5, 6]] After reversing the K-linked list [[2, 1], [4, 3], [6, 5]]
 * Explanation 2:
 * 
 * For the second example, the list can be reversed in groups of 3. [[1, 2, 3],
 * [4, 5, 6]] After reversing the K-linked list [[3, 2, 1], [6, 5, 4]]
 *
 * 
 */

public class KReverseLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode kreverse(ListNode A, int k) {
		ListNode head = A;
		ListNode start = A;
		ListNode prev = null;
		ListNode next = A;
		ListNode end = A;

		while (start != null) {
			end = start;
			for (int i = 1; i < k && end.next != null; ++i) {
				end = end.next;
			}
			next = end.next;
			reverse(start, k);
			if (prev == null)
				head = end;
			else
				prev.next = end;
			start.next = next;
			prev = start;
			start = next;
		}
		return head;
	}

	public void reverse(ListNode start, int B) {
		ListNode prev = null;
		ListNode curr = start;
		ListNode next = start;

		while (B > 0 && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			B--;
		}
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
