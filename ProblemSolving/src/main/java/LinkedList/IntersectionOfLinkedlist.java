package LinkedList;

public class IntersectionOfLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		int l1 = 0;
		int l2 = 0;

		ListNode list1 = a;
		ListNode list2 = b;

		while (list1 != null) {
			list1 = list1.next;
			l1++;
		}

		while (list2 != null) {
			list2 = list2.next;
			l2++;
		}

		list1 = a;
		list2 = b;
		if (l1 >= l2) {
			int diff = l1 - l2;
			while (diff > 0 && list1 != null) {
				list1 = list1.next;
				diff--;
			}
		} else {
			int diff = l2 - l1;
			while (diff > 0 && list2 != null) {
				list2 = list2.next;
				diff--;
			}
		}

		while (list1 != null && list2 != null) {
			if (list1 == list2)
				return list1;
			list1 = list1.next;
			list2 = list2.next;
		}
		return null;
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
