package Trees;

/**
 * 
 * Given a Binary Tree, check if all leaves are at same level or not. 

          12
        /    \
      5       7       
    /          \ 
   3            1
  Leaves are at same level

          12
        /    \
      5       7       
    /          
   3          
   Leaves are Not at same level


          12
        /    
      5             
    /   \        
   3     9
  /      /
 1      2
 Leaves are at same level
 *
 */

public class LeafAtSameLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkLeaf(TreeNode root, int level, Integer leafLevel) {
		if (root == null)
			return true;
		if(root.left == null && root.right == null) {
			if(leafLevel == 0) {
				leafLevel = level;
				return true;
			} 
			return level == leafLevel;
		}
		return checkLeaf(root.left, level + 1, leafLevel) && checkLeaf(root.right, level + 1, leafLevel);
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}
}
