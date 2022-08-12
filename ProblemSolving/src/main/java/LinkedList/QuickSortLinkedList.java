package LinkedList;

public class QuickSortLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// takes first and last node,
	// but do not break any links in
	// the whole linked list
	public ListNode paritionLast(ListNode start, ListNode end) {
		if (start == end || start == null || end == null)
			return start;

		ListNode pivot_prev = start;
		ListNode curr = start;
		int pivot = end.val;

		// iterate till one before the end,
		// no need to iterate till the end
		// because end is pivot
		while (start != end) {
			if (start.val < pivot) {
				// keep tracks of last modified item
				pivot_prev = curr;
				int temp = curr.val;
				curr.val = start.val;
				start.val = temp;
				curr = curr.next;
			}
			start = start.next;
		}

		// swap the position of curr i.e.
		// next suitable index and pivot
		int temp = curr.val;
		curr.val = pivot;
		end.val = temp;

		// return one previous to current
		// because current is now pointing to pivot
		return pivot_prev;
	}

	public void sort(ListNode start, ListNode end) {
		if (start == null || start == end || start == end.next)
			return;

		// split list and partition recurse
		ListNode pivot_prev = paritionLast(start, end);
		sort(start, pivot_prev);

		// if pivot is picked and moved to the start,
		// that means start and pivot is same
		// so pick from next of pivot
		if (pivot_prev != null && pivot_prev == start)
			sort(pivot_prev.next, end);

		// if pivot is in between of the list,
		// start from next of pivot,
		// since we have pivot_prev, so we move two nodes
		else if (pivot_prev != null && pivot_prev.next != null)
			sort(pivot_prev.next.next, end);
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
