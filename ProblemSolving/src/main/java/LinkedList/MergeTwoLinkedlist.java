package LinkedList;

// linked list has a better affenation towards merge sort
public class MergeTwoLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode list1 = A;
		ListNode list2 = B;
		ListNode list3 = new ListNode(-1);
		ListNode merged = list3;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				list3.next = list1;
				list1 = list1.next;
			} else {
				list3.next = list2;
				list2 = list2.next;
			}
			list3 = list3.next;
		}

		while (list1 != null) {
			list3.next = list1;
			list1 = list1.next;
			list3 = list3.next;
		}

		while (list2 != null) {
			list3.next = list2;
			list2 = list2.next;
			list3 = list3.next;
		}
		return merged.next;
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
