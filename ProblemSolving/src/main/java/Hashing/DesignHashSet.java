package Hashing;

public class DesignHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	class MyHashSet {

		private ListNode[] list;

		/** Initialize your data structure here. */
		public MyHashSet() {
			list = new ListNode[10000];
		}

		public void add(int key) {
			int inx = getHash(key);
			if (list[inx] == null)
				list[inx] = new ListNode(-1);
			ListNode prev = find(list[inx], key);
			if (prev.next == null)
				prev.next = new ListNode(key);
		}

		public void remove(int key) {
			int inx = getHash(key);
			if (list[inx] == null)
				return;
			ListNode prev = find(list[inx], key);
			if (prev.next != null)
				prev.next = prev.next.next;
		}

		/** Returns true if this set contains the specified element */
		public boolean contains(int key) {
			int inx = getHash(key);
			if (list[inx] == null)
				return false;
			ListNode prev = find(list[inx], key);
			if (prev.next != null)
				return true;
			return false;
		}

		public int getHash(int key) {
			return Integer.hashCode(key) % 10000;
		}

		public ListNode find(ListNode node, int key) {
			ListNode curr = node;
			ListNode prev = null;
			while (curr != null && curr.val != key) {
				prev = curr;
				curr = curr.next;
			}
			return prev;
		}
	}
}
