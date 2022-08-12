package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBalancedBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode mergeTwoTrees(TreeNode root1, TreeNode root2) {
		List<Integer> l1 = inOrderUtil(root1);
		List<Integer> l2 = inOrderUtil(root2);
		List<Integer> l3 = mergeUtil(l1, l2);
		return sortedArrayToBSTUtil(l3);
	}
	
	public List<Integer> mergeUtil(List<Integer> l1, List<Integer> l2) {
		int i = 0;
		int j = 0;
		List<Integer> l3 = new ArrayList<>();
		while(i < l1.size() && j < l2.size()) {
			if(l1.get(i) < l2.get(j)) {
				l3.add(l1.get(i));
				i++;
			} else {
				l3.add(l2.get(j));
				j++;
			}
		}
		
		while(i < l1.size()) {
			l3.add(l1.get(i));
			i++;
		}
		
		while(j < l2.size()) {
			l3.add(l2.get(j));
			j++;
		}
		return l3;
	}
	
	public TreeNode sortedArrayToBSTUtil(List<Integer> A) {
		int n = A.size();
		return buildTree(A, 0, n - 1);
	}

	public TreeNode buildTree(List<Integer> A, int l, int r) {
		if (l > r)
			return null;
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(A.get(mid));
		root.left = buildTree(A, l, mid - 1);
		root.right = buildTree(A, mid + 1, r);
		return root;
	}

	public List<Integer> inOrderUtil(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> ans = new ArrayList<>();
		
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.add(root);
				root = root.left;
			} else {
				TreeNode temp = stack.pop();
				ans.add(temp.val);
				root = temp.right;
			}
		}
		return ans;
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
