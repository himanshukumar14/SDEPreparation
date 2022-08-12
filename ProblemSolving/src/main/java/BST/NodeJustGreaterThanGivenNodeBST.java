package BST;

import java.util.Stack;

public class NodeJustGreaterThanGivenNodeBST {
	public static void main(String[] args) {

	}

	// with space
	public static TreeNode nextGreater(TreeNode a, int b) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode cur = a;
		while (cur != null || !st.isEmpty()) {
			if (cur != null) {
				st.push(cur);
				cur = cur.left;
			} else {
				TreeNode temp = st.pop();
				if (temp.val > b) {
					return temp;
				}
				cur = temp.right;
			}
		}
		return null;
	}

	// without space
	public TreeNode getSuccessor(TreeNode a, int b) {
		if (a == null)
			return null;
		TreeNode itr = a;
		TreeNode an = null;
		while (itr != null) {
			if (itr.val == b)
				break;
			else if (itr.val > b) {
				an = itr;
				itr = itr.left;
			} else
				itr = itr.right;
		}
		if (itr.right != null) {
			itr = itr.right;
			while (itr.left != null)
				itr = itr.left;
			return itr;
		}
		return an;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}
