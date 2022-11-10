package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*Consider lines of slope -1 passing between nodes.

Given a Binary Tree A containing N nodes, return all diagonal elements in a binary tree belonging to same line.

NOTE:

See Sample Explanation for better understanding.
Order does matter in the output.
To get the same order as in the output traverse the tree same as we do in pre-order traversal.


Problem Constraints
0 <= N <= 105



Input Format
First and only Argument represents the root of binary tree A.



Output Format
Return a 1D array denoting the diagonal traversal of the tree.



Example Input
Input 1:

            1
          /   \
         4      2
        / \      \
       8   5      3
          / \    /
         9   7  6
Input 2:

             11
          /     \
         20      12
        / \       \
       1   15      13
          /  \     /
         2    17  16
          \   /
          22 34


Example Output
Output 1:

 [1, 2, 3, 4, 5, 7, 6, 8, 9]
Output 2:

 [11, 12, 13, 20, 15, 17, 16, 1, 2, 22, 34]
*/

public class DiagonalTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> printDiagonal(TreeNode root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		printDiagonalUtil(root, 0, map);
		ArrayList<Integer> ans = new ArrayList<>();
		for (int val : map.keySet()) {
			List<Integer> l = map.get(val);
			for (int t : l)
				ans.add(t);
		}
		return ans;
	}

	public void printDiagonalUtil(TreeNode root, int index, Map<Integer, List<Integer>> map) {
		if (root == null)
			return;
		List<Integer> temp = map.getOrDefault(index, new ArrayList<>());
		temp.add(root.val);
		map.put(index, temp);
		printDiagonalUtil(root.left, index + 1, map);
		printDiagonalUtil(root.right, index, map);
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
