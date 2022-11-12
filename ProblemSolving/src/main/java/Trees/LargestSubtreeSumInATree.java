package Trees;

public class LargestSubtreeSumInATree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int max = Integer.MIN_VALUE;
	public int recur(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = recur(root.left);
		int right = recur(root.right);
		int t = left + right + root.val;
		if(t > max) {
			max = t;
		}
		return t;
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}

}
