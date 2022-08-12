package BST;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt("&"));
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	public void serialize(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.val).append(",");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;
		Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public TreeNode deserialize(Queue<String> q, int l, int r) {
		if (q.isEmpty())
			return null;
		int val = Integer.parseInt(q.peek());
		if (val < l || val > r)
			return null;
		q.poll();
		TreeNode root = new TreeNode(val);
		root.left = deserialize(q, l, val);
		root.right = deserialize(q, val, r);
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}

}
