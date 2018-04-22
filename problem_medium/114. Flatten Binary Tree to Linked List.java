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
    
    private TreeNode pre=null;
    
    public void flatten(TreeNode root) {
        flat(root);
    }
    
    public void flat(TreeNode root)
    {
        if(root!=null)
        {
            flat(root.right);
            flat(root.left);
            root.right=pre;
            root.left=null;
            pre=root;
        }
    }
}