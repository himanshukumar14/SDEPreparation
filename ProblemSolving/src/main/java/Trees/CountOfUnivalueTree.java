package Trees;

/**
 * 
 * Given a binary tree, write a program to count the number of Single Valued Subtrees. 
 * A Single Valued Subtree is one in which all the nodes have same value. Expected time complexity is O(n).
Example: 

Input: root of below tree
              5
             / \
            1   5
           / \   \
          5   5   5
Output: 4
There are 4 subtrees with single values.


Input: root of below tree
              5
             / \
            4   5
           / \   \
          4   4   5                
Output: 5
There are five subtrees with single values.
 *
 */

public class CountOfUnivalueTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int count = 0;
    public boolean countSingleRec(TreeNode node){
        if (node == null)
            return true;

        boolean left = countSingleRec(node.left);
        boolean right = countSingleRec(node.right);

        if (left == false || right == false)
            return false;

        if (node.left != null && node.data != node.left.data)
            return false;
  
        if (node.right != null && node.data != node.right.data)
            return false;
 
        count++;
        return true;
    }
    
    class TreeNode {
    	int data;
    	TreeNode left;
    	TreeNode right;
    }

}
