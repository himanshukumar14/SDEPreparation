package LinkedList;

/**
 * 
 * Merge sort is often preferred for sorting a linked list. The slow
 * random-access performance of a linked list makes some other algorithms (such
 * as quicksort) perform poorly, and others (such as heapsort) completely
 * impossible.
 * 
 */

public class MergeSortLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode mergeSort(ListNode head) {
		// add your code here
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMiddle(head);
		ListNode midNext = mid.next;
		mid.next = null;

		ListNode left = mergeSort(head);
		ListNode right = mergeSort(midNext);
		ListNode sorted = sortedMerge(left, right);
		return sorted;
	}

	public static ListNode getMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static ListNode sortedMerge(ListNode list1, ListNode list2) {
		ListNode merge = new ListNode(-1);
		ListNode ans = merge;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				ans.next = list1;
				list1 = list1.next;
			} else {
				ans.next = list2;
				list2 = list2.next;
			}
			ans = ans.next;
		}

		while (list1 != null) {
			ans.next = list1;
			ans = ans.next;
			list1 = list1.next;
		}
		while (list2 != null) {
			ans.next = list2;
			ans = ans.next;
			list2 = list2.next;
		}
		ans.next = null;
		return merge.next;
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
