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
    public int count;
    public int sumOfLeftLeaves(TreeNode root) {
        count=0;
        find(root,root);
        return count;
    }
    
    public void find(TreeNode root,TreeNode pre)
    {
        if(root==null)
            return;
        if(pre.left==root&&root.left==null&&root.right==null)
        {
            count+=root.val;
            return;
        }
        find(root.left,root);
        find(root.right,root);
    }
}