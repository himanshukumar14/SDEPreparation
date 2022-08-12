package Trees;

public class MirrorImageOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree1 = new TreeNode(1);
		tree1.left = new TreeNode(2);
		tree1.right = new TreeNode(3);
		tree1.left.left = new TreeNode(4);
		tree1.right.right = new TreeNode(7);
		tree1.left.right = new TreeNode(5);
		tree1.right.left = new TreeNode(6);

		TreeNode tree2 = new TreeNode(1);
		tree2.left = new TreeNode(3);
		tree2.right = new TreeNode(2);
		tree2.left.left = new TreeNode(7);
		tree2.right.right = new TreeNode(4);
		tree2.left.right = new TreeNode(6);
		tree2.right.left = new TreeNode(5);

		if (isMirror(tree1, tree2) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static boolean isMirror(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return true;
		if (A == null || B == null)
			return false;

		boolean left = isMirror(A.left, B.right);
		boolean right = isMirror(A.right, B.left);

		return left && right && A.val == B.val;
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			left = null;
			right = null;
			this.val = val;
		}
	}
}
