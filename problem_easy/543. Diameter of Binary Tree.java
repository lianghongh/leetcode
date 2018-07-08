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
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        max_depth(root);
        return max;
    }
    
    public int max_depth(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=max_depth(root.left);
        int right=max_depth(root.right);
        if(left+right>max)
            max=left+right;
        return (left<right?right:left)+1;
    }
}