package Trees;

public class GenerateMirrorOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode mirrorify(TreeNode root) {
		if (root == null)
			return null;
		// Create new mirror node from original tree node
		TreeNode mirror = new TreeNode(root.val);
		mirror.right = mirrorify(root.left);
		mirror.left = mirrorify(root.right);
		return mirror;
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}

}
