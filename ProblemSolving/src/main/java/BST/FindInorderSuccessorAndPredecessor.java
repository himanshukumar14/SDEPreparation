package BST;

public class FindInorderSuccessorAndPredecessor {

	public static void main(String[] args) {
		int key = 80;

		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);

		findPreSuc(root, key);
		System.out.println(pre.val);
		System.out.println(suc.val);
	}

	public static TreeNode pre = new TreeNode(-1), suc = new TreeNode(-1);

	public static void findPreSuc(TreeNode root, int key) {
		if (root == null)
			return;

		if (root.val == key) {
			if (root.left != null) {
				TreeNode tmp = root.left;
				while (tmp.right != null)
					tmp = tmp.right;
				pre = tmp;
			}
			if (root.right != null) {
				TreeNode tmp = root.right;
				while (tmp.left != null)
					tmp = tmp.left;
				suc = tmp;
			}
			return;
		}

		if (root.val > key) {
			suc = root;
			findPreSuc(root.left, key);
		} else {
			pre = root;
			findPreSuc(root.right, key);
		}
	}

	static class TreeNode {
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
