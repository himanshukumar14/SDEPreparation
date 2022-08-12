package Hashing;

public class DesignHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class ListNode {
		int key;
		int val;
		ListNode next;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
			this.next = null;
		}
	}

	class MyHashMap {

		ListNode[] list = null;

		/** Initialize your data structure here. */
		public MyHashMap() {
			list = new ListNode[10000];
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			int inx = getHash(key);

			if (list[inx] == null)
				list[inx] = new ListNode(-1, -1);

			ListNode prev = find(list[inx], key);
			if (prev.next == null) {
				prev.next = new ListNode(key, value);
			} else
				prev.next.val = value;
		}

		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map
		 * contains no mapping for the key
		 */
		public int get(int key) {
			int inx = getHash(key);
			if (list[inx] == null)
				return -1;
			ListNode node = find(list[inx], key);
			return node.next == null ? -1 : node.next.val;
		}

		/**
		 * Removes the mapping of the specified value key if this map contains a mapping
		 * for the key
		 */
		public void remove(int key) {
			int inx = getHash(key);
			if (list[inx] == null)
				return;
			ListNode node = find(list[inx], key);
			if (node.next != null)
				node.next = node.next.next;
		}

		public int getHash(int key) {
			return Integer.hashCode(key) % 10000;
		}

		public ListNode find(ListNode p, int key) {
			ListNode node = p;
			ListNode prev = null;
			while (node != null && node.key != key) {
				prev = node;
				node = node.next;
			}
			return prev;
		}

	}

}
