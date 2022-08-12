package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FlattenLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// TC = O (N * N * M) SC = O(N * M)
	public ListNode flatten(ListNode root) {
		if (root == null || root.right == null)
			return root;
		return merge(root, flatten(root.right));
	}

	public ListNode merge(ListNode node1, ListNode node2) {
		if (node1 == null)
			return node2;

		if (node2 == null)
			return node1;

		ListNode result = null;
		if (node1.val <= node2.val) {
			result = node1;
			result.down = merge(node1.down, node2);
		} else {
			result = node2;
			result.down = merge(node2.down, node1);
		}
		return result;
	}

	// TC = O (N * M * logN)
	public ListNode flatten2(ListNode root) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});
		if (root == null)
			return root;
		ListNode result = new ListNode(-1);
		ListNode temp = result;
		pq.add(root);
		while (!pq.isEmpty()) {
			ListNode curr = pq.poll();
			if (curr.right != null)
				pq.add(curr.right);
			if (curr.down != null)
				pq.add(curr.down);
			result.down = new ListNode(curr.val);
			result = result.down;
		}
		return temp.down;
	}

	class ListNode {
		int val;
		ListNode right, down;

		ListNode(int x) {
			val = x;
			right = down = null;
		}
	}

}
