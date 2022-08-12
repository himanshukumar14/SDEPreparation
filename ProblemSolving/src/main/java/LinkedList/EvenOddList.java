package LinkedList;

/**
 * 
 * Given a link list of size N, modify the list such that all the even numbers
 * appear before all the odd numbers in the modified list. The order of
 * appearance of numbers within each segregation should be same as that in the
 * original list.
 * 
 * NOTE: Don't create a new linked list, instead rearrange the provided one.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 7 Link List: 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
 * 
 * Output: 8 2 4 6 17 15 9
 * 
 * Explaination: 8,2,4,6 are the even numbers so they appear first and 17,15,9
 * are odd numbers that appear later.
 *
 */

public class EvenOddList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode evenOdd(ListNode head) {
		ListNode temp = head;
		ListNode even = new ListNode(-1);
		ListNode evenp = even;
		ListNode odd = new ListNode(-1);
		ListNode oddp = odd;

		while (temp != null) {
			if (temp.val % 2 == 0) {
				evenp.next = temp;
				evenp = evenp.next;
			} else {
				oddp.next = temp;
				oddp = oddp.next;
			}
			temp = temp.next;
		}
		evenp.next = odd.next;
		oddp.next = null;
		return even.next;
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
