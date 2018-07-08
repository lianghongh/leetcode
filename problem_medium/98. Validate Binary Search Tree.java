/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int pre=-1;
    public boolean isValidBST(TreeNode root) {
        if(root!=null)
        {
            boolean b1=isValidBST(root.left);
            if(pre!=-1&&pre>=root.val)
                return false;
            pre=root.val;
            return b1&&isValidBST(root.right);
        }
        
        return true;
    }
}