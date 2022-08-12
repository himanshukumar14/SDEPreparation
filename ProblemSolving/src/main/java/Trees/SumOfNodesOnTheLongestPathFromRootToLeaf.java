package Trees;

/**
 * 
 * Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of all nodes on the longest path from root to leaf node.
If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

Example 1:

Input: 
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3    
      /
     6
Output: 13
Explanation:
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3 
      /
     6

The highlighted nodes (4, 2, 1, 6) above are 
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13
 *
 */

public class SumOfNodesOnTheLongestPathFromRootToLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] recur(TreeNode root) {
		if(root == null)
			return new int[] {0, 0};
		
		int[] left = recur(root.left);
		int[] right = recur(root.right);
		
		int[] curr = new int[2];
		if(left[0] > right[0]) {
			 curr[0] = left[0] + 1;
			 curr[1] = left[1] + root.val;
		} else if(left[0] == right[0] && left[1] > right[1]) {
			 curr[0] = left[0] + 1;
			 curr[1] = left[1] + root.val;
		}else if(left[0] == right[0] && left[1] < right[1]) {
			 curr[0] = right[0] + 1;
			 curr[1] = right[1] + root.val;
		} else {
			 curr[0] = right[0] + 1;
			 curr[1] = right[1] + root.val;
		}
		return curr;
	}
}
